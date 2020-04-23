package top.wsure.warframe.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import top.wsure.warframe.common.enums.EventsEnum;

/**
 * FileName: MessageDo
 * Author:   Administrator
 * Date:     2020-4-4
 * Description: 消息
 */
@Data
@ToString
@AllArgsConstructor
@Builder
public class MessageDo {

    private EventsEnum event;
    private Integer subType;
    private Integer msgId;
    private Integer sendTime;
    private Long fromGroup;
    private Long fromQQ;
    private Long fromDiscuss;
    private Long beingOperateQQ;
    private String fromAnonymous;
    private String file;
    private Long duration;
    private String responseFlag;
    private String msg;
    private Integer font;
}
