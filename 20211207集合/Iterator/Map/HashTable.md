# HashTable

![image-20211220203115587](https://s2.loli.net/2021/12/21/Mh9lEoIpSOdeWiP.png)

## 基本介绍

1. 存放的元素是键值对：K-V
2. hashtable的键和值都不能为null，否则会抛出NullPointerExpection（hashMap可以存在键和值都为null）
3. hashTable使用方法基本和hashMap一样
4. hashTable底层是**线程安全**的，hashMap是**线程不安全**的
   比如put方法:`public synchronized V put(K key, V value) {}`，使用了`synchronized`

## 底层源码

```java
public class Hashtable<K,V>
    extends Dictionary<K,V>
    implements Map<K,V>, Cloneable, java.io.Serializable {
    
    }
```

继承了`Dictionary<K,V>`，实现了`Map<K,V>`, `Cloneable`, `java.io.Serializable`

## 源码解读

**测试代码**

```java
Hashtable table = new Hashtable();
table.put("john", 100);//ok
```

![image-20220119131240243](https://s2.loli.net/2022/01/19/LucEznfWsByTQSv.png)

1. 底层有数组 `Hashtable$Entry[]` 初始化的大小为11，Entry是它的内部类
   `private static class Entry<K,V> implements Map.Entry<K,V> {}`
   可以看到`HashTable$Entry`继承了`Map$Entry`
1. 临界值`threshold = 8 = 0.75 * 11`，如果元素的到了8个，那么会进行扩容
1. 扩容：当元素数量超过8个（等于8个还不扩容），就进行第一次扩容
   ![image-20220119142958705](https://s2.loli.net/2022/01/19/lA3RdVnGesfYJct.png)
   临界值`threshold = 17 = 0.75 * 23`

4. 扩容代码`rehash`

   ```java
   protected void rehash() {
       int oldCapacity = table.length;
       Entry<?,?>[] oldMap = table;
   
       // overflow-conscious code
       int newCapacity = (oldCapacity << 1) + 1;
       if (newCapacity - MAX_ARRAY_SIZE > 0) {
           if (oldCapacity == MAX_ARRAY_SIZE)
               // Keep running with MAX_ARRAY_SIZE buckets
               return;
           newCapacity = MAX_ARRAY_SIZE;
       }
       Entry<?,?>[] newMap = new Entry<?,?>[newCapacity];
   
       modCount++;
       threshold = (int)Math.min(newCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
       table = newMap;
   
       for (int i = oldCapacity ; i-- > 0 ;) {
           for (Entry<K,V> old = (Entry<K,V>)oldMap[i] ; old != null ; ) {
               Entry<K,V> e = old;
               old = old.next;
   
               int index = (e.hash & 0x7FFFFFFF) % newCapacity;
               e.next = (Entry<K,V>)newMap[index];
               newMap[index] = e;
           }
       }
   }
   ```
   ```java
   // newCapacity = 11*2+1
   int newCapacity = (oldCapacity << 1) + 1;
   ```

