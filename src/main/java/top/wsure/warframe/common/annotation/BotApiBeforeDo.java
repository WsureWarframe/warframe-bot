package top.wsure.warframe.common.annotation;

/**
 * FileName: BotApiBeforeDo
 * Author:   Administrator
 * Date:     2020-4-23
 * Description: 执行API之前
 */
public interface BotApiBeforeDo {
    //是否拦截Api调用
    boolean execute(String apiName,Object[] args);
}
