package top.wsure.warframe.common.annotation;

/**
 * FileName: BotApiAfterDo
 * Author:   Administrator
 * Date:     2020-4-23
 * Description:
 */
public interface BotApiAfterDo {
    void execute(String apiName,Object[] args,Object result);
}
