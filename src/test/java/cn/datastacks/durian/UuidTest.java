package cn.datastacks.durian;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class UuidTest {
    @Test
    public void test() {
        String uuid = Uuid.get();
        log.info("uuid: {}, length: {}", uuid, uuid.length());
    }
}
