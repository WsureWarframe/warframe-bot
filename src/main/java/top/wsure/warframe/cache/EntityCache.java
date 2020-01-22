package top.wsure.warframe.cache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class EntityCache {
    /**
     * 保存的数据
     */
    private  Object data;

    /**
     * 设置数据失效时间,为0表示永不失效
     */
    private  long timeOut;

    /**
     * 最后刷新时间
     */
    private  long lastRefreshTime;

}