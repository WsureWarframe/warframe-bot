package top.wsure.warframe.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * FileName: ConfigFileEnum
 * Author:   wsure
 * Date:     2020/1/21 下午4:22
 * Description:
 */
@Getter
@AllArgsConstructor
public enum ConfigFileEnum {

    ROBOT_CONFIG("robot.yaml","robot","机器人配置"),
    ROBOT_DEVELOPER("dev.yaml","dev","开发人员配置"),
    ROBOT_MASTER("master.yaml","master","主人配置"),

    ;

    private String fileName;

    private String fieldName;

    private String desc;

}
