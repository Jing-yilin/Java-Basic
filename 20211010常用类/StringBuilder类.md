# StringBuilder类

![img](https://www.runoob.com/wp-content/uploads/2013/12/java-string-20201208.png)

在使用 StringBuffer 类时，每次都会对 StringBuffer 对象本身进行操作，而不是生成新的对象，所以如果需要对字符串进行修改推荐使用 StringBuffer。

StringBuilder 类在 Java 5 中被提出，它和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。

由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况（单线程）下建议使用 StringBuilder 类。

在StringBuilder上的主要操作是append的insert。

![image-20211020083809496](.\image\image-20211020083809496.png)

# String stringbuffer stringbuilder比较

**三者在执行速度方面的比较：**

  **StringBuilder > StringBuffer > String**

 为什么String的执行速度最慢？

​    String：字符串常量

​    StringBuffer：字符串变量

​    StringBuilder：字符串变量

从上面的名字可以看到，String是“字符串常量”，也就是不可改变的对象。

1. StringBuilder和StringBuffer非常相似，均代表可变的字符序列，而且方法也一样

2. String:不可变字符序列，效率低，但是方勇复用率高

3. StringBuffer:可变字符序列，效率较高（增删）、线程安全

4. StringBuilder:可变字符序列，效率最高、线程不安全

5. String使用注意

   ```java
   String s = "a";//创建一个字符串
   s += b;//实际上原来的"a"被弃用了，现有产生了一个字符串，如果多次执行，会使得大量字符串留存在内存中，降低程序性能
   //因此如果对String进行大量修改，不要使用String
   ```

