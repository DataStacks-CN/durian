package cn.datastacks.durian;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 对象工具类：字典转换或填充对象，字典键名称与对象属性名称一一对应。
 *
 * @author yurun
 */
public class Bean {
    /**
     * 字典转换为对象
     *
     * @param clazz 对象类
     * @param map   字典
     * @param <T>   对象类型或方法返回值类型
     * @return 对象
     */
    public static <T> T convert(Class<T> clazz, Map<String, Object> map) {
        if (Objects.isNull(clazz) || MapUtils.isEmpty(map)) {
            return null;
        }

        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            populate(instance, map);

            return instance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 字典列表转换为对象列表，一个字典实例对应一个对象实例。
     *
     * @param clazz 对象类
     * @param maps  字典列表
     * @param <T>   对象类型或方法返回值列表元素类型
     * @return 对象列表
     */
    public static <T> List<T> converts(Class<T> clazz, List<Map<String, Object>> maps) {
        if (Objects.isNull(clazz) || CollectionUtils.isEmpty(maps)) {
            return null;
        }

        return maps.stream()
                .map(map -> convert(clazz, map))
                .collect(Collectors.toList());
    }

    /**
     * 使用字典填充对象
     *
     * @param bean 对象
     * @param map  字典
     */
    public static void populate(Object bean, Map<String, Object> map) {
        if (Objects.isNull(bean) || MapUtils.isEmpty(map)) {
            return;
        }

        try {
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用字典列表填充对象列表
     *
     * @param beans 对象列表
     * @param maps  字典列表
     */
    public static <T> void populates(List<T> beans, List<Map<String, Object>> maps) {
        if (CollectionUtils.isEmpty(beans) || CollectionUtils.isEmpty(maps)) {
            return;
        }

        IntStream.range(0, beans.size())
                .forEach(index -> populate(beans.get(index), maps.get(index)));
    }
}
