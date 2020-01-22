package top.wsure.warframe.entity;

import lombok.Data;
import lombok.ToString;

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

    private String type = "wf";

    private boolean hasParam;

    private String param;

    private boolean needNetwork;
}
