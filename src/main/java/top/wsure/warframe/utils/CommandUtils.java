package top.wsure.warframe.utils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import top.wsure.warframe.entity.CommandDo;
import top.wsure.warframe.entity.RobotConfigDo;
import top.wsure.warframe.enums.CommandEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static top.wsure.warframe.Bot.*;

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

    /**
     *
     * @param robotConfig
     * @return
     */
    public static Map<String,CommandDo> createCommandMap(RobotConfigDo robotConfig){
        List<String> disable = robotConfig.getDisable();
        boolean hasDisable = CollectionUtils.isNotEmpty(disable);
        Map<String,String> commandRename = robotConfig.getCommands();
        boolean hasRename = MapUtils.isNotEmpty(commandRename);

        List<CommandDo> commandMap = CommandEnum.commandDos();
        Map<String,CommandDo> res = new HashMap<>();
        commandMap.forEach( command -> {
            if(hasRename && StringUtils.isNotBlank(commandRename.get(command.getAlias())))
                command.setCommand(commandRename.get(command.getAlias()));
            if(hasDisable && disable.contains(command.getAlias()))
                command.setEnable(false);
            res.put(command.getAlias(),command);
        });
        return res;
    }
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

        if (cmd.getType().isNeedParam()) {
            regex.append("\\S+");
        } else {
            regex.append("$");
        }

        if(input.toLowerCase().matches(regex.toString()))
        {
            if (cmd.getType().isNeedParam()) {
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
