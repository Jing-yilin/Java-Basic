package com.hspedu.codeBlock_;

public class CodeBlock01 {
    public static void main(String[] args) {
        Movie movie = new Movie("怦然心动");
        Movie movie2 = new Movie("哈利波特",122);

    }
}

class Movie {
    private String name;
    private double price;
    private String director;

    //最先调用，只会被调用一次
    static
    {
        System.out.println("静态代码块1");
    }

    //普通构造代码块每次创建对象时都会被调用
    {
        System.out.println("构造代码块1");
    }

    //以下为以下构造方法

    public Movie(String name) {
        System.out.println("Movie(String name)被调用" );
        this.name = name;
    }

    public Movie(String name, double price) {
        System.out.println("Movie(String name, double price)被调用" );
        this.name = name;
        this.price = price;
    }

    public Movie(String name, double price, String director) {
        System.out.println("Movie(String name, double price, String director)被调用" );
        this.name = name;
        this.price = price;
        this.director = director;
    }
}
