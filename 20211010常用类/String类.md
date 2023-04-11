# String类

![image-20211010201120691](https://s2.loli.net/2021/12/21/C2xcfZ3SJGbOAk4.png)

String是Object的子类!

Serializable 可串行化的（说明可以网络传输）

Comparable 可比较的（说明可以相互比较）

![构造器](https://s2.loli.net/2021/12/21/flD6jnWkGTY5gLA.png)

## 创建String类的两种方式

```java
		//方式1：
        //先从常量池查看是否有"jyl"数据空间，如果有，则直接指向，如果没有，则创建再指向
        String s1 = "jyl";//s1 --> 0x99   {byte[3]@816} [106, 121, 108]   
        String s2 = "jyl";//s1 --> 0x99   {byte[3]@816} [106, 121, 108]   
        //方式2：
        //现在堆中创建对象，里面维护了value属性，指向常量池的"jyl"空间，如果常量池没有"jyl"，则重新创建
        //如果有，则通过value指向。最终指向的是堆中的空间地址
        String s3 = new String("jyl");//s3 --> 0x106  //s3.value --> 0x99 {byte[3]@816} [106, 121, 108]
```

## StringExercise01.java

```java
String a = "abc";
String b = "abc";
System.out.println(a.equals(b));//true
System.out.println(a == b);//true
```

## StringExercise03.java

```java
String a = "jyl";//指向常量池的"jyl"
String b = new String("jyl");//b指向堆中的对象
System.out.println(a.equals(b));//true
System.out.println(a == b);//false
//当调用intern()方法，如果池中已经包含等于此String字符串(用equal(Object)方法确定)
//则返回池中的字符串。否则，将此String对象添加到池中，并返回String对象的引用
//解读：b.intern()在这里返回了常量池里"jyl"的地址
System.out.println(a == b.intern());//true
System.out.println(b == b.intern());//false
```

## StringExercise05.java

```java
public class StringExercise05 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "jyl";
        Person p2 = new Person();
        p2.name = "jyl";

        System.out.println(p1.name.equals(p2.name));//T
        System.out.println(p1.name == p2.name);//T
        System.out.println(p1.name == "jyl");//T

        String s1 = new String("asd");
        String s2 = new String("asd");
        System.out.println(s1 == s2);//F
    }
}

class Person {
    public String name;
}
```

## StringExercise06.java

```java
String s1 = "hello";
s1 = "haha";
//以上一共创建了2个对象
```

```java
String a = "wo" + "aini";
//编译器会优化==>等价于 String a = "woaini"
//以上一共创建了1个对象
```

```java
String b = "hello";
String c = "abs";
String d = a+b;
//以上创建了3个对象
```

