package top.wsure.warframe.entity;

import lombok.Data;
import lombok.ToString;
import top.wsure.warframe.common.enums.ComponentEnum;
import top.wsure.warframe.common.enums.EventsEnum;

import java.util.ArrayList;
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

    /** 插件名 */
    private String componentName;
    /** 别名 */
    private String alia;
    /** 指令 */
    private String command;
    /** 命令枚举类型 */
    private ComponentEnum componentType;
    /** 命令字符类型 */
    private String type;
    /** 事件枚举 */
    private List<EventsEnum> events = new ArrayList<>();
    /** 参数 */
    private String param;
    /** 启用状态 */
    private boolean enable = true;
}
