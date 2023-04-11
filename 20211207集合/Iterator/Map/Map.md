# Map

![img](https://s2.loli.net/2021/12/21/kVTWn8CR6H24dz9.png)

![image-20211220203115587](https://s2.loli.net/2021/12/21/Mh9lEoIpSOdeWiP.png)

Map都是包括键值对`<K,V>`的，Set里只用了Map的`K`，而`V`是一个常量`PRESENT`。

## Map特点

1. Map与Collection并列存在。用于保存具有映射关系的数据：Key-Value

2. Map中的key和value可以是任何引用类型的数据，会封装到HashMap$Node对象中

3. Map中的key不允许重复，原因和HashSet一样，前面分析过源码
   因为hash是根据key求出来的

   ```java
   public V put(K key, V value) {
       return putVal(hash(key), key, value, false, true);
   }
   ```

5. Map中的value可以重复。当放入的k-v和其他的k重复，但是v不同相当于替换k

6. Map 的key可以为null,value也可以为null,注意key为null,只能有一个，value为null,可以多个.

7. 常用String类作为Map的key

7. key和value之间存在单向一对一关系，即通过指定的key总能找到对应的valueCC

## Map的常用方法

1. put()
   向map集合中添加Key为key，Value为value的元素，当添加成功时返回null，否则返回value

   ```java
   Map map = new HashMap();
   map.put("景奕林",666);//k-v
   map.put("自由",777);//k-v
   ```

2. putAll()

   ```java
   void putAll(Map<? extends K, ? extends V> m);
   ```

   ```java
   map1.putAll(map2);
   ```

3. clear()
   清除所有的键值对
   
4. remove()
   
4. isEmpty()
   
4. size()
   
4. containsKey()
   检出map集合中有没有包含Key为key的元素，如果有则返回true，否则返回false。
   ![img](https://images2018.cnblogs.com/blog/1431130/201808/1431130-20180821121658732-357212740.png)

## 底层机制

1. k-v 最后是 HashMap$Node node = new Node(hash, key, value, null)
2. l-v 为了方便程序员的遍历，还会创建 EntrySet 集合，该集合存放的元素类型为Entry
   对象就有`EntrySet<Entry<K,V>>`
   
   ```java
   transient Set<Map.Entry<K,V>> entrySet;
   ```

3. entrySet 中，定义的类型为 Map.Entry，但实际上存放的还是 HashNode$Node

    > 因为 HashMap$Node 是 Map.Entry 的实现
    > 继承Entry有啥好处？
    > 因为Entry里提供了`getKey`和`getValue`等方法（当然是在HashMap$Node里覆写了）

    ```java
    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;
    
        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    
        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }
    
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    
        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    
        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }
    ```

4. 演示一下

   ```java
   Map map = new HashMap();
   map.put("no1", "景奕林");
   map.put("no2", "景风眠");
   
   Set set = map.entrySet();
   System.out.println(set.getClass());//class java.util.HashMap$EntrySet
   for (Object entry: set)
   {
       System.out.println(entry.getClass());//class java.util.HashMap$Node
   }
   ```

## Entry

```java
interface Entry<K, V> {
    
    K getKey();
    
    V getValue();
   
    V setValue(V value);
    
    boolean equals(Object o);

    int hashCode();

    public static <K extends Comparable<? super K>, V> Comparator<Map.Entry<K, V>> comparingByKey() {
        return (Comparator<Map.Entry<K, V>> & Serializable)
            (c1, c2) -> c1.getKey().compareTo(c2.getKey());
    }
    
    public static <K, V extends Comparable<? super V>> Comparator<Map.Entry<K, V>> comparingByValue() {
        return (Comparator<Map.Entry<K, V>> & Serializable)
            (c1, c2) -> c1.getValue().compareTo(c2.getValue());
    }

    public static <K, V> Comparator<Map.Entry<K, V>> comparingByKey(Comparator<? super K> cmp) {
        Objects.requireNonNull(cmp);
        return (Comparator<Map.Entry<K, V>> & Serializable)
            (c1, c2) -> cmp.compare(c1.getKey(), c2.getKey());
    }

    public static <K, V> Comparator<Map.Entry<K, V>> comparingByValue(Comparator<? super V> cmp) {
        Objects.requireNonNull(cmp);
        return (Comparator<Map.Entry<K, V>> & Serializable)
            (c1, c2) -> cmp.compare(c1.getValue(), c2.getValue());
    }
}
```

**让我理一下：**

HashMap$Node是实现了Map.Entry(接口)，

HashMap里面存放节点的是EntrySet<Entry<K,V>>，是EntrySet的集合，

那么实际在使用EntrySet里的元素时，其被看作HashMap$Node类型。

还有就是LinkedHashMap$Entry是对HashMap$Node的继承，

所以关系是：**LinkedHashMap$Entry<--HashMap$Node<--Map.Entry**

## 演示table和EntrySet的关系

![image-20211221140730192](https://s2.loli.net/2021/12/21/eZq1ALv9pKUg7Yb.png)

![image-20211221140822081](https://s2.loli.net/2021/12/21/bDZi5EJQtOfjYRa.png)

可以发现EntrySet里面维护的就是HashMap.

## 六大遍历方式

```java
Map map = new HashMap();
map.put("Drums", "Yoshiki");
map.put("Guitar","Hide");
map.put("Bass", "Pata");
map.put("Vocal","Toshi");
map.put(null, "Heath");

//第一组：先取出所有的key,再通过key取出对应的value
Set keySet = map.keySet();
//(1) 增强for
for (Object key : keySet) {
    System.out.println(key + "-" + map.get(key));
}
//(2) 迭代器
Iterator iterator = keySet.iterator();
while (iterator.hasNext()) {
    Object key = iterator.next();
    System.out.println(key + "-" + map.get(key));
}
//第二组：取出所有的value
Collection values = map.values();
//这里可以使用所有Collection使用的遍历方法
//(1) 增强for
for (Object value: values) {
    System.out.println(value);
}
//(2) 迭代器
Iterator iterator1 = values.iterator();
while (iterator1.hasNext()) {
    Object value = iterator1.next();
    System.out.println(value);
}

//第三组：通过EntrySet
Set entrySet = map.entrySet();
//(1) 增强for
for (Object entry : entrySet)
{
    //将entry转成Map.Entry
    Map.Entry m = (Map.Entry) entry;
    System.out.println(m.getKey() + "-" + m.getValue());
}
//(2) 迭代器
Iterator iterator2 = entrySet.iterator();
while (iterator2.hasNext()) {
    Object entry = iterator2.next();
    Map.Entry m = (Map.Entry) entry;
    System.out.println(m.getKey() + "-" + m.getValue());
}
```

