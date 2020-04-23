package top.wsure.warframe.common.annotation;

import java.lang.annotation.*;

/**
 * FileName: ApiBefore
 * Author:   Administrator
 * Date:     2020-4-23
 * Description: 执行机器人API前
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiBefore {
    String[] apiName() default {};
}
