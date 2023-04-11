# ArrayList和LinkedList比较

[ArrayList与LinkedList的比较 - 知乎 (zhihu.com)](https://zhuanlan.zhihu.com/p/256404536)

### 前言

在做ArrayList与LinkedList的比较之前，必须先对这两个数据结构有一定的学习和掌握，之前2篇文章分别讲了ArrayList与LinkedList的介绍和源码讲解，感兴趣的伙伴可以戳下方链接分别查阅：

[1、ArrayList源码浅析](https://link.zhihu.com/?target=https%3A//blog.csdn.net/xuri24/article/details/108310753)

[2、LinkedList源码分析](https://link.zhihu.com/?target=https%3A//blog.csdn.net/xuri24/article/details/108110637)

### 一、数据结构

CS专业的学生都学过一门课程叫：数据结构，里面专门讲了数据结构的原理知识和算法等。常见数据结构分为3大种：线性结构、树结构、图结构。

*   线性结构：数组（静态数组、动态数组）、线性表、链表（单向链表、双向链表、循环链表）、队列、栈。
*   树：二叉树、查找树、平衡树、线索树、线索树、堆
*   图：建模等

![](https://pic1.zhimg.com/v2-989aca4949a458e9924bd597de98d814_b.jpg)

其中，ArrayList与LinkedList就是属于线性结构，但一个是数组结构，一个是链表结构。有各自的特点和优势，在使用上也有各自的区别。

### 二、ArrayList的数组结构

上面说了，线性结构中的数组分为动态数组和静态数组，那么ArrayList是属于哪种呢？答案是动态数组，Array是我们学习数组时的基本概念，在初始定义一个数组时，设置了数组大小，运行时数组大小固定不变这样就是静态数组。那么，ArrayList是Array的升级和复杂版，它能支持程序运行中动态扩展数组的大小，因此它是动态数组。

使用上，ArrayList是动态数组，支持随机快速访问get和set操作。

![](https://pic1.zhimg.com/v2-34cf44bef22e6c4ea7c5e056217aa518_b.jpg)

### 三、LinkedList的链表结构

链表结构包括：单向链表、双向链表、循环链表，由之前文章的源码解析（上方链接）可看出，LinkedList是一个双向链表结构，每个节点既存储了上一节点的引用又存储了当前节点的物理地址（内容），还存储了下一节点的引用。

单独节点元素：

![](https://pic1.zhimg.com/v2-fff9edf48cbb24a21b77f679920e77f8_b.jpg)

LinkedList整体链表结构图：

![](https://pic3.zhimg.com/v2-8d850cee451825ad2d25826ebd00451a_b.jpg)

### 四、ArrayList与LinkedList的比较

1.  ArrayList是实现了**基于动态数组**的数据结构，而LinkedList是**基于链表**的数据结构；
2.  对于**随机访问get和set，ArrayList要优于LinkedList**，因为LinkedList要移动指针；
3.  对于添加和删除操作add和remove，一般大家都会说LinkedList要比ArrayList快，因为ArrayList要移动数据。但是实际情况并非这样，对于添加或删除，LinkedList和ArrayList**并不能明确说明谁快谁慢。** 
4.  插入的数据量很小时，两者区别不太大，当插入的数据量大时，大约在容量的1/10之前，LinkedList会优于ArrayList，在其后就劣与ArrayList，且越靠近后面越差。

# 如何进行选择

1. 如果改查的操作多，选择ArrayList
2. 如果增删的操作多，选择LinkedList
3. 一般来说，一个项目80%-90%都是查询，因此大部分情况下选择ArrayList
4. 在一个项目中，根据业务灵活的选择，也可能一个模块使用ArrayList，一个模块使用LinkedList

两个都是线程不安全的

