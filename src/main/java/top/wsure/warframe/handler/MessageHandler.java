package top.wsure.warframe.handler;

import org.apache.commons.collections.CollectionUtils;
import top.wsure.warframe.core.MessageBuilder;
import top.wsure.warframe.entity.CommandDo;
import top.wsure.warframe.utils.CommandUtils;

import java.util.List;

import static top.wsure.warframe.Bot.*;

/**
 * FileName: MessageHandler
 * Author:   wsure
 * Date:     2020/1/17 下午2:53
 * Description:
 */
public class MessageHandler extends AbstractHandler{

    private static class MessageHandlerHolder {
        private static final MessageHandler INSTANCE = new MessageHandler();
    }

    private MessageHandler (){}

    public static final MessageHandler getInstance() {
        return MessageHandlerHolder.INSTANCE;
    }
    private String test;

    @Override
    public void onPrivateMsg(int subType, int msgId, long fromQQ, String msg, int font) {
        List<CommandDo> commands = CommandUtils.getCommand(msg);

        CQ.logInfo("getCommand", commands.toString());
        if(CollectionUtils.isNotEmpty(commands)){
            commands.forEach( cmd ->{
                CQ.sendPrivateMsg(fromQQ,new MessageBuilder(cmd).build().message());
            });
        }
    }

    @Override
    public void onGroupMsg(int subType, int msgId, long fromGroup, long fromQQ, String fromAnonymous, String msg, int font) {
        List<CommandDo> commands = CommandUtils.getCommand(msg);

        CQ.logInfo("getCommand", commands.toString());
        if(CollectionUtils.isNotEmpty(commands)){
            commands.forEach( cmd ->{
                CQ.sendGroupMsg(fromGroup,CC.at(fromQQ) + new MessageBuilder(cmd).build().message());
            });
        }
    }
}
