package com.hspedu.list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName ListExercise02
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/8 8:19
 * @Version 1.0
 **/
public class ListExercise02 {
    //对list使用冒泡排序
    public static void sortList(List list)
    {
        Book tmp = new Book();
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size()-1-i; j++) {
                Book book1 = (Book)list.get(j);
                Book book2 = (Book)list.get(j+1);
                if (book1.getPrice() > book2.getPrice())
                {
                    tmp = book1;
                    list.set(j,book2);
                    list.set(j+1,tmp);
                }
            }
        }
    }
    public static void showList(List list)
    {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
    }
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add(new Book("三国演义","罗贯中",10.1));
        list.add(new Book("小李飞刀","古龙",5.1));
        list.add(new Book("红楼梦","曹雪芹",34.6));

        sortList(list);

        showList(list);
    }
}
class Book
{
    private String name;
    private String author;
    private double price;


    @Override
    public String toString() {
        return  "名称：" + name + "\t\t价格：" + price + "\t作者：" + author;
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

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Book(){}
}
