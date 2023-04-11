package com.hspedu.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName ArrayExercise
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/2 9:12
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class ArrayExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅", 90);
        books[2] = new Book("青年文摘", 5);
        books[3] = new Book("JAVA从入门到放弃", 300);
        System.out.println("======排序前=====");
        System.out.println(Arrays.toString(books));

        //升序排序
        bubbleSortCustom(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                return b1.price- b2.price;
            }
        });
        System.out.println("======升序排序后=====");
        System.out.println(Arrays.toString(books));

        //降序排序
        bubbleSortCustom(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                return b2.price- b1.price;
            }
        });
        System.out.println("======降序排序后=====");
        System.out.println(Arrays.toString(books));

        //按照书名长度降序排序
        bubbleSortCustom(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                return b2.name.length() - b1.name.length();
            }
        });
        System.out.println("======按照书名长度降序排序后=====");
        System.out.println(Arrays.toString(books));
    }

    public static void bubbleSortCustom(Book[] books, Comparator c) {
        Book tmp = new Book(null, 0);
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - 1 - i; j++) {
                if (c.compare(books[j], books[j + 1]) > 0) {
                    tmp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = tmp;
                }
            }
        }
    }
}

class Book {
    public String name;
    public int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
