package top.wsure.warframe.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * FileName: BotExceptionEnum
 * Author:   Administrator
 * Date:     2020/1/23
 * Description: 异常类型枚举
 */
@Getter
@AllArgsConstructor
public enum BotExceptionEnum {

    COMMAND_TYPE_ERROR("命令类型异常","命令类型有误，无法判断其类型"),
    ;

    private String type;

    private String message;

}
