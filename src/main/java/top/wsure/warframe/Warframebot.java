package top.wsure.warframe;

import org.meowy.cqp.jcq.entity.CQDebug;
import org.meowy.cqp.jcq.entity.CoolQ;
import top.wsure.bot.Bot;
import static top.wsure.warframe.MyCache.test;

/**
 * FileName: Warframebot
 * Author:   Administrator
 * Date:     2020-5-5
 * Description: Bot
 * 草！不要问我为什么类名这样写，鬼知道这是什么bug，类名只允许首字母大写，我也很无奈
 */
public class Warframebot extends Bot {


    /**
     * 使用新的方式加载CQ （建议使用这种方式）
     *
     * @param cq CQ初始化
     */
    public Warframebot(CoolQ cq) {
        super(cq);
    }

    @Override
    public void onStart() {
        test.putCache("test","hahahah",1000L);
    }
}
