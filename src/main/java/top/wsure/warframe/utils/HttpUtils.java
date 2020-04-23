package top.wsure.warframe.utils;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.collections.MapUtils;
import top.wsure.warframe.common.enums.ExceptionMessageEnum;
import top.wsure.warframe.common.exceptions.NetworkException;

import java.io.IOException;
import java.net.ConnectException;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static top.wsure.warframe.Bot.CQ;

/**
 * FileName: HttpUtils
 * Author:   wsure
 * Date:     2020/1/17 上午9:42
 * Description:
 */
public class HttpUtils {



    private static Map.Entry<String,String> UA = new AbstractMap.SimpleEntry<String, String>("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36");



    public static String getContextRequest(String url, Map<String ,Object> params) throws NetworkException {
        long startTime = System.currentTimeMillis();
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
        String res = null;
        StringBuilder sb = new StringBuilder();
        params.forEach( (k,v) -> sb
                .append("&")
                .append(k)
                .append("=")
                .append(v));
        url = MapUtils.isEmpty(params) ? url : url + sb.toString();
        Request request = new Request.Builder()
                .url(url)
//                .addHeader(UA.getKey(),UA.getValue())
                .get()
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            if(!response.isSuccessful()){
                CQ.logWarning(response.code() + " request fail ! url",url+" requestTime:"+(System.currentTimeMillis()-startTime)+"ms");
                throw new NetworkException(ExceptionMessageEnum.REQUEST_FAIL.getDesc());
            }
            res = Objects.requireNonNull(response.body()).string();
        } catch (ConnectException ce){
            CQ.logWarning(ce.getMessage(),url+" requestTime:"+(System.currentTimeMillis()-startTime)+"ms");
            throw new NetworkException(ExceptionMessageEnum.REQUEST_FAIL.getDesc());
        }
        catch (IOException e) {
            CQ.logWarning(e.getMessage(),url+" requestTime:"+(System.currentTimeMillis()-startTime)+"ms");
            throw new NetworkException(ExceptionMessageEnum.FORMAT_MESSAGE_FAIL.getDesc());


        }

        return res;
    }

    public static void main(String[] args) {
        String url = "http://127.0.0.1:3000/rm/robot/兰卡";
        try {
            System.out.println(getContextRequest(url , Collections.EMPTY_MAP));
        } catch (NetworkException e) {
            System.out.println(e.getMessage());
        }
    }


}
