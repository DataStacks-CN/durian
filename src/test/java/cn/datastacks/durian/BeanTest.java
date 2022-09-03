package cn.datastacks.durian;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class BeanTest {
    @Data
    public static class MyObj {
        private int col1;
        private double col2;
        private String col3;
    }

    @Test
    public void convert() {
        Map<String, Object> map = new HashMap<>();

        map.put("col1", 1);
        map.put("col2", 2.0);
        map.put("col3", "abc");

        log.info("map: {}", map);

        MyObj myObj = Bean.convert(MyObj.class, map);
        log.info("myObj: {}", myObj);
    }

    @Test
    public void converts() {
        Map<String, Object> map = new HashMap<>();

        map.put("col1", 1);
        map.put("col2", 2.0);
        map.put("col3", "abc");

        Map<String, Object> map2 = new HashMap<>();

        map2.put("col1", 3);
        map2.put("col2", 4.0);
        map2.put("col3", "def");

        Map<String, Object> map3 = new HashMap<>();

        map3.put("col1", 5);
        map3.put("col2", 6.0);
        map3.put("col3", "ghi");

        List<Map<String, Object>> maps = new ArrayList<>();

        maps.add(map);
        maps.add(map2);
        maps.add(map3);

        log.info("maps: {}", maps);

        List<MyObj> myObjs = Bean.converts(MyObj.class, maps);
        log.info("myObjs: {}", myObjs);
    }

    @Test
    public void populate() {
        MyObj myObj = new MyObj();
        log.info("myObj: {}", myObj);

        Map<String, Object> map = new HashMap<>();

        map.put("col1", 1);
        map.put("col2", 2.0);
        map.put("col3", "abc");

        log.info("map: {}", map);

        Bean.populate(myObj, map);
        log.info("myObj: {}", myObj);
    }

    @Test
    public void populates() {
        MyObj myObj = new MyObj();
        MyObj myObj2 = new MyObj();
        MyObj myObj3 = new MyObj();

        List<MyObj> myObjs = new ArrayList<>();

        myObjs.add(myObj);
        myObjs.add(myObj2);
        myObjs.add(myObj3);

        log.info("myObjs: {}", myObjs);

        Map<String, Object> map = new HashMap<>();

        map.put("col1", 1);
        map.put("col2", 2.0);
        map.put("col3", "abc");

        Map<String, Object> map2 = new HashMap<>();

        map2.put("col1", 3);
        map2.put("col2", 4.0);
        map2.put("col3", "def");

        Map<String, Object> map3 = new HashMap<>();

        map3.put("col1", 5);
        map3.put("col2", 6.0);
        map3.put("col3", "ghi");

        List<Map<String, Object>> maps = new ArrayList<>();

        maps.add(map);
        maps.add(map2);
        maps.add(map3);

        log.info("maps: {}", maps);

        Bean.populates(myObjs, maps);
        log.info("myObjs: {}", myObjs);
    }
}
