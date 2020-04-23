package top.wsure.warframe.common.core;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;
import org.apache.commons.collections.CollectionUtils;
import org.meowy.cqp.jcq.entity.CoolQ;
import top.wsure.warframe.common.annotation.BotApiAfterDo;
import top.wsure.warframe.common.annotation.BotApiBeforeDo;
import top.wsure.warframe.common.cache.CacheManagerImpl;
import top.wsure.warframe.common.enums.CacheEnum;
import top.wsure.warframe.common.enums.CacheFlagEnum;
import top.wsure.warframe.common.exceptions.BotException;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static top.wsure.warframe.common.config.Constants.botApiAfterMap;
import static top.wsure.warframe.common.config.Constants.botApiBeforeMap;

/**
 * FileName: WsureCQ
 * Author:   Administrator
 * Date:     2020-4-23
 * Description: 代理CoolQ
 */
public class WsureCQ implements InvocationHandler {
    private CoolQ CQ;

    private CacheManagerImpl messageCache = CacheEnum.MESSAGE_CACHE.getManager();
    public WsureCQ(CoolQ cq) {
        this.CQ = cq;
    }

    public int sendGroupMsg(long groupId, String msg) {
        int msgId = CQ.sendGroupMsg(groupId,msg);
        messageCache.putCache(CacheFlagEnum.DEL.getFlag()+groupId,msgId,60*2*1000L);
        return msgId;
    }

    public CoolQ getProxyCoolQ(){
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(CQ.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类对象代理
        return (CoolQ) en.create();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String apiName = method.getName();
        Object result = null;
        AtomicBoolean abort = new AtomicBoolean(false);
        List<Class<?>> beforeClasses = botApiBeforeMap.get(apiName);
        if(CollectionUtils.isNotEmpty(beforeClasses)){
            beforeClasses.forEach(clazz -> {
                try {
                    BotApiBeforeDo beforeDo = (BotApiBeforeDo) clazz.newInstance();
                    if (beforeDo.execute(apiName,args))
                        abort.set(true);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }
        if(abort.get()){
            CQ.logInfo("代理被阻止，代理的API："+apiName,"BotApiBeforeDo");
        } else {
            try {
                result = method.invoke(CQ,args);
            } catch (Exception e){
                throw new BotException("代理失败，代理的API："+apiName,"BotApiAfterDo");
            }
        }

        List<Class<?>> afterClasses = botApiAfterMap.get(apiName);
        if(CollectionUtils.isNotEmpty(afterClasses)){
            Object finalResult = result;
            afterClasses.forEach(clazz -> {
                try {
                    BotApiAfterDo afterDo = (BotApiAfterDo) clazz.newInstance();
                    afterDo.execute(apiName,args, finalResult);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }
        return result;
    }
}
