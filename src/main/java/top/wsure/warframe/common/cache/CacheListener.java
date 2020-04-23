package top.wsure.warframe.common.cache;

import top.wsure.warframe.common.enums.CacheEnum;
import static top.wsure.warframe.Bot.CQ;

public class CacheListener extends Thread{

    public void run() {
        while (!isInterrupted()) {
            for(CacheEnum cacheEnum:CacheEnum.values())
            {
                CacheManagerImpl cacheManager = cacheEnum.getManager();
                for(String key : cacheManager.getAllKeys()) {
                    if (cacheManager.isTimeOut(key)) {
                        cacheManager.clearByKey(key);
                        CQ.logInfo("缓存被清除:","cache:"+cacheEnum.getName()+" key:"+key);
                    }
                }
            }
            try {
                Thread.sleep(200L);
            } catch(InterruptedException e){
                CQ.logError(this.getClass().getSimpleName(),e.getMessage());
                break;
            }
        }
    }
}