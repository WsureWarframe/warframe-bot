package top.wsure.warframe.component.game;

import top.wsure.warframe.common.annotation.BotEvent;
import top.wsure.warframe.common.annotation.BotEventType;
import top.wsure.warframe.common.cache.CacheManagerImpl;
import top.wsure.warframe.common.enums.CacheEnum;
import top.wsure.warframe.common.enums.CacheFlagEnum;
import top.wsure.warframe.common.enums.EventsEnum;
import top.wsure.warframe.entity.CommandDo;
import top.wsure.warframe.entity.MessageDo;

import static org.meowy.cqp.jcq.entity.IMsg.MSG_IGNORE;
import static top.wsure.warframe.Bot.CQ;
/**
 * FileName: GameComponent
 * Author:   Administrator
 * Date:     2020-4-23
 * Description: 游戏(迫害)模块
 */
@BotEvent(name = "game")
public class GameComponent {

    /**
     * 一带一路
     * @param msg
     * @param cmd
     * @return
     */
    @BotEventType(alias = "beltAndRoadInitiative",type = EventsEnum.GROUP_MSG)
    public int beltAndRoadInitiative(MessageDo msg, CommandDo cmd) {

        return MSG_IGNORE;
    }

    /**
     * 抽奖
     * @param msg
     * @param cmd
     * @return
     */
    @BotEventType(alias = "lottery",type = EventsEnum.GROUP_MSG)
    public int lottery(MessageDo msg, CommandDo cmd) {

        return MSG_IGNORE;
    }

    /**
     * 撤回！
     * @param msg
     * @param cmd
     * @return
     */
    @BotEventType(alias = "retract",type = { EventsEnum.GROUP_MSG,EventsEnum.PRIVATE_MSG})
    public int retract(MessageDo msg, CommandDo cmd) {
        CacheManagerImpl manager = CacheEnum.MESSAGE_CACHE.getManager();
        switch (msg.getEvent()){
            case PRIVATE_MSG:
                Integer delMsgId = (Integer) manager.getCacheDataByKey(CacheFlagEnum.DEL.getFlag() +msg.getFromQQ());
                if (delMsgId != null) CQ.deleteMsg(delMsgId);
                break;
            case GROUP_MSG:
                break;
        }
        return MSG_IGNORE;
    }
}
