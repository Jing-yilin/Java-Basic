package com.hspedu.set_;

import java.util.HashSet;
import java.util.Objects;

/**
 * @ClassName HashSetExersice02
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/20 18:42
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class HashSetExercise02 {
    public static void main(String[] args) {
        /*
        * 定义一个Employee类，该类包含：private成员属性name,sal,birthday(MyDate类型）,
        * 其中birthday为MyDate类型（属性包括：year,month,day),要求：
        *    1.创建3个Employee 放入 HashSet中
        *    2.当name和birthday的值相同时，认为是相同员工，不能添加到HashSet集合中
        * */

        HashSet hashSet = new HashSet();
        System.out.println(hashSet.add(new Employee("jyl",138129,new MyDate(2002,3,30))));
        System.out.println(hashSet.add(new Employee("jyl",1329,new MyDate(2002,3,30))));

    }
}
class Employee {
    private String name;
    private int sal;
    private MyDate birthday;

    public Employee(String name, int sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(birthday, employee.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }
}

class MyDate {
    int year, month, day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}