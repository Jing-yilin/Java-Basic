# Vector

- 底层也是对象数组
- 线程同步，也就是线程安全
- 开发过程中需要线程安全考虑，就是用`Vector`

![image-20211213233736262](https://s2.loli.net/2021/12/21/O5u3xbiznAeVJmh.png)

## Vector定义

```java
public class Vector<E>
    extends AbstractList<E>
    implements List<E>, RandomAccess, Cloneable, java.io.Serializable{
    
}
```

底层放的也是数组

```java
protected Object[] elementData;
```

Vector是线程安全（线程同步）的，因为它的方法都带有`synchronized`,比如下面方法

```java
public synchronized void setSize(int newSize) {
    modCount++;
    if (newSize > elementData.length)
        grow(newSize);
    final Object[] es = elementData;
    for (int to = elementCount, i = newSize; i < to; i++)
        es[i] = null;
    elementCount = newSize;
}
```

## 构造方法

无参构造，指定初始大小为10，调用`Vector(int initialCapacity)`

```java
public Vector() {
    this(10);
}
```

```java
public Vector(int initialCapacity) {
    this(initialCapacity, 0);
}
```

```java
public Vector(int initialCapacity, int capacityIncrement) {
    super();
    if (initialCapacity < 0)
        throw new IllegalArgumentException("Illegal Capacity: "+
                                           initialCapacity);
    this.elementData = new Object[initialCapacity];
    this.capacityIncrement = capacityIncrement;
}
```

![image-20211213234201097](https://s2.loli.net/2021/12/21/NBC4VEfzFXGbodK.png)


```java
public Vector(Collection<? extends E> c) {
    Object[] a = c.toArray();
    elementCount = a.length;
    if (c.getClass() == ArrayList.class) {
        elementData = a;
    } else {
        elementData = Arrays.copyOf(a, elementCount, Object[].class);
    }
}
```

## 扩容机制

```java
private Object[] grow(int minCapacity) {
    int oldCapacity = elementData.length;
    int newCapacity = ArraysSupport.newLength(oldCapacity,
            minCapacity - oldCapacity, /* minimum growth */
            capacityIncrement > 0 ? capacityIncrement : oldCapacity
                                       /* preferred growth */);
    return elementData = Arrays.copyOf(elementData, newCapacity);
}
```

Vector可以指定每次扩容的长度`capacityIncrement`，如果`capacityIncrement > 0`不成立，则扩容一倍

```java
public static int newLength(int oldLength, int minGrowth, int prefGrowth) {
    // assert oldLength >= 0
    // assert minGrowth > 0

    int newLength = Math.max(minGrowth, prefGrowth) + oldLength;
    if (newLength - MAX_ARRAY_LENGTH <= 0) {
        return newLength;
    }
    return hugeLength(oldLength, minGrowth);
}
```

## Vector和ArrayList比较

参考文章:[(44条消息) Vector和ArrayList对比_QiwooMobile的博客-CSDN博客](https://blog.csdn.net/QiwooMobile/article/details/84643523)

