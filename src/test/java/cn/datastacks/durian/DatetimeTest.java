package cn.datastacks.durian;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDateTime;

@Slf4j
public class DatetimeTest {
    @Test
    public void now() {
        log.info("now: {}", Datetime.now());
    }

    @Test
    public void date() {
        log.info("date: {}", Datetime.date());
    }

    @Test
    public void datetime() {
        log.info("datetime: {}", Datetime.datetime());
    }

    @Test
    public void format() {
        LocalDateTime now = Datetime.now();

        log.info("now: {}, format: {}", now, Datetime.format(now));
    }

    @Test
    public void isDatetime() {
        String date = Datetime.date();
        log.info("{} {}", date, Datetime.isDatetime(date));

        String datetime = Datetime.datetime();
        log.info("{} {}", datetime, Datetime.isDatetime(datetime));
    }
}
