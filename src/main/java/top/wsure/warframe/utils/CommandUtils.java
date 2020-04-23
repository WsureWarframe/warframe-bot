package top.wsure.warframe.utils;

import org.apache.commons.collections.CollectionUtils;
import top.wsure.warframe.entity.CommandDo;
import top.wsure.warframe.entity.RobotConfigDo;
import top.wsure.warframe.common.enums.ComponentEnum;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static top.wsure.warframe.Bot.CQ;
import static top.wsure.warframe.common.config.Constants.*;

/**
 * FileName: CommandUtils
 * Author:   wsure
 * Date:     2020/1/17 下午2:31
 * Description:
 */
public class CommandUtils {


    public static List<CommandDo> getCommand(String input){
        String in  = input.replace(getAtMe(),"");

        List<CommandDo> commandList = ROBOT_COMMANDS;
        return commandList.stream()
                .filter( commandDo -> commandDo.getComponentType() != null)
                .filter(
                        commandDo -> filterCommandMap(in, commandDo)
                ).collect(Collectors.toList());
    }

    /**
     *
     * @param robotConfig
     * @return
     */
    public static List<CommandDo> createCommandMap(RobotConfigDo robotConfig){
        List<String> disable = robotConfig.getDisable();
        boolean hasDisable = CollectionUtils.isNotEmpty(disable);
        List<CommandDo> commandListMap = robotConfig.getCommands();
        commandListMap.forEach( value -> {
            value.setComponentType(ComponentEnum.getByType(value.getType()));
            if(hasDisable && (disable.contains(value.getAlia()) || disable.contains(value.getComponentName())))
                value.setEnable(false);
        });
        return commandListMap;
    }

    /**
     * getAtMe
     * @return
     */
    public static String getAtMe(){
        return CC.at(CQ.getLoginQQ());
    }

    /**
     * 识别指令
     * @param input
     * @param cmd
     * @return
     */

    public static boolean filterCommandMap(String input,CommandDo cmd){
        if(!cmd.isEnable()){
            return false;
        }

        String command = cmd.getCommand().matches("[a-zA-Z]+") ?
                ( "(("+cmd.getCommand()+")|("+cmd.getCommand().toUpperCase()+"))" ) :
                cmd.getCommand();

        StringBuilder regex = new StringBuilder("^\\s*" + command + "\\s*");

        Pattern withOutAt;
        withOutAt = Pattern.compile("(?<=" + command + "\\s).+");
        Matcher matcher = withOutAt.matcher(input);

        if (cmd.getComponentType().isNeedParam()) {
            regex.append("\\S+");
        } else {
            regex.append("$");
        }

        if(input.toLowerCase().matches(regex.toString()))
        {
            if (cmd.getComponentType().isNeedParam()) {
                if( matcher.find()){
                    cmd.setParam(matcher.group());
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
