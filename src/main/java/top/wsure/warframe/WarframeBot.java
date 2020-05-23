package top.wsure.warframe;

import org.meowy.cqp.jcq.entity.CQDebug;
import org.meowy.cqp.jcq.entity.CoolQ;
import top.wsure.bot.Bot;
import static top.wsure.warframe.MyCache.test;

/**
 * FileName: WarframeBot
 * Author:   Administrator
 * Date:     2020-5-5
 * Description: Bot
 */
public class WarframeBot extends Bot {


    /**
     * 使用新的方式加载CQ （建议使用这种方式）
     *
     * @param cq CQ初始化
     */
    public WarframeBot(CoolQ cq) {
        super(cq);
    }

    @Override
    public void onStart() {
        test.putCache("test","hahahah",1000L);
    }
}
