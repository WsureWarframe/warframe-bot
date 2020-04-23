package top.wsure.warframe.annotation;

import top.wsure.warframe.enums.EventsEnum;

import java.lang.annotation.*;
import java.util.Collections;
import java.util.List;

/**
 * FileName: BotEventType
 * Author:   Administrator
 * Date:     2020-4-4
 * Description: 机器人事件类型
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BotEventType {
    EventsEnum[] type() default {EventsEnum.PRIVATE_MSG};
    String[] alias() default {};
}
