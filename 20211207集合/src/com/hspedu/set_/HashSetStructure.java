package com.hspedu.set_;

/**
 * @ClassName HashSetStructure
 * @Description TODO 模拟简单的数组+链表结构
 * @Author Jing Yilin
 * @Date 2021/12/16 16:42
 * @Version 1.0
 **/
public class HashSetStructure {
    public static void main(String[] args) {
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

    }
}

class Node {
    public Object item; // 真正存放数据的地方
    public Node next; // 指向下一个结点
    public Node pre; // 指向前一个结点

    public Node(Node pre, Object item, Node next) {
        this.pre =pre;
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node item = " + item;
    }
}