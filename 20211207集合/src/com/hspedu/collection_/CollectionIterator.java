package com.hspedu.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 * @ClassName CollectionIterator
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/7 23:12
 * @Version 1.0
 **/
public class CollectionIterator {
    @SuppressWarnings("all")
    public static void main(String[] args) {
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
//        while(iterator.hasNext()){
//            Object next = iterator.next();//编译类型是Object，但是运行类型取决于元素的种类
//            System.out.println("next = " + next);
//        }
        //使用快捷键，快速生成while循环：itit
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println("next = " + next);
        }
        //Ctrl+J可以列出所有的快捷模板

        //3. 当退出while循环后，这是迭代器指向最后的元素，再取会报错
        //4. 如果需要再次遍历，需要充值迭代器
        iterator = col.iterator();//重置迭代器
    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
