import org.meowy.cqp.jcq.entity.CQDebug;
import org.meowy.cqp.jcq.entity.CoolQ;
import top.wsure.bot.common.enums.CommandEnum;
import top.wsure.bot.common.exceptions.BotException;
import top.wsure.bot.common.exceptions.NetworkException;
import top.wsure.warframe.Warframebot;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FileName: Test
 * Author:   wsure
 * Date:     2020/1/15 下午4:20
 * Description:
 */
public class Test {

    /**
     * 用main方法调试可以最大化的加快开发效率，检测和定位错误位置<br/>
     * 以下就是使用Main方法进行测试的一个简易案例
     *
     * @param args 系统参数
     */
    public static void main(String[] args) {


        // 要测试主类就先实例化一个主类对象
        Warframebot bot = new Warframebot(new CQDebug());
        // 获取当前酷Q操作对象
        CoolQ CQ = bot.getCoolQ();
        CQ.logInfo("[JCQ] TEST Demo", "测试启动");// 现在就可以用CQ变量来执行任何想要的操作了
        CQ.logInfo("args", Arrays.toString(args));
        CQ.logInfo("Commands", CommandEnum.commandDos().toString());
        try {
            throw new NetworkException("asdasd");
        }catch (BotException e){
            CQ.logError(e.getType(),e.getMessage());
        }

        // 下面对主类进行各方法测试,按照JCQ运行过程，模拟实际情况
        bot.startup();// 程序运行开始 调用应用初始化方法
        bot.enable();// 程序初始化完成后，启用应用，让应用正常工作
        // 开始模拟发送消息
        // 模拟私聊消息
        // 开始模拟QQ用户发送消息，以下QQ全部编造，请勿添加
        bot.privateMsg(0, 10002, 2222222224L, "一带一路 asd", 0);
        bot.privateMsg(0, 10002, 2222222224L, "一带一路", 0);
        bot.privateMsg(0, 10002, 2222222224L, "wm", 0);
        /* 线程池大小 5 */
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for(int i=0;i<10;i++){
            executor.submit(() -> {
                bot.privateMsg(0, 10002, 2222222224L, "wm asd", 0);
            });
        }
        executor.shutdown();

        bot.privateMsg(0, 10002, 2222222224L, "WM 脑溢血", 0);
        bot.privateMsg(0, 10002, 2222222224L, "wM asd", 0);
        bot.privateMsg(0, 10002, 2222222224L, "警报 asd", 0);
        bot.privateMsg(0, 10002, 2222222224L, "警报", 0);
        bot.privateMsg(0, 10002, 2222222224L, "撤回", 0);

        bot.groupMsg(0, 10002, 2222222224L,888888L,"","警报", 0);
        // 模拟群聊消息
        // 开始模拟群聊消息
        bot.groupMsg(0, 10006, 3456789012L, 3333333334L, "", "菜单", 0);
        // ......
        // 依次类推，可以根据实际情况修改参数，和方法测试效果
        // 以下是收尾触发函数
        // demo.disable();// 实际过程中程序结束不会触发disable，只有用户关闭了此插件才会触发
        bot.exit();// 最后程序运行结束，调用exit方法
    }
}
