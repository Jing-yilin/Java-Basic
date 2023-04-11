# Set

## 基本介绍

```java
public interface Set<E> extends Collection<E>
```

![image-20211215231613745](https://s2.loli.net/2021/12/21/z3uIBPYl5Tmakb2.png)

![image-20211215231647926](https://s2.loli.net/2021/12/21/pKx4taOyS5Dcv3T.png)

1. 无序（添加和取出的元素不一样），没有索引
2. 不允许重复元素，所以最多包含一个null
3. 其主要实现类有`HashSet`类和`TreeSet`类

## 常用方法

和List接口一样，Set也是Collection的子接口，常用方法和Collection一样

- 遍历方式(不能用索引)
  - 迭代器
  - 增强for循环

```java
Set set = new HashSet();
set.add("Yoshiki");
set.add("Yoshiki");//添加两次"Yoshiki"
set.add("Toshi");
set.add("Pata");
set.add("Hide");
set.add("Heath");
set.add(null);
set.add(null);//添加两次null
```

```java
//遍历
        //方法一：迭代器
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
//            System.out.println(next);
        }

        //方法二：增强for
        for (Object o:set) {
//            System.out.println(o);
        }
```

