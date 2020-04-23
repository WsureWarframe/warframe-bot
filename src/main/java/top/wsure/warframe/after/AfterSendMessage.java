package top.wsure.warframe.after;

import lombok.extern.java.Log;
import sun.misc.Cache;
import top.wsure.warframe.common.annotation.ApiAfter;
import top.wsure.warframe.common.annotation.BotApiAfterDo;
import top.wsure.warframe.common.cache.CacheManagerImpl;
import top.wsure.warframe.common.enums.CacheEnum;
import top.wsure.warframe.common.enums.CacheFlagEnum;

import java.util.Arrays;

/**
 * FileName: AfterSendMessage
 * Author:   Administrator
 * Date:     2020-4-23
 * Description: 发送消息后
 */
@Log
@ApiAfter(apiName = {"sendGroupMsg","sendPrivateMsg"})
public class AfterSendMessage implements BotApiAfterDo {
    @Override
    public void execute(String apiName,Object[] args,Object result) {
//        log.info("apiName:"+apiName+" args:"+ Arrays.toString(args));
        if(result == null){
            return;
        }
        CacheManagerImpl messageCache = CacheEnum.MESSAGE_CACHE.getManager();
        if(args.length == 2)
        {
            messageCache.putCache(CacheFlagEnum.DEL.getFlag()+args[0].toString(),result,2*60*1000L);
        }
    }
}
