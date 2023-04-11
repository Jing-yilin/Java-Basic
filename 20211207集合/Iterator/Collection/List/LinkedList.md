# LinkedList

## 底层结构

1. LinkedList底层实现了双向链表和双端队列特点
2. 可以添加任意元素（元素可以重复），包括null
3. 线程不安全，没有实现同步

![image-20211215193558811](https://s2.loli.net/2021/12/21/Dy8KlgGBZ3PufL6.png)

```java
public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable
```

## 构造方法

![构造方法](https://s2.loli.net/2021/12/21/CLUXFHsKpgRQ56d.png)

```java
public LinkedList() {
}
```

```java
public LinkedList(Collection<? extends E> c) {
    this();
    addAll(c);
}
```

![image-20211215193914043](https://s2.loli.net/2021/12/21/cSBWUkOKTCu3Pwz.png)

## LinkedList增删改查案例

LinkedListCRUD.java

执行代码:

```java
LinkedList linkedList = new LinkedList();
linkedList.add(1);
```

调用LinkedList无参构造:

```java
public LinkedList() {
}
```

### 增add

添加元素:

```java
public boolean add(E e) {
    linkLast(e);
    return true;
}
```

看看`linkLast(e)`

```java
void linkLast(E e) {
    final Node<E> l = last;//先把最后一个元素保存一下，一开始last==null
    final Node<E> newNode = new Node<>(l, e, null);//创建新元素
    last = newNode;
    if (l == null)
        first = newNode;
    else
        l.next = newNode;
    size++;
    modCount++;
}
```

看看内部类`Node`的定义

```java
private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {//构造
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}

Node<E> node(int index) {//方法
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
```

![image-20211215202046462](https://s2.loli.net/2021/12/21/8zfBac6wVX9DCj4.png)

### 删remove

#### 方法一:默认删除第一个结点

```java
//演示删除结点
//初始链表：linkedList = [1, 2, 3, 4, 5, 6]
linkedList.remove();
//linkedList = [2, 3, 4, 5, 6]
```

---

```java
public E remove() {
    return removeFirst();
}
```

```java
public E removeFirst() {
    final Node<E> f = first;
    if (f == null)
        throw new NoSuchElementException();
    return unlinkFirst(f);
}
```

```java
private E unlinkFirst(Node<E> f) {//删掉第一个结点，返回第一个结点里面的item
    // assert f == first && f != null;
    final E element = f.item;
    final Node<E> next = f.next;
    f.item = null;
    f.next = null; // help GC
    first = next;
    if (next == null)
        last = null;
    else
        next.prev = null;
    size--;
    modCount++;
    return element;
}
```

#### 方法二：删除指定结点

```java
//演示删除结点
//初始链表：linkedList = [1, 2, 3, 1, 2, 3]
linkedList.remove(new Integer(3));
//linkedList = [1, 2, 1, 2, 3]
```

---

```java
public boolean remove(Object o) {
    if (o == null) {
        for (Node<E> x = first; x != null; x = x.next) {
            if (x.item == null) {
                unlink(x);
                return true;
            }
        }
    } else {
        for (Node<E> x = first; x != null; x = x.next) {
            if (o.equals(x.item)) {
                unlink(x);
                return true;
            }
        }
    }
    return false;
}
```

```java
E unlink(Node<E> x) {
    // assert x != null;
    final E element = x.item;
    final Node<E> next = x.next;
    final Node<E> prev = x.prev;

    if (prev == null) {
        first = next;
    } else {
        prev.next = next;
        x.prev = null;
    }

    if (next == null) {
        last = prev;
    } else {
        next.prev = prev;
        x.next = null;
    }

    x.item = null;
    size--;//链表大小减一
    modCount++;//修改次数加一
    return element;
}
```

#### 方法三：通过index序号删除

```java
//演示删除结点
//初始链表：linkedList = [1, 2, 3, 4, 5, 6]
linkedList.remove(3);
//linkedList = [1, 2, 3, 5, 6]
```

---

```java
public E remove(int index) {
    checkElementIndex(index);//检验是否为有效序号
    return unlink(node(index));
}
```

```java
private void checkElementIndex(int index) {
    if (!isElementIndex(index))
        throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
}
```

```java
E unlink(Node<E> x) {
    // assert x != null;
    final E element = x.item;
    final Node<E> next = x.next;
    final Node<E> prev = x.prev;

    if (prev == null) {
        first = next;
    } else {
        prev.next = next;
        x.prev = null;
    }

    if (next == null) {
        last = prev;
    } else {
        next.prev = prev;
        x.next = null;
    }

    x.item = null;
    size--;
    modCount++;
    return element;
}
```

### 改set

只有一种修改方法`set()`

```java
//演示修改
//linkedList = [2, 3, 4, 5, 6]
linkedList.set(1,999);
//linkedList = [2, 999, 4, 5, 6]
```

---

```java
public E set(int index, E element) {
    checkElementIndex(index);//先查看序号是否存在
    Node<E> x = node(index);//获取该序号对应的结点Node
    E oldVal = x.item;//保留原先结点里面的item
    x.item = element;//放入新的item
    return oldVal;//返回老的item
}
```

```java
/**
 * Returns the (non-null) Node at the specified element index.
 */
Node<E> node(int index) {
    // assert isElementIndex(index);

    if (index < (size >> 1)) {
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    } else {
        Node<E> x = last;
        for (int i = size - 1; i > index; i--)
            x = x.prev;
        return x;
    }
}
```

## LinkedList的遍历方式

### 方法一:linkedList.forEach()

```java
linkedList.forEach(new Consumer() {
    @Override
    public void accept(Object o) {
        System.out.println(o);
    }
});
```

### 方法二:增强for循环

```java
for (Object o:linkedList) {
    System.out.println(o);
}
```

### 方法三:迭代器

```java
Iterator iterator = linkedList.iterator();
while (iterator.hasNext()) {
    Object next =  iterator.next();
    System.out.println(next);
}
```

### 方法四:一般for

```java
for (int i = 0; i < linkedList.size(); i++) {
    System.out.println(linkedList.get(i));
}
```

