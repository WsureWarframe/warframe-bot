package top.wsure.warframe.utils;

import org.apache.commons.collections.CollectionUtils;
import org.meowy.cqp.jcq.entity.Group;
import org.meowy.cqp.jcq.entity.Member;
import top.wsure.warframe.entity.PersonDo;

import java.util.List;

import static top.wsure.warframe.Bot.CQ;
import static top.wsure.warframe.Bot.ROBOT_CONFIG;

/**
 * FileName: ReportUtils
 * Author:   Administrator
 * Date:     2020/1/23
 * Description: 通知相关工具
 */
public class ReportUtils {

    public static boolean reportMessageToMaster(String message){
        if(ROBOT_CONFIG == null || CollectionUtils.isEmpty(ROBOT_CONFIG.getMaster()))
            return false;
        try {

            sendPrivateToPersons(message,ROBOT_CONFIG.getMaster());

        } catch (Exception e){
            CQ.logWarning("通知主人","发送通知出现异常");
            return false;
        }

        return true;
    }

    public static boolean reportMessageToDeveloper(String message){
        if(ROBOT_CONFIG == null || CollectionUtils.isEmpty(ROBOT_CONFIG.getDev()))
            return false;
        try {

            sendPrivateToPersons(message,ROBOT_CONFIG.getDev());

        } catch (Exception e){
            CQ.logWarning("通知开发者","发送通知出现异常");
            return false;
        }

        return true;
    }

    public static boolean sendToAllGroup(String message){
        if(CollectionUtils.isEmpty(CQ.getGroupList())){
            CQ.logWarning("发送消息到所有群","群列表为空");
            return false;
        }
        try{
            sendGroupMessage(message,CQ.getGroupList());
        }catch (Exception e){
            CQ.logWarning("发送消息到所有群","发送消息出现异常");
            return false;
        }
        return true;
    }

    public static void sendPrivateToPersons(String message,List<PersonDo> list){
            list.forEach(master ->{
                CQ.sendPrivateMsg(master.getQq(),message);
            });
    }

    public static void sendPrivateToMembers(String message, List<Member> list){
        list.forEach(master ->{
            CQ.sendPrivateMsg(master.getQQId(),message);
        });
    }

    public static void sendGroupMessage(String message, List<Group> list){
        list.forEach(group -> {
            CQ.sendGroupMsg(group.getId(),message);
        });
    }

}
