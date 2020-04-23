package top.wsure.warframe.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * FileName: ResponseFlagEnum
 * Author:   Administrator
 * Date:     2020-4-4
 * Description: 反馈标识
 */
@Getter
@ToString
@AllArgsConstructor
public enum ResponseFlagEnum {
    REQUEST_ADOPT("通过"),
    REQUEST_REFUSE("拒绝"),
    REQUEST_GROUP_ADD("群添加"),
    REQUEST_GROUP_INVITE("群邀请"),
    ;
    private String desc;


}
