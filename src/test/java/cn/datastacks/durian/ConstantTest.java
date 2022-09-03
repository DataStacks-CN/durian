package cn.datastacks.durian;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ConstantTest {
    @Test
    public void test() {
        log.info("{}", Constant.AMPERSAND);
        log.info("{}", Constant.EQUAL);
        log.info("{}", Constant.VERTICAL_BAR);
    }
}
