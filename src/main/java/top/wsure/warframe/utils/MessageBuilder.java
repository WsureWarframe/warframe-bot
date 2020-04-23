package top.wsure.warframe.utils;

import org.apache.commons.lang3.StringUtils;

import static top.wsure.warframe.common.config.Constants.ROBOT_CONFIG;
/**
 * FileName: MessageBuilder
 * Author:   Administrator
 * Date:     2020/1/24
 * Description: 消息封装
 */
public class MessageBuilder {

    private StringBuilder prefix = new StringBuilder();
    private StringBuilder botPrefix = new StringBuilder();
    private StringBuilder message = new StringBuilder();

    public MessageBuilder(){
        if(ROBOT_CONFIG!=null && StringUtils.isNotBlank(ROBOT_CONFIG.getPrefix())){
            this.prefix = new StringBuilder(ROBOT_CONFIG.getPrefix()).append("\n");
        }
    }

    public MessageBuilder(String message){
        this.message.append(message);
        if(ROBOT_CONFIG!=null && StringUtils.isNotBlank(ROBOT_CONFIG.getPrefix())){
            this.botPrefix.append(ROBOT_CONFIG.getPrefix()).append("\n");
        }
    }

    public MessageBuilder setPrefix(String prefix){
        this.prefix.append(prefix);
        return this;
    }

    public MessageBuilder disableBotPrefix(){
        this.botPrefix.delete(0,this.botPrefix.length());
        return this;
    }


    public String build(){
        if(StringUtils.isBlank(this.message.toString()))
            this.message = new StringBuilder();
        return this.botPrefix
                .append(this.prefix)
                .append(this.message).toString();
    }

    public MessageBuilder message(String message){
        this.message.append(message);
        return this;
    }
}
