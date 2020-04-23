package top.wsure.warframe.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * FileName: CacheFlagEnum
 * Author:   Administrator
 * Date:     2020-4-23
 * Description: 缓存标志
 */
@Getter
@AllArgsConstructor
public enum CacheFlagEnum {
    DEL("del::"),
    ;
    private final String flag;

}
