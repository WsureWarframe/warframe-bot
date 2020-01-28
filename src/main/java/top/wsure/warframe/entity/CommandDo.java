package top.wsure.warframe.entity;

import lombok.Data;
import lombok.ToString;
import top.wsure.warframe.enums.CommandTypeEnum;

import java.util.Collections;
import java.util.List;

/**
 * FileName: CommandDo
 * Author:   wsure
 * Date:     2020/1/20 下午4:34
 * Description:
 */
@Data
@ToString
public class CommandDo {

    private String command;

    private String alias;

    private String requestType = "wf";

    private CommandTypeEnum type;

    private String param;

    private MenuDo menu;

    private boolean enable = true;
}
