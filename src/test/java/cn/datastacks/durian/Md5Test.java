package cn.datastacks.durian;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

public class Md5Test {
    @Test
    public void generate() throws NoSuchAlgorithmException {
        String text = "Hello World";

        String md5 = Md5.generate(text);
        System.out.println("md5: " + md5);
    }
}
