package top.wsure.warframe.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * FileName: EventsEnum
 * Author:   Administrator
 * Date:     2020/1/30
 * Description: 事件范围
 */
@Getter
@AllArgsConstructor
public enum  EventsEnum {
    PRIVATE_MSG("privateMsg","私聊消息"),
    GROUP_MSG("groupMsg","群聊消息"),
    DISCUSS_MSG("discussMsg","讨论组消息"),
    GROUP_UPLOAD("groupUpload","群文件上传"),
    GROUP_ADMIN("groupAdmin","群管理变更"),
    GROUP_MEMBER_DECREASE("groupMemberDecrease","群成员减少"),
    GROUP_MEMBER_INCREASE("groupMemberIncrease","群成员增加"),
    GROUP_BAN("groupBan","群禁言"),
    FRIEND_ADD("friendAdd","好友增加"),
    REQUEST_ADD_FRIEND("requestAddFriend","请求添加好友"),
    REQUEST_ADD_GROUP("requestAddGroup","请求加群"),
    ;

    private String event;
    private String desc;

    public static List<String> messageEvent(){
        return Arrays.asList(PRIVATE_MSG.getEvent(),GROUP_MSG.getEvent());
    }

    public static List<String> groupMsgEvent(){
        return Collections.singletonList(GROUP_MSG.getEvent());
    }

    public static List<String> allEvent(){
        return Arrays.stream(values()).map(EventsEnum::getEvent).collect(Collectors.toList());
    }

}
