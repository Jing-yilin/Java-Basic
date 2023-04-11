# ArrayList

## ArrayListDetail.java

```java
//ArrayList允许加入所有的类，甚至可以加入null
//ArrayList是由数组来实现的
//ArrayList基本等同于Vector，但是ArrayList是线程不安全的（效率更高）
//在多线程的情况下，建议使用Vector
//看源码没有synchronized（线程互斥）修饰
/*public boolean add(E e) {
        modCount++;
        add(e, elementData, size);
        return true;
}
 */
ArrayList arrayList = new ArrayList();
arrayList.add(null);
arrayList.add("jack");
arrayList.add(null);
System.out.println(arrayList);//[null, jack, null]
```

## ArrayListSource.java

就是说查看ArrayList的底层机制和源码分析。

- 结论：ArrayList中维护了一个Object类型的数组elementData
  `transient Object[] elementData`
  `transient` 表示瞬间的、短暂的，表示该属性不会被序列化
- 构造方法

![image-20211212235544481](https://s2.loli.net/2021/12/21/TKX6LszP2qjf7ot.png)

如果使用无参构造器，则初始elementData容量为0。第一次添加，则扩容elementData为10，如需要再次扩容，则扩容为原来的1.5倍。

如果使用的是指定大小的构造器，则初始elementData容量为指定大小，如果需要扩容，则直接扩容elementData为1.5倍。

### 实例看源码-数组初始大小未指定

```java
//使用无参构造器创建ArrayList对象
ArrayList list = new ArrayList();
//使用for循环给list添加1-10数据
for (int i = 1; i <= 10; i++) {
    list.add(i);
}
//使用for循环给list添加11-15数据
for (int i = 11; i <= 15; i++) {
    list.add(i);
}
list.add(100);
list.add(200);
```

构造器在底层的创建空的elementData数组

```java
public ArrayList() {
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
}
```

默认容量大小为10

```java
private static final int DEFAULT_CAPACITY = 10;
```

执行`add`添加新元素

```java
public boolean add(E e) {
    modCount++;
    add(e, elementData, size);
    return true;
}
```

调用同名`add`函数，如果数组size=elementData的长度，就说明要扩容了

```java
private void add(E e, Object[] elementData, int s) {
    if (s == elementData.length)
        elementData = grow();
    elementData[s] = e;
    size = s + 1;
}
```

`grow`扩容代码

```java
private Object[] grow(int minCapacity) {
    int oldCapacity = elementData.length;
    if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
        //按照1.5倍扩容
        int newCapacity = ArraysSupport.newLength(oldCapacity,
                minCapacity - oldCapacity, /* minimum growth */
                oldCapacity >> 1           /* preferred growth */);//位移>>1相当于除以2
        return elementData = Arrays.copyOf(elementData, newCapacity);//真扩容了，使用copyOf，保留原数据
    } else {
        return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];//还是使用了默认容量10
    }
}
```

### 实例看源码-数组初始化指定大小

```java
//使用无参构造器创建ArrayList对象
ArrayList list = new ArrayList(8);
//使用for循环给list添加1-10数据
for (int i = 1; i <= 10; i++) {
    list.add(i);
}
//使用for循环给list添加11-15数据
for (int i = 11; i <= 15; i++) {
    list.add(i);
}
list.add(100);
list.add(200);
```

进入构造方法，` this.elementData = new Object[initialCapacity];`直接创建指定大小的数组并赋给`elementData`

```java
public ArrayList(int initialCapacity) {
    if (initialCapacity > 0) {
        this.elementData = new Object[initialCapacity];
    } else if (initialCapacity == 0) {
        this.elementData = EMPTY_ELEMENTDATA;
    } else {
        throw new IllegalArgumentException("Illegal Capacity: "+
                                           initialCapacity);
    }
}
```

之后扩容还是直接按照1.5倍扩容。
