package top.wsure.warframe.utils;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.MethodParameterScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ConfigurationBuilder;
import top.wsure.warframe.common.annotation.BotEvent;
import top.wsure.warframe.common.annotation.BotEventType;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * FileName: ReflectionsUtils
 * Author:   Administrator
 * Date:     2020-4-5
 * Description: Reflections工具
 */
public class ReflectionsUtils {
    private static Reflections reflections = new Reflections(new ConfigurationBuilder()
                .forPackages("top.wsure.warframe") // 指定路径URL
                .addScanners(new SubTypesScanner()) // 添加子类扫描工具
            .addScanners(new FieldAnnotationsScanner()) // 添加 属性注解扫描工具
            .addScanners(new MethodAnnotationsScanner() ) // 添加 方法注解扫描工具
            .addScanners(new MethodParameterScanner() ) // 添加方法参数扫描工具
            );

    /**
     * 如果没有配置scanner，默认使用SubTypesScanner和TypeAnnotationsScanner
     * @return
     */
    public static Set<Class<?>> getFullReflections(Class<? extends Annotation> clazz){

        return reflections.getTypesAnnotatedWith(clazz);
    }

    public static Set<Method> getAnnotatedMethod(Class<? extends Annotation> clazz){
        return reflections.getMethodsAnnotatedWith(clazz);
    }
}
