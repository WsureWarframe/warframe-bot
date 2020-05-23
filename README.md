# warframe-bot
jcq-warframe-bot

### 重要的事只说一次：

- 1.需要配合[ ws-jcq ](https://github.com/WsureDev/warframe-bot) 使用，可以直接引入作为本项目的module
- 2.打包时先打包ws-jcq，然后再clean本项目，最后再打包本项目
- 3.我是真的懒

### 我干了啥

- 1.对事件、权限、命令做了封装，用注解写插件来处理。(`@BotEvent`、`@BotEventType`
- 2.对参数做了配置，参数的作用很简单也很low（`setting.yaml`
- 3.对CoolQ的实现类的对象进行了静态代理（我也想搞动态，水平不够，搞不来），这样就可以写类似切面的东西在CoolQ的API被调用之前和之后做点事(`@ApiAfter`、`@ApiBefore`
- 4.简陋的内存缓存，用惯了这玩意，见谅。顺便用了大佬的一段动态创建枚举的代码，这样我这个懒货就可以用枚举的单例随便搞事了（`@Cache`
- 5.优化了一键打包懒人包的pom配置，打包后项目目录下生成的data文件夹可以直接丢进酷Q根目录下面，你看目录结构就知道了。
- 6.我实在编不下去了，这套东西后面再优化下，把1.0 的功能复刻了就准备转mirai了，卡片消息实在是太香了（还能和小程序联动），交不交保护费都是其次的，也不差那点钱


### 快速使用

- 1.老规矩，还是直接解压release，把里面的文件拷出来丢CQA.exe或者CQP.exe所在的目录即可，安装JCQ的教程请看 [ warframe-jcq-component ](https://github.com/WsureDev/warframe-jcq-component)
- 2.需要注意的是，部署过1.0版本的请手动把JCQ老版本的cpk和数据目录删了，因为老版本几乎是基于jcq-1.2.7，新版本基于jcq-1.3.1