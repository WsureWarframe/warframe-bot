package top.wsure.warframe.after;

import lombok.extern.java.Log;
import top.wsure.bot.common.annotation.ApiAfter;
import top.wsure.bot.common.annotation.BotApiAfterDo;
import top.wsure.bot.common.cache.CacheManagerImpl;
import top.wsure.bot.common.enums.CacheEnum;
import top.wsure.bot.common.enums.CacheFlagEnum;

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
