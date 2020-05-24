package top.wsure.warframe.component.base;

import top.wsure.bot.common.annotation.BotEvent;
import top.wsure.bot.common.annotation.BotEventType;
import top.wsure.bot.common.enums.CommandAuthorityEnum;
import top.wsure.bot.common.enums.EventsEnum;
import top.wsure.bot.entity.CommandDo;
import top.wsure.bot.entity.MessageDo;
import top.wsure.bot.utils.ReportUtils;

import static org.meowy.cqp.jcq.entity.IMsg.MSG_IGNORE;

/**
 * FileName: BaseComponent
 * Author:   Administrator
 * Date:     2020-5-2
 * Description: 基础功能模块
 */
@BotEvent(name = "base",level = CommandAuthorityEnum.MASTER)
public class BaseComponent {

    @BotEventType(alias = "sendToAllGroup",type = {EventsEnum.GROUP_MSG,EventsEnum.PRIVATE_MSG})
    public int sendToAllGroup(MessageDo msg, CommandDo cmd){
        ReportUtils.sendToAllGroup(cmd.getParam());
        return MSG_IGNORE;
    }

}
