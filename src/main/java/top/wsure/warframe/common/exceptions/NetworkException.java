package top.wsure.warframe.common.exceptions;

/**
 * FileName: NetworkException
 * Author:   Administrator
 * Date:     2020/1/23
 * Description: 网络请求失败
 */
public class NetworkException extends BotException{

    private static final String EXCEPTION_TYPE = "网络请求异常";

    public NetworkException(String message){
        this(message,EXCEPTION_TYPE);
    }
    private NetworkException(String message, String type) {
        super(message, type);
    }
}
