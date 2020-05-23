package top.wsure.warframe.component.game;

import org.apache.commons.collections.CollectionUtils;
import org.meowy.cqp.jcq.entity.enumerate.Authority;
import top.wsure.bot.common.annotation.BotEvent;
import top.wsure.bot.common.annotation.BotEventType;
import top.wsure.bot.common.cache.CacheManagerImpl;
import top.wsure.bot.common.enums.CacheEnum;
import top.wsure.bot.common.enums.CacheFlagEnum;
import top.wsure.bot.common.enums.CommandAuthorityEnum;
import top.wsure.bot.common.enums.EventsEnum;
import top.wsure.bot.entity.CommandDo;
import top.wsure.bot.entity.MessageDo;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.meowy.cqp.jcq.entity.IMsg.MSG_IGNORE;
import static top.wsure.warframe.Warframebot.CQ;
import static top.wsure.bot.common.config.Constants.CC;
import static top.wsure.bot.common.config.Constants.ROBOT_CONFIG;

/**
 * FileName: GameComponent
 * Author:   Administrator
 * Date:     2020-4-23
 * Description: 游戏(迫害)模块
 */
@BotEvent(name = "game",level = CommandAuthorityEnum.MEMBER)
public class GameComponent {

    /**
     * 一带一路
     * @param msg
     * @param cmd
     * @return
     */
    @BotEventType(alias = "beltAndRoadInitiative",type = EventsEnum.GROUP_MSG)
    public int beltAndRoadInitiative(MessageDo msg, CommandDo cmd) {
        if(isManager(msg.getFromGroup()))
        {
            if(isManager(msg.getFromGroup(),msg.getFromQQ()))
            {
                CQ.sendGroupMsg(msg.getFromGroup(),CC.at(msg.getFromQQ())  +"管理无法介入");
            }
            else {
                draw(msg.getMsg(),msg.getFromGroup(),msg.getFromQQ());
            }
        }
        else {
            CQ.sendGroupMsg(msg.getFromGroup(),CC.at(msg.getFromQQ()) + ROBOT_CONFIG.getRobotName() + "没有管理权限，如有需要政策扶持，请联系群主。");
        }
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
        if(isManager(msg.getFromGroup()))
        {
            if(isManager(msg.getFromGroup(),msg.getFromQQ()))
            {
                CQ.sendGroupMsg(msg.getFromGroup(),CC.at(msg.getFromQQ())  +" 管理狗无权抽奖（自裁吧");
            }
            else {
                int t = new Random().nextInt(10*60);
                CQ.setGroupBan(msg.getFromGroup(),msg.getFromQQ(),t);
                CQ.sendGroupMsg(msg.getFromGroup(),CC.at(msg.getFromQQ())  +"恭喜您，套餐已生效");
            }
        }
        else {
            CQ.sendGroupMsg(msg.getFromGroup(),CC.at(msg.getFromQQ()) + ROBOT_CONFIG.getRobotName() + " 没有管理权限，无法抽奖,如有需要请联系群主。");
        }
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
        CQ.logInfo("retract","撤回！");
        CacheManagerImpl manager = CacheEnum.MESSAGE_CACHE.getManager();
        Integer delMsgId = null ;
        switch (msg.getEvent()){
            case PRIVATE_MSG:
                delMsgId = (Integer) manager.getCacheDataByKey(CacheFlagEnum.DEL.getFlag() +msg.getFromQQ());
                break;
            case GROUP_MSG:
                delMsgId = (Integer) manager.getCacheDataByKey(CacheFlagEnum.DEL.getFlag() +msg.getFromGroup());
                break;
        }
        if(delMsgId != null){
            CQ.logInfo("msgId",delMsgId.toString());
            CQ.deleteMsg(delMsgId);
        }
        return MSG_IGNORE;
    }

    private boolean isManager(Long fromGroup){
        return isManager(fromGroup,CQ.getLoginQQ());
    }
    private boolean isManager(Long fromGroup,Long qq){
        if(CQ.getGroupMemberInfo(fromGroup,qq).getAuthority().value()> Authority.MEMBER.value()){
            return true;
        }
        return false;
    }

    public void draw(String msg,long fromGroup,long fromQQ)
    {
        StringBuilder response = new StringBuilder();
        List<Long> atQQs =CC.getAts(msg);

        atQQs = atQQs.stream().filter( qq -> !isManager(fromGroup,qq)).collect(Collectors.toList());

        int t = new Random().nextInt(10*60);
        CQ.setGroupBan(fromGroup,fromQQ,t);

        if (CollectionUtils.isNotEmpty(atQQs)){
            response.append("恭喜你成功带动了");
            atQQs.forEach( qq -> {
                CQ.setGroupBan(fromGroup,qq,t/2);
                response.append(CC.at(qq));
            });
            response.append("的经济发展，QWQ");
        } else {
            response.append("你的行动失败了，被@人中没有符合帮扶政策的群员，你将独享");
        }
        CQ.sendGroupMsg(fromGroup,response.toString());
    }

}
