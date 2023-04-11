# 集合

前面保存多个数据使用的是数组

数组的缺陷：

- 长度开始必须指定，一旦指定，不能修改
- 必须为同一类型的元素
- 增删比较麻烦

---

集合：

- 动态保存任意多个对象，使用方便
- 提供一系列方便操作对象的方法：add,remove,set,get
- 使用集合添加，删除新元素更简介

---

## 集合框架体系

![img](https://img2018.cnblogs.com/blog/1169114/201907/1169114-20190710091441495-1652040981.png)

![img](https://img2018.cnblogs.com/blog/1362965/201901/1362965-20190118094735724-2129767713.png)



## Collection接口和常用方法

```java
public interface Collection<E> extends Iterable<E>
```

1. collection实现子类可以存放多个元素，每个元素可以是Object
2. 有些Collection的实现类，可以存放重复的元素，有些不可以
3. 有些Collection的实现类，有些是有序的(List)，有些是无序的(Set)
4. Collection接口没有直接的实现子类，是通过它的子接口Set和List实现的

![image-20211207224143630](https://s2.loli.net/2021/12/21/MRVqWECvZrPDFGw.png)

---

以实现子类ArrayList来演示

### CollectionMethod.java

```java
 //用Collection的实例ArrayList来演示
        List list = new ArrayList();
//        add:添加单个元素,放Object
        list.add("Jack");
        list.add(10);//会自动装箱,相当于list.add(new Integer(10))
        list.add(true);
        System.out.println("list = " + list);
//        remove:删除指定的元素（被重载了的）
        //list.remove(0);//删除第一个元素
        list.remove(true);//删除指定元素
        System.out.println("list = " + list);
//        contains:查找元素是否存在
        System.out.println("list.contains(10) = " + list.contains(10));
//        size:获取元素个数
        System.out.println("list.size() = " + list.size());
//        isEmpty:判断是否为空
        System.out.println("list.isEmpty() = " + list.isEmpty());
//        clear:清空
        //list.clear();
        System.out.println("list = " + list);
//        addAll:添加多个元素,传入集合
        ArrayList list1 = new ArrayList();
        list1.add("红楼梦");
        list1.add("三国演义");
        list.addAll(list1);
        System.out.println("list = " + list);
//        containsAll:查找多个元素是否都在
        System.out.println("list.containsAll(list1) = " + list.containsAll(list1));
//        removeAll:删除多个元素
        list.removeAll(list1);
        System.out.println("list = " + list);
//        说明：以ArrayList演示Collection的方法
```

## Collection接口遍历元素方式-使用Iterator(迭代器)

1. Iterator对象成为迭代器，主要用于遍历Collection集合中的元素
2. 所有实现了Collection接口的集合类都有一个iterator()方法，用以返回一个实现了Iterator接口的对象，即可以返回一个迭代器
3. Iterator仅用于遍历集合，本身并不存放数据

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200728130923518.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L21pZHN1bW1lcl8=,size_16,color_FFFFFF,t_70)

**Iterator接口的方法**

- hasNext()
  `boolean hasNext();`

- next()
  `E next();`

- remove()

  ```java
  default void remove() {
      throw new UnsupportedOperationException("remove");
  }
  ```

### CollectionIterator.java

```java
Collection col = new ArrayList();
        col.add(new Book("三国演义","罗贯中",10.1));
        col.add(new Book("小李飞刀","古龙",5.1));
        col.add(new Book("红楼梦","曹雪芹",34.6));
        System.out.println("col = " + col);
        //col = [Book{name='三国演义', author='罗贯中', price=10.1}, Book{name='小李飞刀', author='古龙', price=5.1}, Book{name='红楼梦', author='曹雪芹', price=34.6}]

        //现在想要遍历集合，一本本输出
        //1. 先得到col的迭代器
        Iterator iterator = col.iterator();
        //2. 使用while循环遍历
        while(iterator.hasNext()){
            Object next = iterator.next();//编译类型是Object，但是运行类型取决于元素的种类
            System.out.println("next = " + next);
        }
        //3. 当退出while循环后，这是迭代器指向最后的元素，再取会报错
        //4. 如果需要再次遍历，需要充值迭代器
        iterator = col.iterator();//重置迭代器
```

## Collection接口遍历元素方式2-for循环增强

增强for循环，可以代替iterator迭代器

### CollectionFor.java

```java
Collection col = new ArrayList();
col.add(new Book("三国演义","罗贯中",10.1));
col.add(new Book("小李飞刀","古龙",5.1));
col.add(new Book("红楼梦","曹雪芹",34.6));

//使用增强for循环
//底层任然是迭代器
//可以理解成简化版的迭代器
//快捷方式：I
for(Object book : col) {
    System.out.println("book = " + book);
}
```

