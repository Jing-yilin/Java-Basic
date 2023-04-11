# LinkedHashSet

![image-20211220185842649](https://s2.loli.net/2021/12/21/PYTKxNmp9k63GnV.png)

1. LinkedHashSet是HashSet的子类，实现了可串行化，也可以克隆。
2. LinkedHashSet底层是LinkedHashMap，底层维护了一个数组+双向链表
3. LinkedHashSet根据元素的hashCode值来决定元素的存储位置，同时使用链表维护元素的次序,这使得元素看起来是以插入顺序保存的。
4. LinkedHashSet 不允许添重复元素

```java
public class LinkedHashSet<E>
    extends HashSet<E>
    implements Set<E>, Cloneable, java.io.Serializable
```

## 构造方法

![image-20211220190105492](https://s2.loli.net/2021/12/21/3IBk7CW56GNZeKa.png)

```java
/**
     * Constructs a new, empty linked hash set with the default initial
     * capacity (16) and load factor (0.75).
     */
public LinkedHashSet() {
    super(16, .75f, true);
    /*super():
    HashSet(int initialCapacity, float loadFactor, boolean dummy) {
        map = new LinkedHashMap<>(initialCapacity, loadFactor);
    }
    */
}
```

```java
public LinkedHashSet(Collection<? extends E> c) {
    super(Math.max(2*c.size(), 11), .75f, true);
    addAll(c);
}
```

```java
public LinkedHashSet(int initialCapacity) {
    super(initialCapacity, .75f, true);
}
```

```java
public LinkedHashSet(int initialCapacity, float loadFactor) {
    super(initialCapacity, loadFactor, true);
}
```

## 底层机制示意图

![image-20211220191342727](https://s2.loli.net/2021/12/21/9UxPGtFQRNZTIL6.png)

> 可以发现`LinkedHashSet`覆写了`NewNode`方法，里面使用了`Entry`来代替`Node`

```java
Node<K,V> newNode(int hash, K key, V value, Node<K,V> e) {
    LinkedHashMap.Entry<K,V> p =
        new LinkedHashMap.Entry<>(hash, key, value, e);
    linkNodeLast(p);
    return p;
}
```

>原来`Entry`是定义在`LinkedHashSet`里的静态内部类，继承了`HashMap.Node`，里面多出了两个`Entry`变量：`before`，`after`
>
>`before`和`after`用来存储前一个和后一个`Entry`，保证了元素的有序性

```java
static class Entry<K,V> extends HashMap.Node<K,V> {
    Entry<K,V> before, after;
    Entry(int hash, K key, V value, Node<K,V> next) {
        super(hash, key, value, next);
    }
}
```

```java
private void linkNodeLast(LinkedHashMap.Entry<K,V> p) {
    LinkedHashMap.Entry<K,V> last = tail;//先把之前的尾Entey拿出来保存在last里
    tail = p;//让尾部为现在的p
    if (last == null)//如果之前的尾部为null,说明之前没有元素
        head = p;//就让p等于头
    else {//否则
        p.before = last;//让p挂载在last后面
        last.after = p;
    }
}
```

## Debug演示

```java
linkedHashSet linkedHashSet = new LinkedHashSet();
linkedHashSet.add("java");
linkedHashSet.add("python");
linkedHashSet.add("java");
linkedHashSet.add("C");
linkedHashSet.add("C++");
linkedHashSet.add("javascript");
linkedHashSet.remove("python");
//可以发现LinkedHashSet是有序的，插入顺序和输出顺序一致l

for (Object next : linkedHashSet) {
    System.out.println(next);
}
```

![image-20211220201808333](https://s2.loli.net/2021/12/21/gEXwFVT8okihPHc.png)

