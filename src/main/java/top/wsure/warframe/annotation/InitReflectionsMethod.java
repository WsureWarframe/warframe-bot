package top.wsure.warframe.annotation;

import org.apache.commons.collections.CollectionUtils;
import top.wsure.warframe.utils.ReflectionsUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import static top.wsure.warframe.config.Constants.botEventMap;

/**
 * FileName: InitReflectionsMethod
 * Author:   Administrator
 * Date:     2020-4-5
 * Description: 反射获取模块下方法
 */
public class InitReflectionsMethod {
    public static void init(){
        List<Method> methods = new ArrayList<>(ReflectionsUtils.getAnnotatedMethod());
        if(CollectionUtils.isNotEmpty(methods))
            methods.forEach( method -> Arrays.stream(method.getAnnotation(BotEventType.class).type()).forEach(
                    events -> {
                        List<Method> methodList = botEventMap.get(events.getEvent());
                        if(CollectionUtils.isNotEmpty(methodList)){
                            methodList.add(method);
                        } else {
                            botEventMap.put(events.getEvent(),new ArrayList<>(Collections.singletonList(method)));
                        }
                    }
            ));
    }
}
