package top.wsure.warframe.annotation;

import top.wsure.warframe.enums.EventsEnum;

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
