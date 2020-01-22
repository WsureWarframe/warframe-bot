package top.wsure.warframe.enums;

import lombok.Getter;
import top.wsure.warframe.cache.EntityCache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * FileName: CacheEnums
 * Author:   wsure
 * Date:     2020/1/19 上午11:41
 * Description:
 */

@Getter
public enum CacheEnum {

    WAR_FRAME_CACHE("warFrame"),

    MESSAGE_CACHE("message");

     private String name;

     private ConcurrentHashMap<String, EntityCache> cache ;

    CacheEnum(String name) {
        this.name = name;
        this.cache = new ConcurrentHashMap<>();
    }

    public static ConcurrentHashMap<String, EntityCache> getCacheByName(String name){
         for(CacheEnum e:CacheEnum.values()){
             if(e.getName().equals(name)){
                 return e.getCache();
             }
         }
         return null;
     }

}
