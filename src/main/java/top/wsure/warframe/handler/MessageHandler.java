package top.wsure.warframe.handler;

import org.apache.commons.collections.CollectionUtils;
import top.wsure.warframe.entity.CommandDo;
import top.wsure.warframe.utils.CommandUtils;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static top.wsure.warframe.WarframeBot.*;

/**
 * FileName: MessageHandler
 * Author:   wsure
 * Date:     2020/1/17 下午2:53
 * Description:
 */
public class MessageHandler extends AbstractHandler{

    private String test;

    @Override
    public void onPrivateMsg(int subType, int msgId, long fromQQ, String msg, int font) {
        List<CommandDo> commands = CommandUtils.getCommand(msg);

        CQ.logInfo("getCommand", commands.toString());
        if(CollectionUtils.isNotEmpty(commands)){
            CQ.sendPrivateMsg(fromQQ,"检测到： "+commands.stream().map(v-> "{命令="+v.getCommand()+" ,参数="+v.getParam()+"}").collect(Collectors.joining(",")));
        }
    }
}
