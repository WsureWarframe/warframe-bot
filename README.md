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

# 食用方法

### 0.安装jcq环境
- 安装[vc++2010](https://www.microsoft.com/en-us/download/details.aspx?id=5555)
- 安装32位jre或jdk，版本要求8以上
- 安装jcq-1.3.1插件（就是把cpk丢到酷Q的app文件夹），cpk文件在本项目`app`文件夹内

### 1.快速使用

- 1.老规矩，还是直接解压release，把解压出来的data目录拷出来丢到酷Q根目录(CQA.exe或者CQP.exe所在的目录)即可，安装JCQ的教程请看 [ warframe-jcq-component ](https://github.com/WsureDev/warframe-jcq-component)里的视频，暂时没时间录
- 2.需要注意的是，部署过1.0版本的请手动把JCQ老版本的cpk和数据目录删了，因为老版本几乎是基于jcq-1.2.7，新版本基于jcq-1.3.1
  -具体操作：
    - 1.删除酷Q目录下`app`文件夹内jcq的cpk插件，并下载新版JCQ1.3.1放在此处
    - 2.删除酷Q目录下`data/app/org.meowy.cqp.jcq/`,然后回到酷Q根目录把release解压出来的data目录丢进去覆盖
    
### 2.自己编译（二开）
- 1.clone本项目，clone ws-jcq项目
- 2.用idea打开本项目，引入module，选择ws-jcq项目的pom
- 3.打包顺序：先打包ws-jcq，然后clean本项目，再install本项目
- 4.ws-jcq不仅可以用于本项目，还可以用在你自己的项目上。暂时没有文档，先说下需要注意的点：
  - 1.yaml配置文件不可缺，json文件名对应你的主类的package和类名拼接(主类名一定要是只有首字母大写，其余小写，否则jcq加载时候会有问题) ，大小写注意就好了，json文件名的类名是纯小写
  - 2.主类继承ws-jcq包内的Bot方法，可以自己实现onStart()方法实现一些初始化的东西。
  - 3.4个注解的用法我当时想的比较多，暂时没时间整理文档，后面补上。如果你愿意看源码也能看懂，其实也不难的。
