# Json

Json 用于 Json 字符串和 Java 对象之间的相互转换。

## 对象转换成 Json 字符串

类：

```java

@Data
public static class MyObj {
    private int col1;
    private double col2;
    private String col3;
}
```

对象：

```java
MyObj obj=new MyObj();

obj.setCol1(1);
obj.setCol2(2.0);
obj.setCol3("abc");
```

将对象 obj 转换成 Json 字符串：

```java
String json=Json.toJson(obj);
```

打印 json：

```json
{"col1":1,"col2":2.0,"col3":"abc"}
```

## Json 字符串转换成对象

Json 字符串：

```java
String json="{\"col1\":1,\"col2\":2.0,\"col3\":\"abc\"}";
```

转换成对象：

```java
MyObj myObj=Json.fromJson(json,MyObj.class);
```

注意参数 MyObj.class，fromJson 需要通过参数指定对象类型。

fromJson 也支持通过 Type（java.lang.reflect.Type）完成对象转换，Json 已内置支持若干类型：

* int[]
* long[]
* float[]
* double[]
* boolean[]
* String[]
* Object[]
* List\<Integer\>
* List\<Long\>
* List\<Float\>
* List\<Double\>
* List\<Boolean\>
* List\<String\>
* List\<Object\>
* Map<String, Integer>
* Map<String, Long>
* Map<String, Float>
* Map<String, Double>
* Map<String, Boolean>
* Map<String, String>
* Map<String, Object>

以 Map<String, Object> 为例：

```java
String json="{'col1': 1, 'col2': 2.0, 'col3': 'abc'}";
```

转换成对象：

```java
Map<String, Object> objectMap=Json.fromJson(json,Json.OBJECT_MAP);
```

也可以自定义类型，示例可参考：cn.datastacks.durian.JsonTest.fromJson2()。

## Json 字符串解析成 Json 分析树

```java
JsonElement element = Json.parse(json);
```

JsonElement（com.google.gson.JsonElement） 表示 Json 分析树。

## 检查字符串是否是 Json

Json 包含以下四种情况：

* 基本数据类型
* 对象
* 数组
* null

```java
boolean isJson = Json.isJson(json);
```

如果需要具体判断属于哪一种情况，可以使用：

* Json.isJsonPrimitive
* Json.isJsonObject
* Json.isJsonArray
* Json.isJsonNull