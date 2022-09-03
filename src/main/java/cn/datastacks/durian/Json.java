package cn.datastacks.durian;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Json 工具类：Json 和 对象（数组）之间的相互转换。
 *
 * @author yurun
 */
public final class Json {
    /**
     * 整数数组
     */
    public static final Type INT_ARRAY = new TypeToken<int[]>() {
    }.getType();

    /**
     * 长整数数组
     */
    public static final Type LONG_ARRAY = new TypeToken<long[]>() {
    }.getType();

    /**
     * 单精度浮点数数组
     */
    public static final Type FLOAT_ARRAY = new TypeToken<float[]>() {
    }.getType();

    /**
     * 双精度浮点数数组
     */
    public static final Type DOUBLE_ARRAY = new TypeToken<double[]>() {
    }.getType();

    /**
     * 布尔数组
     */
    public static final Type BOOLEAN_ARRAY = new TypeToken<boolean[]>() {
    }.getType();

    /**
     * 字符串数组
     */
    public static final Type STRING_ARRAY = new TypeToken<String[]>() {
    }.getType();

    /**
     * 对象数组
     */
    public static final Type OBJECT_ARRAY = new TypeToken<Object[]>() {
    }.getType();

    /**
     * 整数列表
     */
    public static final Type INT_LIST = new TypeToken<List<Integer>>() {
    }.getType();

    /**
     * 长整数列表
     */
    public static final Type LONG_LIST = new TypeToken<List<Long>>() {
    }.getType();

    /**
     * 单精度浮点数列表
     */
    public static final Type FLOAT_LIST = new TypeToken<List<Float>>() {
    }.getType();

    /**
     * 双精度浮点数列表
     */
    public static final Type DOUBLE_LIST = new TypeToken<List<Double>>() {
    }.getType();

    /**
     * 布尔列表
     */
    public static final Type BOOLEAN_LIST = new TypeToken<List<Boolean>>() {
    }.getType();

    /**
     * 字符串列表
     */
    public static final Type STRING_LIST = new TypeToken<List<String>>() {
    }.getType();

    /**
     * 对象列表
     */
    public static final Type OBJECT_LIST = new TypeToken<List<Object>>() {
    }.getType();

    /**
     * 整数字典
     */
    public static final Type INT_MAP = new TypeToken<Map<String, Integer>>() {
    }.getType();

    /**
     * 长整数字典
     */
    public static final Type LONG_MAP = new TypeToken<Map<String, Long>>() {
    }.getType();

    /**
     * 单精度浮点数字典
     */
    public static final Type FLOAT_MAP = new TypeToken<Map<String, Float>>() {
    }.getType();

    /**
     * 双精度浮点数字典
     */
    public static final Type DOUBLE_MAP = new TypeToken<Map<String, Double>>() {
    }.getType();

    /**
     * 布尔字典
     */
    public static final Type BOOLEAN_MAP = new TypeToken<Map<String, Boolean>>() {
    }.getType();

    /**
     * 字符串字典
     */
    public static final Type STRING_MAP = new TypeToken<Map<String, String>>() {
    }.getType();

    /**
     * 对象字典
     */
    public static final Type OBJECT_MAP = new TypeToken<Map<String, Object>>() {
    }.getType();

    private static final Gson GSON =
            new GsonBuilder()
                    .serializeNulls()
                    .serializeSpecialFloatingPointValues()
                    .disableHtmlEscaping()
                    .create();

    /**
     * 对象转换成 Json 字符串
     *
     * @param object 对象
     * @return Json 字符串
     */
    public static String toJson(Object object) {
        if (Objects.isNull(object)) {
            return Constant.EMPTY;
        }

        return GSON.toJson(object);
    }

    /**
     * Json 字符串转换成对象
     *
     * @param json  Json 字符串
     * @param clazz 对象类
     * @return 对象
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        return GSON.fromJson(json, clazz);
    }

    /**
     * Json 字符串转换成对象
     *
     * @param json Json 字符串
     * @param type 对象类型
     * @return 对象
     */
    public static <T> T fromJson(String json, Type type) {
        return GSON.fromJson(json, type);
    }

    /**
     * Json 字符串解析成 Json 分析树
     *
     * @param json Json 字符串
     * @return Json 分析树
     */
    public static JsonElement parse(String json) {
        return JsonParser.parseString(json);
    }

    /**
     * 检查字符串是否是 Json，包括：基本数据类型、对象、数组或 null
     *
     * @param json 字符串
     * @return 如果字符串是 Json，返回 true；否则，返回 false
     */
    public static boolean isJson(String json) {
        try {
            parse(json);

            return true;
        } catch (JsonParseException e) {
            return false;
        }
    }

    /**
     * 检查字符串是否是 Json 基本数据类型
     *
     * @param json 字符串
     * @return 如果字符串是 Json 基本数据类型，返回 true；否则，返回 false
     */
    public static boolean isJsonPrimitive(String json) {
        try {
            JsonElement element = parse(json);

            return element.isJsonPrimitive();
        } catch (JsonParseException e) {
            return false;
        }
    }

    /**
     * 检查字符串是否是 Json 对象
     *
     * @param json 字符串
     * @return 如果字符串是 Json 对象，返回 true；否则，返回 false
     */
    public static boolean isJsonObject(String json) {
        try {
            JsonElement element = parse(json);

            return element.isJsonObject();
        } catch (JsonParseException e) {
            return false;
        }
    }

    /**
     * 检查字符串是否是 Json 数组
     *
     * @param json 字符串
     * @return 如果字符串是 Json 数组，返回 true；否则，返回 false
     */
    public static boolean isJsonArray(String json) {
        try {
            JsonElement element = parse(json);

            return element.isJsonArray();
        } catch (JsonParseException e) {
            return false;
        }
    }

    /**
     * 检查字符串是否是 Json null
     *
     * @param json 字符串
     * @return 如果字符串是 Json null，返回 true；否则，返回 false
     */
    public static boolean isJsonNull(String json) {
        try {
            JsonElement element = parse(json);

            return element.isJsonNull();
        } catch (JsonParseException e) {
            return false;
        }
    }
}
