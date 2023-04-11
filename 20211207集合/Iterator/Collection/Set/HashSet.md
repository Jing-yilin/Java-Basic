# HashSet

## 底层结构

- 构造方法

    ```java
    public HashSet() {
        map = new HashMap<>();
    }
    ```

    可以看出底层实现是`HashMap`

- 可以存放null，但是只能有一个null，即不能有重复元素
- 不保证元素是有序的，即不保证元素的存放顺序和取出顺序一致
- 不能有重复元素

## 案例

### 案例1

```java
HashSet set = new HashSet();
System.out.println(set.add("john"));//true
System.out.println(set.add("lucy"));//true
System.out.println(set.add("john"));//false
System.out.println(set.add("jack"));//true
System.out.println(set.add("rose"));//true
set.remove("john");
System.out.println("set = " + set);
```

### 案例2

```java
 HashSet set = new HashSet();
set.add("lucy");
set.add("lucy");
set.add(new Dog1("tom"));
set.add(new Dog1("tom"));
set.add(10);
set.add(10);
set.add(new Integer(10));
set.add(new Integer(10));
set.add(new String("haha"));
set.add(new String("haha"));

System.out.println("set = " + set);
//set = [com.hspedu.set_.Dog1@776ec8df, haha, 10, com.hspedu.set_.Dog1@4eec7777, lucy]
```

### 总结

Set不能有重复元素，但是相同内容的自定义类被看作不同元素，但是Integer和String这种基本类型被视为同一类型。

要具体了解就要看源码了！！！

## 底层机制

Hashset的底层是HashMap，HashMap底层是（数组+链表+红黑树）

### 模拟HashMap底层

```java
//模拟HashMap底层

//1. 创建一个数组，数组的类型是Node
Node[] table = new Node[16];
System.out.println("table = " + table);
//2. 创建结点
Node john = new Node(null,"John", null);
table[2] = john;
Node jack = new Node(john,"Jack", null);
john.next = jack;//将jack挂载到john
Node rose = new Node(jack, "Rose", null);
jack.next = rose;//将rose挂载到jack
System.out.println("table = " + table);

Node lucy = new Node(null, "Lucy", null);
table[3] = lucy;
System.out.println("table = " + table);
```

![image-20211216174655985](https://s2.loli.net/2021/12/21/u3GWqtTcExfCFkg.png)

### 基本逻辑

1. HashSet的底层是HashMap
2. 添加一个元素，先得到Hash值->会转成->索引值
3. 找到存储数据表Table，看这个索引位置是否有存放元素
4. 如果没有，则直接加入
5. 如果有，则调用equals比较，如果相同，就放弃添加，如果不同，则添加到最后
6. 在JAVA中，如果一条链表的元素个数大于8个，并且Table大小>=MIN_TREEIFY_CAPACITY(默认64)，就会进行树化

### 追源码演示1

```java
HashSet hashSet = new HashSet();
hashSet.add("java");
hashSet.add("php");
hashSet.add("java");
System.out.println("hashSet = " + hashSet);
```

1.调用构造器

```java
public HashSet() {
map = new HashMap<>();
}
```

2.add()

```java
public boolean add(E e) {
    //返回null表示加入失败了
    return map.put(e, PRESENT)==null;//e="java",PRESENT= new Object()
}
```

3.put()

```java
public V put(K key, V value) {//K="java",V= new Object()
    return putVal(hash(key), key, value, false, true);
}
```

3.1.调用hash()计算key的hash值（这个Hash值不等于HashCode）

```java
static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
```

4.调用putVal()

```java
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
               boolean evict) {
    Node<K,V>[] tab; Node<K,V> p; int n, i;
    //table是HashMap的一个属性
    //如果当前table是空的null，或者大小为0，则进行第一次扩容，大小为16
    if ((tab = table) == null || (n = tab.length) == 0)
        n = (tab = resize()).length;//resize()返回容量为16的Table,n=16
    //根据key，得到hash，去计算该key放到table表的哪一个索引位置
    //并把这个位置的对象赋给p
    //再判断p是否为空
    //如果p为空，表示没有存放过元素，那么就创建新的结点Node(key="java",value=PRESENT)放在tab[i]的地方
    if ((p = tab[i = (n - 1) & hash]) == null)//使用了位与运算，那么不管hash为多少都不会发生数组越界
        tab[i] = newNode(hash, key, value, null);
    else {
        Node<K,V> e; K k;
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;
        else if (p instanceof TreeNode)
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        else {
            for (int binCount = 0; ; ++binCount) {
                if ((e = p.next) == null) {
                    p.next = newNode(hash, key, value, null);
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        treeifyBin(tab, hash);
                    break;
                }
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                p = e;
            }
        }
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
    }
    ++modCount;
    if (++size > threshold)
        resize();
    afterNodeInsertion(evict);//HashMap这个方法是空的，需要留给子类实现
    return null;
}
```

4.1.resize()

```java
final Node<K,V>[] resize() {
    Node<K,V>[] oldTab = table;
    int oldCap = (oldTab == null) ? 0 : oldTab.length;
    int oldThr = threshold;
    int newCap, newThr = 0;
    if (oldCap > 0) {
        if (oldCap >= MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return oldTab;
        }
        else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                 oldCap >= DEFAULT_INITIAL_CAPACITY)
            newThr = oldThr << 1; // double threshold
    }
    else if (oldThr > 0) // initial capacity was placed in threshold
        newCap = oldThr;
    else {               // zero initial threshold signifies using defaults
        newCap = DEFAULT_INITIAL_CAPACITY;//static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
        //static final float DEFAULT_LOAD_FACTOR = 0.75f 为临界因子
        //newThr为临界值，就是当容量使用12时，就进行扩容，防止一下子加太多堵塞
        newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);//0.75 * 16 = 12
    }
    if (newThr == 0) {
        float ft = (float)newCap * loadFactor;
        newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                  (int)ft : Integer.MAX_VALUE);
    }
    threshold = newThr;//12
    @SuppressWarnings({"rawtypes","unchecked"})
    Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];//新建了一个容量为16的Node数组
    table = newTab;//现在table的容量为16
    if (oldTab != null) {
        for (int j = 0; j < oldCap; ++j) {
            Node<K,V> e;
            if ((e = oldTab[j]) != null) {
                oldTab[j] = null;
                if (e.next == null)
                    newTab[e.hash & (newCap - 1)] = e;
                else if (e instanceof TreeNode)
                    ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                else { // preserve order
                    Node<K,V> loHead = null, loTail = null;
                    Node<K,V> hiHead = null, hiTail = null;
                    Node<K,V> next;
                    do {
                        next = e.next;
                        if ((e.hash & oldCap) == 0) {
                            if (loTail == null)
                                loHead = e;
                            else
                                loTail.next = e;
                            loTail = e;
                        }
                        else {
                            if (hiTail == null)
                                hiHead = e;
                            else
                                hiTail.next = e;
                            hiTail = e;
                        }
                    } while ((e = next) != null);
                    if (loTail != null) {
                        loTail.next = null;
                        newTab[j] = loHead;
                    }
                    if (hiTail != null) {
                        hiTail.next = null;
                        newTab[j + oldCap] = hiHead;
                    }
                }
            }
        }
    }
    return newTab;//返回容量为16的Table
}
```

5.上面走完之后把"java"放进去了

![image-20211217235936613](https://s2.loli.net/2021/12/21/OJlWHsG3DwNhtmk.png)

### 追源码演示2

![image-20211218104937574](https://s2.loli.net/2021/12/21/HjY7lXI2pLtiF9J.png)

现在主要看再添加重复元素时会发生什么。直接看`putVal()`方法

```java
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
               boolean evict) {
    Node<K,V>[] tab; Node<K,V> p; int n, i;
    if ((tab = table) == null || (n = tab.length) == 0)
        n = (tab = resize()).length;
    if ((p = tab[i = (n - 1) & hash]) == null)
        tab[i] = newNode(hash, key, value, null);
    else {
        Node<K,V> e; K k;
        /*
        *关键
        */
        if (p.hash == hash &&//先比较hash是否相同
            ((k = p.key) == key || (key != null && key.equals(k))))//在确保指向同一个对象 或者 不为空且内容相同
            //equal()方法如果是自己创建的类需要重写
            e = p;
        else if (p instanceof TreeNode)//再判断p是不是一颗红黑树
            //如果是红黑树则使用putTreeVal()放入hash,key,value等内容
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        else {//由于不是红黑树，那么就是链表
            //for循环一遍链表，比较每一个是否跟新加入的相同，只要有一个相同了就退出
            for (int binCount = 0; ; ++binCount) {
                if ((e = p.next) == null) {//如果e的下一个为null
                    p.next = newNode(hash, key, value, null);//就直接挂载在e的后面
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st//如果此时长度大于等于树化临界值
                        treeifyBin(tab, hash);//那么就进行树化
                    break;//退出for
                }
                //如果链表里有一个元素和新加入的一样
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    break;//那么直接退出
                p = e;//把p往后移动一位(p=p.next)
            }
        }
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
    }
    ++modCount;
    if (++size > threshold)
        resize();
    afterNodeInsertion(evict);
    return null;
}
```

我们看一下树化代码`treeifyBin()`

```java
final void treeifyBin(Node<K,V>[] tab, int hash) {
    int n, index; Node<K,V> e;
    if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)//如果容量小于树化容量64
        resize();//进行扩容，不树化
    else if ((e = tab[index = (n - 1) & hash]) != null) {
        TreeNode<K,V> hd = null, tl = null;
        do {
            TreeNode<K,V> p = replacementTreeNode(e, null);
            if (tl == null)
                hd = p;
            else {
                p.prev = tl;
                tl.next = p;
            }
            tl = p;
        } while ((e = e.next) != null);
        if ((tab[index] = hd) != null)
            hd.treeify(tab);
    }
}
```

补充一点，就是只要添加元素，size就会增加，大于threshold就会扩容。

```java
if (++size > threshold)
        resize();
```

### 重写HashCode()和equals()

表示只要内容相同，equals就返回true，hashCode也返回相同内容

```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    A a = (A) o;
    return n == a.n;
}

@Override
public int hashCode() {
    return Objects.hash(n);
}
```

