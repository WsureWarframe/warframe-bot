package top.wsure.warframe.component.warframe;

import top.wsure.bot.common.annotation.BotEvent;
import top.wsure.bot.common.annotation.BotEventType;
import top.wsure.bot.common.enums.CommandAuthorityEnum;
import top.wsure.bot.entity.CommandDo;
import top.wsure.bot.entity.MessageDo;
import top.wsure.bot.common.enums.EventsEnum;

/**
 * FileName: WikiInfo
 * Author:   Administrator
 * Date:     2020-4-23
 * Description: rivenMarket查询模块
 */
@BotEvent(name = "rm",level = CommandAuthorityEnum.MEMBER)
public class RmInfo extends WarframeBase {

    @BotEventType(alias = "rm",type ={ EventsEnum.GROUP_MSG,EventsEnum.PRIVATE_MSG})
    public int execute(MessageDo msg, CommandDo cmd){
        return super.execute(msg,cmd);
    }
}
