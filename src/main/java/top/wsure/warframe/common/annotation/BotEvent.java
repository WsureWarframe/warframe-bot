package top.wsure.warframe.common.annotation;

import java.lang.annotation.*;

/**
 * FileName: BotEvent
 * Author:   Administrator
 * Date:     2020/1/31
 * Description: 机器人事件
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BotEvent {
    String name() default "";
}
