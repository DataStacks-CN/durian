package cn.datastacks.durian;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * MD5 工具类：计算给定字符串的 MD5 值。
 *
 * @author yurun
 */
public class Md5 {
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * 计算给定字符串的 MD5 值。
     *
     * @param data 字符串
     * @return MD5 值
     */
    public static String generate(String data) throws NoSuchAlgorithmException {
        if (Objects.isNull(data)) {
            return null;
        }

        MessageDigest digest = MessageDigest.getInstance(Constant.MD5);
        digest.update(data.getBytes());

        byte[] md = digest.digest();
        char[] md5 = new char[md.length * 2];

        for (int index = 0; index < md.length; index++) {
            md5[index * 2] = DIGITS[md[index] >>> 4 & 0xf];
            md5[index * 2 + 1] = DIGITS[md[index] & 0xf];
        }

        return new String(md5);
    }
}
