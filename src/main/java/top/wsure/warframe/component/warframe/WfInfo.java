package top.wsure.warframe.component.warframe;

import top.wsure.bot.common.annotation.BotEvent;
import top.wsure.bot.common.annotation.BotEventType;
import top.wsure.bot.common.enums.CommandAuthorityEnum;
import top.wsure.bot.entity.CommandDo;
import top.wsure.bot.entity.MessageDo;
import top.wsure.bot.common.enums.EventsEnum;

/**
 * FileName: WikiInfo
 * Author:   Administrator
 * Date:     2020-4-23
 * Description: warframeWorldState查询模块
 */
@BotEvent(name = "wf",level = CommandAuthorityEnum.MEMBER)
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
