package top.wsure.warframe.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.beanutils.BeanUtils;
import top.wsure.warframe.entity.CommandDo;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static top.wsure.warframe.enums.CommandTypeEnum.*;

/**
 * FileName: CommandEnum
 * Author:   Administrator
 * Date:     2020/1/27
 * Description: 命令枚举
 */
@Getter
@AllArgsConstructor
public enum CommandEnum {

    /**
     * wf
     */
    TIMESTAMP("服务器时间","timestamp","wf", NETWORK_WITHOUT_PARAM),
    NEWS("新闻","news","wf", NETWORK_WITHOUT_PARAM),
    EVENTS("活动","events","wf",NETWORK_WITHOUT_PARAM),
    ALERTS("警报","alerts","wf",NETWORK_WITHOUT_PARAM),
    SORTIE("突击","sortie","wf",NETWORK_WITHOUT_PARAM),
    OSTRONS("地球赏金","Ostrons","wf",NETWORK_WITHOUT_PARAM),
    SOLARIS("金星赏金","Solaris","wf",NETWORK_WITHOUT_PARAM),
    FISSURES("裂缝","fissures","wf",NETWORK_WITHOUT_PARAM),
    FLASH_SALES("促销商品","flashSales","wf",NETWORK_WITHOUT_PARAM),
    INVASIONS("入侵","invasions","wf",NETWORK_WITHOUT_PARAM),
    VOID_TRADER("奸商","voidTrader","wf",NETWORK_WITHOUT_PARAM),
    DAILY_DEALS("达尔沃","dailyDeals","wf",NETWORK_WITHOUT_PARAM),
    PERSISTENT_ENEMIES("小小黑","persistentEnemies","wf",NETWORK_WITHOUT_PARAM),
    EARTH_CYCLE("地球","earthCycle","wf",NETWORK_WITHOUT_PARAM),
    CETUS_CYCLE("平原","cetusCycle","wf",NETWORK_WITHOUT_PARAM),
    CONSTRUCTION_PROGRESS("舰队","constructionProgress","wf",NETWORK_WITHOUT_PARAM),
    VALLIS_CYCLE("山谷","vallisCycle","wf",NETWORK_WITHOUT_PARAM),
    NIGHT_WAVE("电波","nightwave","wf",NETWORK_WITHOUT_PARAM),

    /**
     * wiki
     */
    WIKI("wiki","wiki","wiki",NETWORK_NEED_PARAM),

    /**
     * rm
     */
    RM("rm","rm","rm",NETWORK_NEED_PARAM),

    /**
     * wm
     */
    WM("wm","wm","wm",NETWORK_NEED_PARAM),

    /**
     * Game
     */
    BELT_AND_ROAD_INITIATIVE("一带一路","beltAndRoadInitiative","game",LOCAL_GAME_NEED_PARAM),
    LOTTERY("抽奖","lottery","game",LOCAL_GAME_WITHOUT_PARAM),
    RETRACT("撤回!","retract","game",LOCAL_GAME_WITHOUT_PARAM),
    ;

    private String command;

    private String alias;

    private String requestType = "wf";

    private CommandTypeEnum type;

    public static List<CommandDo> commandDos(){
        return Arrays
                .stream(CommandEnum.values())
                .map(v->{
                    CommandDo cmd = new CommandDo();
                    try {
                        BeanUtils.copyProperties(cmd,v);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    return cmd;
                })
                .collect(Collectors.toList());
    }
}
