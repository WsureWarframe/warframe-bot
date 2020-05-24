package top.wsure.warframe.component.base;

import top.wsure.bot.common.annotation.BotEvent;
import top.wsure.bot.common.annotation.BotEventType;
import top.wsure.bot.common.enums.CommandAuthorityEnum;
import top.wsure.bot.common.enums.EventsEnum;
import top.wsure.bot.entity.CommandDo;
import top.wsure.bot.entity.MessageDo;

import static org.meowy.cqp.jcq.entity.IMsg.MSG_IGNORE;
import static top.wsure.warframe.Warframebot.CQ;
import static top.wsure.bot.common.config.Constants.CC;

/**
 * FileName: GroupComponent
 * Author:   Administrator
 * Date:     2020-5-24
 * Description: 群事件处理
 */
@BotEvent(name = "group",level = CommandAuthorityEnum.MEMBER)
public class GroupComponent {

    @BotEventType(type = {EventsEnum.GROUP_ADMIN},weight = 1)
    public int groupAdmin(MessageDo msg){
        // 这里处理消息
        switch (msg.getSubType()){
            case 1:
                CQ.sendGroupMsg(msg.getFromGroup(),"恭喜"+CC.at(msg.getBeingOperateQQ())+"被下了狗管理");
                break;
            case 2:
                CQ.sendGroupMsg(msg.getFromGroup(),"恭喜"+CC.at(msg.getBeingOperateQQ())+"成为狗管理");
                break;
        }
        return MSG_IGNORE;
    }
}
