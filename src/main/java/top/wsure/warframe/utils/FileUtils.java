package top.wsure.warframe.utils;

import com.esotericsoftware.yamlbeans.YamlReader;
import top.wsure.warframe.entity.RobotConfigDo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import static top.wsure.warframe.Bot.AppID;
import static top.wsure.warframe.Bot.CQ;

/**
 * FileName: FileUtils
 * Author:   wsure
 * Date:     2020/1/20 上午9:06
 * Description:
 */
public class FileUtils {


    public static String getAppDirectory(){
        //工作路径
        String devDirectory = System.getProperty("user.dir")+"/data/app/org.meowy.cqp.jcq/app/"+AppID+"/";
        String proDirectory = CQ.getAppDirectory()+"/";
        // 获取应用数据目录(无需储存数据时，请将此行注释)
        return devDirectory.equals(proDirectory)? proDirectory : devDirectory;
    }

    public static RobotConfigDo importYaml(){
        InputStream in = null;
        File dumpFile = new File(getAppDirectory()+"setting.yaml");
        try {
            if(dumpFile.exists()){
                in = new FileInputStream(dumpFile);
            } else {
                in = FileUtils.class.getResourceAsStream("../common/config/setting.yaml");
            }
            YamlReader yamlReader = new YamlReader(new InputStreamReader(in));

            RobotConfigDo robotConfigDo = yamlReader.read(RobotConfigDo.class);

            CQ.logInfo("robotConfig", robotConfigDo.toString());
            return robotConfigDo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
