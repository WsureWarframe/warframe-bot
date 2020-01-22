package top.wsure.warframe.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * FileName: RequestTypeEnum
 * Author:   wsure
 * Date:     2020/1/21 上午9:01
 * Description:
 */
@Getter
@AllArgsConstructor
public enum RequestTypeEnum {
    WARFRAME("wf","warframe世界状态"),
    RIVEN_MARKET("rm","RivenMarket紫卡市场"),
    WARFRAME_MARKET("wm","WarframeMarket交易网站"),
    HUIJI_WIKI("wiki","灰机wiki"),
    ;

    private String type;
    private String desc;

    public static boolean isNetRequestType(String type){
        for (RequestTypeEnum e:RequestTypeEnum.values())
        {
            if(e.getType().equals(type))
                return true;
        }
        return false;
    }
    public boolean equaledType(String type){
        return this.type.equals(type);
    }
}
