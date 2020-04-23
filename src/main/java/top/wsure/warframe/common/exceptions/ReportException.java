package top.wsure.warframe.common.exceptions;

/**
 * FileName: ReportException
 * Author:   Administrator
 * Date:     2020/1/23
 * Description: 通知异常
 */
public class ReportException extends BotException{

    private static final String EXCEPTION_TYPE = "通知异常";

    public ReportException(String message){
        this(message,EXCEPTION_TYPE);
    }

    private ReportException(String message, String type) {
        super(message, type);
    }
}
