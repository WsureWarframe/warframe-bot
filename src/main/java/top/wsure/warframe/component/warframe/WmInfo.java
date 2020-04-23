package top.wsure.warframe.component.warframe;

import top.wsure.warframe.annotation.BotEvent;
import top.wsure.warframe.annotation.BotEventType;
import top.wsure.warframe.entity.CommandDo;
import top.wsure.warframe.entity.MessageDo;
import top.wsure.warframe.enums.EventsEnum;

/**
 * FileName: WikiInfo
 * Author:   Administrator
 * Date:     2020-4-23
 * Description: warframeMarket查询模块
 */
@BotEvent(name = "wm")
public class WmInfo extends WarframeBase {

    @BotEventType(alias = "wm",type ={ EventsEnum.GROUP_MSG,EventsEnum.PRIVATE_MSG})
    public int execute(MessageDo msg, CommandDo cmd){
        return super.execute(msg,cmd);
    }
}
