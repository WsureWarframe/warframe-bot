package top.wsure.warframe.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.wsure.warframe.common.exceptions.BotException;

/**
 * FileName: CommandTypeEnum
 * Author:   Administrator
 * Date:     2020/1/28
 * Description: 命令类型
 */
@Getter
@AllArgsConstructor
public enum ComponentEnum {

    NETWORK_NEED_PARAM("networkNeedParam","联网查询类命令有参",true,true),
    NETWORK_WITHOUT_PARAM("networkWithoutParam","联网查询类命令无参",true,false),
    LOCAL_QUESTION("localQuestion","预设问答",false,false),
    LOCAL_GAME_NEED_PARAM("localGameNeedParam","本地游戏有参",false,true),
    LOCAL_GAME_WITHOUT_PARAM("localGameWithoutParam","本地游戏无参",false,false),
    ;

    private String type;

    private String desc;

    private boolean needNetwork;

    private boolean needParam;

    public static boolean isNeedNetwork(String type) throws BotException {
        for(ComponentEnum e: ComponentEnum.values()){
            if(type.equals(e.getType())){
                return e.isNeedNetwork();
            }
        }
        throw new BotException(BotExceptionEnum.COMMAND_TYPE_ERROR);
    }

    public static boolean isNeedParam(String type) throws BotException {
        for(ComponentEnum e: ComponentEnum.values()){
            if(type.equals(e.getType())){
                return e.isNeedParam();
            }
        }
        throw new BotException(BotExceptionEnum.COMMAND_TYPE_ERROR);
    }

    public static ComponentEnum getByType(String type){
        for(ComponentEnum e: ComponentEnum.values()){
            if(type.equals(e.getType())){
                return e;
            }
        }
        return null;
    }
}
