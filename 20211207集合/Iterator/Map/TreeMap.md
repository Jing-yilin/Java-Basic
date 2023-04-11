# TreeMap

![image-20220119162918264](https://s2.loli.net/2022/01/19/QRqD251BFt9JGrO.png)

## 底层源码

![image-20220119163108242](https://s2.loli.net/2022/01/19/eFipXvsMC78jIDO.png)

### 类定义

```java
public class TreeMap<K,V>
    extends AbstractMap<K,V>
    implements NavigableMap<K,V>, Cloneable, java.io.Serializable{
    
}
```

### 构造器

```java
public TreeMap() {
    comparator = null;
}
```

```java
public TreeMap(Comparator<? super K> comparator) {
    this.comparator = comparator;
}
```

```java
public TreeMap(Map<? extends K, ? extends V> m) {
    comparator = null;
    putAll(m);
}
```

```java
public TreeMap(SortedMap<K, ? extends V> m) {
    comparator = m.comparator();
    try {
        buildFromSorted(m.size(), m.entrySet().iterator(), null, null);
    } catch (java.io.IOException | ClassNotFoundException cannotHappen) {
    }
}
```

## 代码示例

使用无参构造器，默认是无序的

```java
//使用默认构造器创建TreeMap,输出其实是无序的
TreeMap treeMap = new TreeMap();
treeMap.put("cilixx", "程隰");
treeMap.put("zephyr", "景奕林");
treeMap.put("jane", "简");
treeMap.put("john", "强");

System.out.println("TreeMap = " + treeMap);
//TreeMap = {cilixx=程隰, jane=简, john=强, zephyr=景奕林}
```

传入构造器

```java
//传入构造器
TreeMap treeMap = new TreeMap(new Comparator() {
    @Override
    public int compare(Object o1, Object o2) {
        //按照传入的字符串的大小进行排序
        return ((String)o1).compareTo((String)o2);
    }
});
treeMap.put("cilixx", "程隰");
treeMap.put("zephyr", "景奕林");
treeMap.put("jane", "简");
treeMap.put("john", "强");
treeMap.put("abba", "阿巴乐队");
treeMap.put("GNR", "枪花乐队");

System.out.println("TreeMap = " + treeMap);
//        TreeMap = {GNR=枪花乐队, abba=阿巴乐队, cilixx=程隰, jane=简, john=强, zephyr=景奕林}
```

可以看到底层是二叉树，每个节点是Entry

![image-20220119164041068](https://s2.loli.net/2022/01/19/KhNgaOI4qjew6kc.png)

## 一些细节

第一次传入K-V时，也会调用compare方法，目的是为了防止传入为空，若为null，则会抛出空指针异常。

![image-20220119165114350](https://s2.loli.net/2022/01/19/qVpez5hQBEZUOdM.png)