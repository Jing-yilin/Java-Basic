package com.hspedu.homework;

/**
 * @ClassName Homework06
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/6 22:56
 * @Version 1.0
 **/
public class Homework06 {
    public static void main(String[] args) {
        Person person = new Person("唐僧", new Horse());
        person.passRiver();
        person.common();

    }
}

interface Vehicles{
    void work();
}

class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("骑马！");
    }
}
class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("开船！");
    }
}

class Person{
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passRiver(){
        if(!(vehicles instanceof Boat)){
            vehicles = new Boat();
        }
        this.vehicles.work();
    }

    public void common(){
        if(!(vehicles instanceof Horse)){
            vehicles = new Horse();
        }
        this.vehicles.work();
    }
}