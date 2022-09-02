package cn.datastacks.durian;

import java.util.UUID;

/**
 * UUID
 *
 * @author yurun
 */
public class Uuid {
    public static String get() {
        return UUID.randomUUID().toString().replace(Constant.LINE_THROUGH, Constant.EMPTY);
    }
}
