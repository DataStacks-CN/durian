package cn.datastacks.durian;

import org.apache.commons.lang3.StringUtils;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.regex.Pattern;

/**
 * Datetime
 *
 * @author yurun
 */
public class Datetime {
    public static final Pattern DATETIME_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$");

    public static final long ONE_DAY_MILLISECONDS = 24 * 3600 * 1000;

    public static String date() {
        return datetime().substring(0, 10);
    }

    public static String datetime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(Constant.LOCAL_DATE_TIME));
    }

    public static String dayStartTime(String datetime) {
        return LocalDateTime
                .parse(datetime, DateTimeFormatter.ofPattern(Constant.LOCAL_DATE_TIME))
                .format(DateTimeFormatter.ofPattern(Constant.LOCAL_DATE_TIME_START));
    }

    public static String dayEndTime(String datetime) {
        return LocalDateTime
                .parse(datetime, DateTimeFormatter.ofPattern(Constant.LOCAL_DATE_TIME))
                .format(DateTimeFormatter.ofPattern(Constant.LOCAL_DATE_TIME_END));
    }

    public static String todayStartTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(Constant.LOCAL_DATE_TIME_START));
    }

    public static String todayEndTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(Constant.LOCAL_DATE_TIME_END));
    }

    public static String tomorrowStartTime() {
        return LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern(Constant.LOCAL_DATE_TIME_START));
    }

    public static String tomorrowEndTime() {
        return LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern(Constant.LOCAL_DATE_TIME_END));
    }

    public static String thisWeekStartTime() {
        return LocalDateTime.now()
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
                .format(DateTimeFormatter.ofPattern(Constant.LOCAL_DATE_TIME_START));
    }

    public static String thisWeekEndTime() {
        return LocalDateTime.now()
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY))
                .format(DateTimeFormatter.ofPattern(Constant.LOCAL_DATE_TIME_END));
    }

    public static String nextWeekStartTime() {
        return LocalDateTime.now()
                .plusWeeks(1)
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
                .format(DateTimeFormatter.ofPattern(Constant.LOCAL_DATE_TIME_START));
    }

    public static String nextWeekEndTime() {
        return LocalDateTime.now()
                .plusWeeks(1)
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY))
                .format(DateTimeFormatter.ofPattern(Constant.LOCAL_DATE_TIME_END));
    }

    public static boolean isDatetime(String datetime) {
        if (StringUtils.isEmpty(datetime)) {
            return false;
        }

        return DATETIME_PATTERN.matcher(datetime).matches();
    }
}
