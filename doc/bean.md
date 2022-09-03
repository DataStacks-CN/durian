# Bean

Bean 可以用于将字典（Map）转换对象，或者填充对象，字典键名称与对象属性名称一一对应。

## 字典转换对象

字典：

```java
Map<String, Object> map=new HashMap<>();

map.put("col1",1);
map.put("col2",2.0);
map.put("col3","abc");
```

字典中有三个键：col1、col2 和 col3。

类：

```java

@Data
public static class MyObj {
    private int col1;
    private double col2;
    private String col3;
}
```

MyObj 中有三个属性：col1、col2 和 col3。

将字典 map 转换成类 MyObj 的对象：

```java
MyObj myObj=Bean.convert(MyObj.class,map);
```

方法 **convert** 会根据 **类** 自动创建 **对象**，并且按照键名称和对象属性名称的对应关系，将键值赋予对象属性。

打印 myObj 的三个属性值：

```text
col1=1, col2=2.0, col3=abc
```

## 字典列表转换成对象列表

字典列表转换成对象列表可以看作是 **字典转换成对象** 的批处理版本。

字典列表：

```java
Map<String, Object> map=new HashMap<>();

map.put("col1",1);
map.put("col2",2.0);
map.put("col3","abc");

Map<String, Object> map2=new HashMap<>();

map2.put("col1",3);
map2.put("col2",4.0);
map2.put("col3","def");

Map<String, Object> map3=new HashMap<>();

map3.put("col1",5);
map3.put("col2",6.0);
map3.put("col3","ghi");

List<Map<String, Object>>maps=new ArrayList<>();

maps.add(map);
maps.add(map2);
maps.add(map3);
```

字典列表中包含有三个字典：map、map2 和 map3。

将字典列表 maps 转换成对象列表，对象类型为 MyObj：

```java
List<MyObj> myObjs=Bean.converts(MyObj.class,maps);
```

## 字典填充对象

字典：

```java
Map<String, Object> map = new HashMap<>();

map.put("col1", 1);
map.put("col2", 2.0);
map.put("col3", "abc");
```

对象：

```java
MyObj myObj = new MyObj();
```

与 **转换** 不同，**填充** 要求对象预先创建完成。

字典填充对象：

```java
Bean.populate(myObj, map);
```

方法 **populate** 也是按钮字典键名称和对象属性名称的对应关系进行赋值。

## 字典列表填充对象列表

字典列表填充对象列表可以看作是 **字典填充对象** 的批处理版本。

字典列表：

```java
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
```

对象列表：

```java
MyObj myObj = new MyObj();
MyObj myObj2 = new MyObj();
MyObj myObj3 = new MyObj();

List<MyObj> myObjs = new ArrayList<>();

myObjs.add(myObj);
myObjs.add(myObj2);
myObjs.add(myObj3);
```

字典列表和对象列表大小相同，按顺序一一填充：

```java
Bean.populates(myObjs, maps);
```

