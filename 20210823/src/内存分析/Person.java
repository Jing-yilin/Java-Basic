package 内存分析;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 景风眠
 * @Date: 2021/08/14/6:10
 * @Description:
 */
public class Person {
    private String name;
    private int age;
    private String address;
    public static int num = 0;

    public Person(String name, int age, String address){
        this.name = name;
        this.age = age;
        this.address = address;

        num++;
    }

    public static void main(String[] args){

        int a = 10;

        Person p1 = new Person("少林寺", 18,"河南嵩山");
        Person p2 = new Person("吐鲁番", 12, "新疆");
        Person p3 = new Person("海南岛", 16, "海南");
        Person p4 = new Person("北戴河", 4, "河北");
        System.out.println(Person.num);
    }
}