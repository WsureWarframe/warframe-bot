package top.wsure.warframe.component.warframe;

import top.wsure.bot.utils.MessageBuilder;
import top.wsure.bot.entity.CommandDo;
import top.wsure.bot.entity.MessageDo;
import top.wsure.bot.common.enums.ComponentEnum;
import top.wsure.bot.common.exceptions.BotException;
import top.wsure.warframe.utils.HttpUtils;

import java.util.Collections;

import static org.meowy.cqp.jcq.entity.IMsg.MSG_IGNORE;
import static top.wsure.bot.common.config.Constants.CC;
import static top.wsure.warframe.Warframebot.CQ;
import static top.wsure.bot.common.config.Constants.ROBOT_CONFIG;

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
            builder.append(cmd.getParam());
        } else {
            builder.append(cmd.getAlia());
        }
        return builder.toString();
    }

}
