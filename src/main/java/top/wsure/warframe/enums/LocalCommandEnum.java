package top.wsure.warframe.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * FileName: LocalCommandEnum
 * Author:   wsure
 * Date:     2020/1/21 上午10:46
 * Description:
 */
@Getter
@AllArgsConstructor
public enum  LocalCommandEnum {

    GAME("game","游戏"),

    ;

    private String type;
    private String desc;

    public static boolean isLocalCommand(String type){
        for (LocalCommandEnum e:LocalCommandEnum.values())
        {
            if(e.getType().equals(type))
                return true;
        }
        return false;
    }
    public boolean equaledType(String type){
        return this.type.equals(type);
    }
}
