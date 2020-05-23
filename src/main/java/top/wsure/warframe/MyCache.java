package top.wsure.warframe;

import top.wsure.bot.common.annotation.Cache;
import top.wsure.bot.common.cache.CacheManagerImpl;
import top.wsure.bot.common.enums.CacheEnum;

/**
 * FileName: MyCache
 * Author:   Administrator
 * Date:     2020-5-5
 * Description: cache
 */
@Cache(name = "test")
public class MyCache {
    public static CacheManagerImpl test = CacheEnum.getManager("test");
}
