package top.wsure.warframe.common.annotation;

import java.lang.annotation.*;

/**
 * FileName: ApiAfter
 * Author:   Administrator
 * Date:     2020-4-23
 * Description: 执行机器人API后
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiAfter {
    String[] apiName() default {};
}
