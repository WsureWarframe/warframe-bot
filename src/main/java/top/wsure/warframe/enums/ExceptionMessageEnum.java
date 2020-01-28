package top.wsure.warframe.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * FileName: ExceptionMessageEnum
 * Author:   Administrator
 * Date:     2020/1/26
 * Description: 异常提示枚举
 */

@Getter
@AllArgsConstructor
public enum ExceptionMessageEnum {
    CONFIG_BLANK("配置信息为空","请检查配置文件"),
    REQUEST_FAIL("请求失败","信息被S佬截获，请1分钟后重试"),
    FORMAT_MESSAGE_FAIL("请求成功但转码失败","信息被S佬截获，请1分钟后重试"),
    ;

    private String var;
    private String desc;
}
