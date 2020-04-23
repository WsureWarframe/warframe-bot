package top.wsure.warframe.component.warframe;

import top.wsure.warframe.utils.MessageBuilder;
import top.wsure.warframe.entity.CommandDo;
import top.wsure.warframe.entity.MessageDo;
import top.wsure.warframe.enums.ComponentEnum;
import top.wsure.warframe.exceptions.BotException;
import top.wsure.warframe.utils.HttpUtils;

import java.util.Collections;

import static org.meowy.cqp.jcq.entity.IMsg.MSG_IGNORE;
import static top.wsure.warframe.config.Constants.CC;
import static top.wsure.warframe.Bot.CQ;
import static top.wsure.warframe.config.Constants.ROBOT_CONFIG;

/**
 * FileName: WarframeInfo
 * Author:   Administrator
 * Date:     2020-4-5
 * Description: wf信息查询插件基类
 */
public class WarframeBase {

    public int execute(MessageDo msg,CommandDo cmd){
        CQ.logDebug("请求参数",msg.toString());
        CQ.logInfo("getCommand", cmd.toString());
        String response = null;
        try {
            response = HttpUtils.getContextRequest(urlBuilder(cmd), Collections.EMPTY_MAP);
        } catch (BotException e) {
            response = e.getMessage();
        }
        switch (msg.getEvent()){
            case GROUP_MSG:
                CQ.sendGroupMsg(msg.getFromGroup(),new MessageBuilder(response).setPrefix(CC.at(msg.getFromQQ())).build());
                break;
            case PRIVATE_MSG:
                CQ.sendPrivateMsg(msg.getFromQQ(),new MessageBuilder(response).build());
        }
        return MSG_IGNORE;
    }

    public static String urlBuilder(CommandDo cmd) throws BotException {
        if(!ComponentEnum.isNeedNetwork(cmd.getComponentType().getType())){
            return null;
        }
        StringBuilder builder = new StringBuilder(ROBOT_CONFIG.getHost()+cmd.getComponentName());
        builder.append("/")
                .append("robot/");

        if(ComponentEnum.isNeedParam(cmd.getComponentType().getType())){
            builder.append(cmd.getAlia());
        } else {
            builder.append(cmd.getParam());
        }
        return builder.toString();
    }

}
