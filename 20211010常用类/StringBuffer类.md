# StringBuffer类

## Strinf和StringBuffer的区别

1. String保存字符串常量，里面的值不能修改，每次String类的更新实际上是修改地址，效率较低。

2. StringBuffer保存的是字符串变量，里面的值可以修改，每次StringBuffer的更新实际上可以更新内容，不同每次更新地址，效率较高。
   //char[] value //这在堆里

   ```java
   // 1.StringBuffer 的直接父类是 AbstractStringBuilder
   // 2.StringBuffer 实现了 Serializable，即可串行化
   // 3.在父类中 AbstractStringBuilder 有属性 char[] value,不是final，存放字符串内容，放在堆中
   // 4.StringBuffer 也是 final 类,不能被继承
   ```

## StringBuffer的构造器

```java
//构造一个不带字符的字符串缓冲区，初始容量为16
StringBuffer()
//java.lang.StringBuilder(CharSequence seq) 构造一个字符串缓冲区，它包含与指定的 CharSequence 相同的字符
StringBuffer(CharSequence seq)
```

```java
//构造器的使用
// 1.创建一个大小为16的 char[]，用于存放字符序列
StringBuffer stringBuffer = new StringBuffer();

// 2.通过构造器指定char[]容量的大小
StringBuffer stringBuffer1 = new StringBuffer(100);

// 3.通过给一个String 创建StringBuffer
//   容量为5+16 = 21
StringBuffer stringBuffer2 = new StringBuffer("Hello");
```

## String和StrinfBuffer的转换

```java
//String-->StringBuffer
String str = "hello tom";

// 方式1：使用构造器。返回String值，对str本身没有影响
StringBuffer stringBuffer = new StringBuffer(str);

// 方式2：使用append方法
StringBuffer stringBuffer1 = new StringBuffer();
StringBuffer append = stringBuffer1.append(str);

//StringBuffer-->String
StringBuffer stringBuffer2 = new StringBuffer("景风眠");

// 方式1：使用toString()
String s = stringBuffer2.toString();

// 方式2：使用构造器直接构造
String s1 = new String(stringBuffer2);
```

## StringBuffer的常用方法

```java
//StringBuffer的常用方法

StringBuffer s = new StringBuffer("hello");

//增，返回的还是StringBuffer
s.append(',');
s.append("张三丰");
s.append("景风眠").append(100).append(true).append(10.5);
System.out.println(s);//hello,张三丰景风眠100true10.5

//删
/*
* 删除索引为>=start && <end 处的字符
*/
s.delete(12,23);
System.out.println(s);//hello,张三丰景风眠

//改
s.replace(6,9,"程隰");
System.out.println(s);//hello,程隰景风眠

//查
int indexOf = s.indexOf("程隰");
System.out.println(indexOf);//6

//插
s.insert(8, "喜欢");
System.out.println(s);//hello,程隰喜欢景风眠

//长度
System.out.println(s.length());//13
System.out.println(s);//hello,程隰喜欢景风眠
```

