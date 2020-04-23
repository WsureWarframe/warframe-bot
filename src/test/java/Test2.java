import org.apache.commons.lang3.tuple.Pair;
import org.reflections.Reflections;
import top.wsure.warframe.annotation.BotEvent;
import top.wsure.warframe.annotation.BotEventType;
import top.wsure.warframe.entity.MessageDo;
import top.wsure.warframe.utils.ReflectionsUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * FileName: Test2
 * Author:   Administrator
 * Date:     2020-4-1
 * Description: asd
 */

public class Test2 {
    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("1","2");
        Optional<String> s = l1.stream().filter(v->v.equals("3")).findFirst();
        System.out.println(s.orElse(null));
        Set<Class<?>> classes =  ReflectionsUtils.getFullReflections();
        classes.forEach( clazz -> System.out.println(clazz.getName()));

//        Map<String,List< Method>> map = new HashMap<>();
//        List<Method> methods = new ArrayList<>(ReflectionsUtils.getAnnotatedMethod());
//        map = methods.stream().collect(Collectors.groupingBy(method -> method.getAnnotation(BotEventType.class).type().getEvent()));
//        map.forEach( (k,v)->{
//            System.out.println("k:"+k+",v:"+v.size());
//        });
//        methods.forEach( method -> {
//            System.out.println(method.getName());
//            try {
//                method.invoke(method.getDeclaringClass().newInstance(), MessageDo.builder().subType(11).build());
//            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        });
    }
}
