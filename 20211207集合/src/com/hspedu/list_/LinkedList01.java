package com.hspedu.list_;

import java.security.PublicKey;

/**
 * @ClassName LinkedList01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/15 19:43
 * @Version 1.0
 **/
public class LinkedList01 {
    public static void main(String[] args) {
        //模拟一个简单的双向链表
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node jyl = new Node("景奕林");

        //连接三个结点，形成双向链表
        jack.next = tom;
        tom.pre = jack;
        tom.next = jyl;
        jyl.pre = tom;
        //jack<->tom<->jyl

        Node first = jack;//让first作为双向链表的头节点
        Node last = jyl;//让last作为双向链表的为节点

        //演示重头到尾进行遍历
        while(true)
        {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }

        //演示从尾到头遍历
        while(true)
        {
            if (last == null) {
                break;
            }
            System.out.println(last);
            last = last.pre;
        }

        //演示添加结点
        //要求在tom和jyl直接插入Smith
        //1.先创建Node结点，名字是Smith
        Node smith = new Node("Smith");
        smith.pre = tom;
        smith.next = jyl;
        tom.next = smith;
        jyl.pre = smith;
        //再输出一下链表
        first = jack;
        while(true)
        {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }


    }
}

//定义一个Node类，Node对象表示双向链表的一个结点
class Node {
    public Object item; // 真正存放数据的地方
    public Node next; // 指向下一个结点
    public Node pre; // 指向前一个结点

    public Node(Object name) {
        this.item = name;
    }

    @Override
    public String toString() {
        return "Node name = " + item;
    }
}