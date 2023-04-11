package com.hspedu.generic_;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @ClassName GenericExercise02
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/20 12:23
 * @Version 1.0
 **/
@SuppressWarnings({"all"})
public class GenericExercise02 {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        Employee employee1 = new Employee("程隰", 9999, new MyDate(11, 18, 2003));
        Employee employee2 = new Employee("景奕林", 8888, new MyDate(3, 30, 2002));
        Employee employee3 = new Employee("晨曦", 6666, new MyDate(9, 12, 2001));
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);

        //传入比较器
        list.sort(Employee.employeeComparator);

        System.out.println("list = " + list);
    }
}
class Employee implements Comparable<Employee>{
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    //写一个Comparator<Employee>的实例
    public static Comparator<Employee> employeeComparator = new Comparator<>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            //先对传入的参数进行校验
            if (!(o1 != null && o2 != null)) {
                System.out.println("类型不正确！");
                return 0;
            }
            return o1.compareTo(o2);
        }
    };

    @Override
    public int compareTo(Employee o) {
        //先比较name
        int strMinus = name.compareTo(o.getName());
        if (strMinus != 0)
        {
            return strMinus;
        } else {//再比较生日
            return birthday.compareTo(o.getBirthday());
        }
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate implements Comparable<MyDate>{
    private int month;
    private int day;
    private int year;

    @Override
    public int compareTo(MyDate o) {
        int yearMinus = year - o.getYear();
        if (yearMinus != 0)
        {
            return yearMinus;
        }
        int monthMinus = month - o.getMonth();
        if (monthMinus != 0)
        {
            return monthMinus;
        }
        return day - o.getDay();
    }

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return  month +
                "/" + day +
                "/" + year;
    }
}
