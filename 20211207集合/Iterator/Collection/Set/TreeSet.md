# TreeSet

![image-20220119155005636](https://s2.loli.net/2022/01/19/gUmCHDFbK45Eo9n.png)

## 底层源码

![image-20220119155520560](https://s2.loli.net/2022/01/19/Jso5EOAUHhKwTLd.png)

```java
public class TreeSet<E> extends AbstractSet<E>
    implements NavigableSet<E>, Cloneable, java.io.Serializable{
    
}
```

## 代码示例

```java
TreeSet treeSet = new TreeSet();
//添加数据
treeSet.add("jack");
treeSet.add("tom");
treeSet.add("程隰");
treeSet.add("景奕林");

        //不做处理的话TreeSet也是无序的
//        System.out.println(treeSet);//[jack, tom, 景奕林, 程隰]
```

### 解读

1. 当使用无参构造器创建TreeSet，它仍然是无序的
2. 如果希望添加的元素按照字符串比较进行排序
3. 使用TreeSet提供的构造器，传入一个比较器

## 使用构造器指定比较方式进行有序输出

```java
public TreeSet(Comparator<? super E> comparator) {
    this(new TreeMap<>(comparator));//TreeSet底层是TreeMap
}
```

```java
TreeSet treeSet = new TreeSet(new Comparator() {
    @Override
    public int compare(Object o1, Object o2) {
        //转换成String类型进行比较
        return (((String)o1).compareTo((String) o2));
    }
});

//添加数据,底层是个二叉树
treeSet.add("jack");
treeSet.add("tom");
treeSet.add("bc");
treeSet.add("ab");

//经过指定比较器，有序输出
System.out.println(treeSet);//[[ab, bc, jack, tom]]
```

```java
if (cpr != null) {
    do {
        parent = t;
        cmp = cpr.compare(key, t.key);
        if (cmp < 0)
            t = t.left;
        else if (cmp > 0)
            t = t.right;
        else { //cmp==0 则认为Key相同,那么key不改变；接下来判断value是否相同，但TreeSet里value都是一样的PRESENT
            V oldValue = t.value;
            if (replaceOld || oldValue == null) {
                t.value = value;
            }
            return oldValue;
        }
    } while (t != null);
```

:warning:如果比较器比较结果为0，也就是相同，那么就替换元素。

