package cn.datastacks.durian;

import java.util.UUID;

/**
 * UUID 工具类
 *
 * @author yurun
 */
public class Uuid {
    /**
     * 获取 UUID
     *
     * @return UUID
     */
    public static String get() {
        return UUID.randomUUID().toString().replace(Constant.LINE_THROUGH, Constant.EMPTY);
    }

    private Uuid() {
        
    }
}
