package top.wsure.warframe.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.collections.MapUtils;
import top.wsure.warframe.enums.RequestTypeEnum;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;

/**
 * FileName: HttpUtils
 * Author:   wsure
 * Date:     2020/1/17 上午9:42
 * Description:
 */
public class HttpUtils {



    private static Map.Entry<String,String> UA = new AbstractMap.SimpleEntry<String, String>("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36");



    public static String getContextRequest(String url, Map<String ,Object> params) {
        OkHttpClient client = new OkHttpClient();
        String res = null;
        StringBuilder sb = new StringBuilder();
        params.forEach( (k,v) ->{
            sb
                    .append("&")
                    .append(k)
                    .append("=")
                    .append(v)
            ;
        });
        url = MapUtils.isEmpty(params) ? url : url + sb.toString();
        Request request = new Request.Builder()
                .url(url)
                .addHeader(UA.getKey(),UA.getValue())
                .build();

        try {
            Response response = client.newCall(request).execute();
            if(!response.isSuccessful()){
                return null;
            }
            res = response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return res;
    }

    public static void main(String[] args) {
        String url = "http://127.0.0.1:3000/rm/robot/兰卡";
        System.out.println(getContextRequest(url , Collections.EMPTY_MAP));
    }

    public static String urlBuilder(String host,String type,String alis,String param){
        if(!RequestTypeEnum.isNetRequestType(type)){
            return null;
        }
        StringBuilder builder = new StringBuilder(host+type);
        builder.append("/")
                .append("robot/");

        if(RequestTypeEnum.WARFRAME.equaledType(type)){
            builder.append(alis);
        } else {
            builder.append(param);
        }
        return builder.toString();
    }
}
