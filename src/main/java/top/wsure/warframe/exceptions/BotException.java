package top.wsure.warframe.exceptions;

import lombok.Getter;
import top.wsure.warframe.enums.BotExceptionEnum;

/**
 * FileName: BotException
 * Author:   wsure
 * Date:     2020/1/21 上午9:18
 * Description: 异常
 */
public class BotException extends Exception {
    @Getter
    private String type;

    public BotException(String message, String type) {
        super(message);
        this.type = type;
    }

    public BotException(BotExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.type = exceptionEnum.getType();
    }

    @Override
    public String getMessage(){
        StringBuilder sb = new StringBuilder();
        sb
                .append("[")
                .append(this.type)
                .append("] : ")
                .append(super.getMessage());

        return sb.toString();
    }
}
