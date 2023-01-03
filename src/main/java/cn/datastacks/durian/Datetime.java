package cn.datastacks.durian;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * 日期和时间工具类
 *
 * @author yurun
 */
public class Datetime {
    private static final DateTimeFormatter LOCAL_DATE_FORMATTER = DateTimeFormatter.ofPattern(Constant.LOCAL_DATE);
    private static final DateTimeFormatter LOCAL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(Constant.LOCAL_DATE_TIME);

    private static final Pattern DATETIME_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$");

    /**
     * 获取当前日期和时间
     *
     * @return 日期和时间
     */
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    /**
     * 获取当前日期
     *
     * @return 当前日期：yyyy-MM-dd
     */
    public static String date() {
        return now().format(LOCAL_DATE_FORMATTER);
    }

    /**
     * 获取当前日期和时间
     *
     * @return 当前日期和时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public static String datetime() {
        return now().format(LOCAL_DATE_TIME_FORMATTER);
    }

    /**
     * 格式化日期和时间
     *
     * @param datetime 日期和时间
     * @return 日期和时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public static String format(LocalDateTime datetime) {
        if (Objects.isNull(datetime)) {
            return Constant.EMPTY;
        }

        return datetime.format(LOCAL_DATE_TIME_FORMATTER);
    }

    /**
     * 解析日期和时间
     *
     * @param datetime 日期和时间字符串，格式：yyyy-MM-dd HH:mm:ss
     * @return 日期和时间
     */
    public static LocalDateTime parse(String datetime) {
        if (StringUtils.isEmpty(datetime)) {
            return null;
        }

        return LocalDateTime.parse(datetime, LOCAL_DATE_TIME_FORMATTER);
    }

    /**
     * 检查字符串是否为日期和时间格式
     *
     * @param datetime 字符串
     * @return 如果字符串是日期和时间格式，返回 true；否则，返回 false
     */
    public static boolean isDatetime(String datetime) {
        if (StringUtils.isEmpty(datetime)) {
            return false;
        }

        return DATETIME_PATTERN.matcher(datetime).matches();
    }

    private Datetime() {

    }
}
