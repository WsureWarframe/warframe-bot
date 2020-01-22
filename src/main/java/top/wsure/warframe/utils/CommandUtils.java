package top.wsure.warframe.utils;

import top.wsure.warframe.entity.CommandDo;
import top.wsure.warframe.entity.RobotConfigDo;
import top.wsure.warframe.enums.RequestTypeEnum;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static top.wsure.warframe.WarframeBot.*;

/**
 * FileName: CommandUtils
 * Author:   wsure
 * Date:     2020/1/17 下午2:31
 * Description:
 */
public class CommandUtils {


    public static List<CommandDo> getCommand(String input){
        String in  = input.replace(getAtMe(),"");

        Map<String,CommandDo> commandMap = ROBOT_COMMANDS;

        return  commandMap.values().stream().filter(
                commandDo -> filterCommandMap(in, commandDo)
        ).collect(Collectors.toList());
    }

    public static Map<String,CommandDo> createCommandMap(RobotConfigDo robotConfig){
        if(robotConfig == null || robotConfig.getCommands() == null){
            return Collections.EMPTY_MAP;
        }
        List<CommandDo> commandMap = robotConfig.getCommands();
        Map<String,CommandDo> res = new HashMap<>();
        commandMap.forEach((command)->{
                command.setNeedNetwork(RequestTypeEnum.isNetRequestType(command.getType()));
                res.put(command.getAlias(),command);
        });
        return res;
    }
    public static String getAtMe(){
        return CC.at(CQ.getLoginQQ());
    }

    public static boolean filterCommandMap(String input,CommandDo cmd){
        StringBuilder regex = new StringBuilder("^\\s*" + cmd.getCommand() + "\\s*");

        Pattern withOutAt;
        withOutAt = Pattern.compile("(?<=" + cmd.getCommand() + "\\s).+");
        Matcher matcher = withOutAt.matcher(input);

        if (cmd.isHasParam()) {
            regex.append("\\S+");
        } else {
            regex.append("$");
        }

        if(input.toLowerCase().matches(regex.toString()))
        {
            if (cmd.isHasParam()) {
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
