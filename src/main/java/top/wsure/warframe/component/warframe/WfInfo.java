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
 * Description: warframeWorldState查询模块
 */
@BotEvent(name = "wf")
public class WfInfo extends WarframeBase {

    @BotEventType(alias = {
            "timestamp",
            "news",
            "events",
            "alerts",
            "sortie",
            "Ostrons",
            "Solaris",
            "fissures",
            "flashSales",
            "invasions",
            "voidTrader",
            "dailyDeals",
            "persistentEnemies",
            "earthCycle",
            "cetusCycle",
            "constructionProgress",
            "vallisCycle",
            "nightwave",
    },type = {EventsEnum.PRIVATE_MSG,EventsEnum.GROUP_MSG})
    public int execute(MessageDo msg, CommandDo cmd){
        return super.execute(msg,cmd);
    }
}
