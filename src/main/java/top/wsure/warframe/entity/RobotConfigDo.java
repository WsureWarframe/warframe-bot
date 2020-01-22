package top.wsure.warframe.entity;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: RobotConfigDo
 * Author:   wsure
 * Date:     2020/1/20 下午4:25
 * Description:
 */
@Data
@ToString
public class RobotConfigDo {

    private String robotName;

    private String prefix;

    private List<PersonDo> dev;

    private List<PersonDo> master;

    private List<MenuDo> menu;

    private List<CommandDo> commands;
}
