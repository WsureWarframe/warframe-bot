package top.wsure.warframe.handler;

/**
 * FileName: AbstractHandler
 * Author:   wsure
 * Date:     2020/1/17 下午3:07
 * Description:
 */
public abstract class AbstractHandler {

    abstract void onPrivateMsg(int subType, int msgId, long fromQQ, String msg, int font);

    abstract void onGroupMsg(int subType, int msgId, long fromGroup, long fromQQ, String fromAnonymous, String msg,
                           int font);
}
