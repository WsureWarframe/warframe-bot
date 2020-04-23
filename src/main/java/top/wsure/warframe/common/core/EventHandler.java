package top.wsure.warframe.common.core;

import lombok.extern.java.Log;
import org.apache.commons.collections.CollectionUtils;
import top.wsure.warframe.common.annotation.BotEvent;
import top.wsure.warframe.common.annotation.BotEventType;
import top.wsure.warframe.entity.CommandDo;
import top.wsure.warframe.entity.MessageDo;
import top.wsure.warframe.utils.CommandUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.meowy.cqp.jcq.entity.IMsg.MSG_IGNORE;
import static top.wsure.warframe.common.config.Constants.*;

/**
 * FileName: MessageHandler
 * Author:   wsure
 * Date:     2020/1/17 下午2:53
 * Description:
 */
@Log
public class EventHandler {

    private static class EventHandlerHolder {
        private static final EventHandler INSTANCE = new EventHandler();
    }

    private EventHandler(){}

    public static final EventHandler getInstance() {
        return EventHandlerHolder.INSTANCE;
    }

    public int eventProcess(MessageDo message){
        List<CommandDo> commands = CommandUtils.getCommand(message.getMsg());
        List<Method> methods = botEventMap.get(message.getEvent().getEvent());
        if(CollectionUtils.isNotEmpty(methods)){
            commands.forEach( cmd -> methods.stream().filter(
                    method -> Arrays.asList( method.getAnnotation(BotEventType.class).alias()).contains(cmd.getAlia()) &&
                            method.getDeclaringClass().getAnnotation(BotEvent.class).name().equals(cmd.getComponentName())
            ).forEach( method -> {
                try {
//                    log.info("开始执行" + cmd.getCommand() + " " + message.getEvent().getEvent() +" 方法"+method.getName());
                    method.invoke(method.getDeclaringClass().newInstance(),message,cmd);
//                    log.info("执行结束" + cmd.getCommand() + " " + message.getEvent().getEvent() +" 方法"+method.getName());
                } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                    log.warning(cmd.getComponentName()+" > " + cmd.getCommand() + " " + message.getEvent().getEvent()+"执行失败，原因:"+e.getMessage());
                    e.printStackTrace();
                }
            }));

        }
        return MSG_IGNORE;
    }
}
