package top.wsure.warframe.core;

import org.apache.commons.lang3.StringUtils;
import top.wsure.warframe.entity.CommandDo;
import top.wsure.warframe.enums.ExceptionMessageEnum;
import top.wsure.warframe.exceptions.BotException;

import java.util.Collections;

import static top.wsure.warframe.Bot.CQ;
import static top.wsure.warframe.Bot.ROBOT_CONFIG;
import static top.wsure.warframe.utils.HttpUtils.getContextRequest;
import static top.wsure.warframe.utils.HttpUtils.urlBuilder;

/**
 * FileName: MessageBuilder
 * Author:   Administrator
 * Date:     2020/1/24
 * Description: 消息封装
 */
public class MessageBuilder {

    private StringBuilder prefix;
    private CommandDo commandDo;
    private StringBuilder message = new StringBuilder();

    private MessageBuilder(){}

    public MessageBuilder(CommandDo commandDo){
        this.commandDo = commandDo;
        if(ROBOT_CONFIG!=null && StringUtils.isNotBlank(ROBOT_CONFIG.getPrefix())){
            this.prefix = new StringBuilder(ROBOT_CONFIG.getPrefix()).append("\n");
        }
    }

    public MessageBuilder setPrefix(String prefix){
        this.prefix = new StringBuilder(prefix);
        return this;
    }

    public MessageBuilder disablePrefix(){
        this.prefix = new StringBuilder();
        return this;
    }

    public MessageBuilder setCommandDo(CommandDo commandDo){
        this.commandDo = commandDo;
        return this;
    }


    public MessageBuilder build(){

        message.append(this.prefix);

        if(this.commandDo.getType().isNeedNetwork()){
            networkMessageBuilder();
        } else {
            this.message.append(commandDo.getCommand());
        }
        return this;
    }

    private void networkMessageBuilder(){
        if(ROBOT_CONFIG == null || StringUtils.isBlank(ROBOT_CONFIG.getHost()))
            this.message.append(ExceptionMessageEnum.CONFIG_BLANK.getVar());
        else{
            try{
                this.message.append(
                        getContextRequest(
                                urlBuilder(ROBOT_CONFIG.getHost(),this.commandDo),
                                Collections.emptyMap()
                        )
                );
            } catch (BotException e) {
                CQ.logWarning(this.getClass().getSimpleName(),e);
                this.message.append(e.getMessage());
            }
        }
    }

    public String message(){
        return this.message.toString();
    }
}
