package cn.datastacks.durian;


import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@Slf4j
public class JsonTest {
    @Data
    public static class MyObj {
        private int col1;
        private double col2;
        private String col3;
    }

    @Test
    public void toJson() {
        MyObj obj = new MyObj();

        obj.setCol1(1);
        obj.setCol2(2.0);
        obj.setCol3("abc");

        log.info("{}", Json.toJson(obj));
    }

    @Test
    public void fromJson() {
        MyObj obj = new MyObj();

        obj.setCol1(1);
        obj.setCol2(2.0);
        obj.setCol3("abc");

        String json = Json.toJson(obj);
        log.info("json: {}", json);

        MyObj fromJson = Json.fromJson(json, MyObj.class);
        log.info("fromJson: {}", fromJson);
    }

    @Test
    public void fromJson2() {
        // int array/list
        String json = "[1, 2, 3]";

        int[] intArr = Json.fromJson(json, Json.INT_ARRAY);
        List<Integer> intList = Json.fromJson(json, Json.INT_LIST);
        log.info("intArr: {}, intList: {}", intArr, intList);

        // long array/list
        long[] longArr = Json.fromJson(json, Json.LONG_ARRAY);
        List<Long> longList = Json.fromJson(json, Json.LONG_LIST);
        log.info("longArr: {}, longList: {}", longArr, longList);

        // float array/list
        json = "[1.0, 2.0, 3.0]";

        float[] floatArr = Json.fromJson(json, Json.FLOAT_ARRAY);
        List<Float> floatList = Json.fromJson(json, Json.FLOAT_LIST);
        log.info("floatArr: {}, floatList: {}", floatArr, floatList);

        // double array/list
        double[] doubleArr = Json.fromJson(json, Json.DOUBLE_ARRAY);
        List<Double> doubleList = Json.fromJson(json, Json.DOUBLE_LIST);
        log.info("doubleArr: {}, doubleList: {}", doubleArr, doubleList);

        // boolean array/list
        json = "[true, false]";

        boolean[] booleanArr = Json.fromJson(json, Json.BOOLEAN_ARRAY);
        List<Boolean> booleanList = Json.fromJson(json, Json.BOOLEAN_LIST);
        log.info("booleanArr: {}, booleanList: {}", booleanArr, booleanList);

        // string array/list
        json = "['a', 'b', 'c']";

        String[] stringArr = Json.fromJson(json, Json.STRING_ARRAY);
        List<String> stringList = Json.fromJson(json, Json.STRING_LIST);
        log.info("stringArr: {}, stringList: {}", stringArr, stringList);

        // object array/list
        json = "[1, 2.0, 'abc']";
        Object[] objectArray = Json.fromJson(json, Json.OBJECT_ARRAY);
        List<Object> objectList = Json.fromJson(json, Json.OBJECT_LIST);
        log.info("objectArray: {}, objectList: {}", objectArray, objectList);

        // custom object list
        json = "[{'col1':1,'col2':2.0,'col3':'abc'},{'col1':3,'col2':4.0,'col3':'def'},{'col1':5,'col2':6.0,'col3':'ghi'}]";

        Type myObjListType = new TypeToken<List<MyObj>>() {
        }.getType();

        List<MyObj> myObjs = Json.fromJson(json, myObjListType);
        log.info("myObjs: {}", myObjs);

        // int/long map
        json = "{'col1': 1, 'col2':2, 'col3': 3}";

        Map<String, Integer> intMap = Json.fromJson(json, Json.INT_MAP);
        Map<String, Long> longMap = Json.fromJson(json, Json.LONG_MAP);
        log.info("intMap: {}, longMap: {}", intMap, longMap);

        // float/double map
        json = "{'col1': 1.0, 'col2':2.0, 'col3': 3.0}";

        Map<String, Float> floatMap = Json.fromJson(json, Json.FLOAT_MAP);
        Map<String, Double> doubleMap = Json.fromJson(json, Json.DOUBLE_MAP);
        log.info("floatMap: {}, doubleMap: {}", floatMap, doubleMap);

        // boolean map
        json = "{'col1':  true, 'col2': false}";
        Map<String, Boolean> booleanMap = Json.fromJson(json, Json.BOOLEAN_MAP);
        log.info("booleanMap: {}", booleanMap);

        // string map
        json = "{'col1': 'a', 'col2': 'b', 'col3': 'c'}";
        Map<String, String> stringMap = Json.fromJson(json, Json.STRING_MAP);
        log.info("stringMap: {}", stringMap);

        // object map
        json = "{'col1': 1, 'col2': 2.0, 'col3': 'abc'}";
        Map<String, Object> objectMap = Json.fromJson(json, Json.OBJECT_MAP);
        log.info("objectMap: {}", objectMap);

        // custom object map
        json = "{'col2':{'col1':3,'col2':4.0,'col3':'def'},'col3':{'col1':5,'col2':6.0,'col3':'ghi'},'col1':{'col1':1,'col2':2.0,'col3':'abc'}}";

        Type myObjMapType = new TypeToken<Map<String, MyObj>>() {
        }.getType();
        Map<String, MyObj> myObjMap = Json.fromJson(json, myObjMapType);
        log.info("myObjMap: {}", myObjMap);
    }

    @Test
    public void parse() {
        String json = "abc";
        JsonElement element = Json.parse(json);
        log.info("element: {}", element);

        json = "{'col1': 1, 'col2': 2.0, 'col3': 'abc'}";
        element = Json.parse(json);
        log.info("element: {}", element);
    }

    @Test
    public void isJson() {
        String json = "123";
        Assert.assertTrue(Json.isJson(json));

        json = "{'col1': 1, 'col2': 2.0, 'col3': 'abc'}";
        Assert.assertTrue(Json.isJson(json));

        json = "['a', 'b', 'c']";
        Assert.assertTrue(Json.isJson(json));


        json = "null";
        Assert.assertTrue(Json.isJson(json));

        json = "1, 2.0, 'c'";
        Assert.assertFalse(Json.isJson(json));
    }

    @Test
    public void isJsonPrimitive() {
        String json = "123";
        Assert.assertTrue(Json.isJsonPrimitive(json));
    }

    @Test
    public void isJsonObject() {
        String json = "{'col1': 1, 'col2': 2.0, 'col3': 'abc'}";
        Assert.assertTrue(Json.isJsonObject(json));
    }

    @Test
    public void isJsonArray() {
        String json = "['a', 'b', 'c']";
        Assert.assertTrue(Json.isJsonArray(json));
    }

    @Test
    public void isJsonNull() {
        String json = "null";
        Assert.assertTrue(Json.isJsonNull(json));
    }
}
