package top.wsure.warframe.component.warframe;

import top.wsure.warframe.common.annotation.BotEvent;
import top.wsure.warframe.common.annotation.BotEventType;
import top.wsure.warframe.entity.CommandDo;
import top.wsure.warframe.entity.MessageDo;
import top.wsure.warframe.common.enums.EventsEnum;

/**
 * FileName: WikiInfo
 * Author:   Administrator
 * Date:     2020-4-23
 * Description: wiki查询模块
 */
@BotEvent(name = "wiki")
public class WikiInfo extends WarframeBase {

    @BotEventType(alias = "wiki",type ={ EventsEnum.GROUP_MSG,EventsEnum.PRIVATE_MSG})
    public int execute(MessageDo msg, CommandDo cmd){
        return super.execute(msg,cmd);
    }
}
