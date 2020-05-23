package top.wsure.warframe.before;

import lombok.extern.java.Log;
import top.wsure.bot.common.annotation.ApiBefore;
import top.wsure.bot.common.annotation.BotApiBeforeDo;

/**
 * FileName: BeforeSendMessage
 * Author:   Administrator
 * Date:     2020-4-23
 * Description: 发消息之前
 */
@Log
@ApiBefore(apiName = {"sendGroupMsg","sendPrivateMsg"})
public class BeforeSendMessage implements BotApiBeforeDo {
    /**
     * 返回true拦截
     * @param apiName
     * @param args
     * @return
     */
    @Override
    public boolean execute(String apiName, Object[] args) {
//        log.info("发消息之前:apiName:"+apiName);
        return false;
    }
}
