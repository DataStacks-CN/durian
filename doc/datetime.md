# Datetime

日期和时间工具类，可用于 LocalDateTime 和 日期时间字符串之间的解析和格式化。

## 获取当前日期和时间

```java
LocalDateTime now = Datetime.now();
```

## 获取当前日期

```java
String date = Datetime.date();
```

日期格式：yyyy-MM-dd。

## 获取当前日期和时间

```java
String datetime = Datetime.datetime();
```

日期和时间格式：yyyy-MM-dd HH:mm:ss。

## 格式化日期和时间

```java
LocalDateTime now = Datetime.now();

String datetime = Datetime.format(now);
```

格式化格式：yyyy-MM-dd HH:mm:ss。

## 解析日期和时间

```java
String datetime = Datetime.datetime();

LocalDateTime ldt = Datetime.parse(datetime);
```

将日期和时间字符串解析为 LocalDateTime 对象，字符串格式：yyyy-MM-dd HH:mm:ss。

## 检查字符串是否为日期和时间格式

```java
String date = "...";

boolean isDatetime = Datetime.isDatetime(date);
```