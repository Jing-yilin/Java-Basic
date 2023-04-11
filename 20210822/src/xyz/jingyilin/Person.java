package xyz.jingyilin;  //  包的声明，表示当前类从属于jingyilin这个包

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 景风眠
 * @Date: 2021/08/13/14:58
 * @Description:
 */
public class Person {
    public String pub = "public";
    private String pri = "private";
    String def = "default";

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p.pub);
        System.out.println(p.pri);
        System.out.println(p.def);
    }
}
