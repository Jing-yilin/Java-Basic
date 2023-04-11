package xyz.jingyilin;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 景风眠
 * @Date: 2021/08/13/15:13
 * @Description:
 */
public class TestPerson_01 {
    public String pub = "public";
    private String pri = "private";
    String def = "default";

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p.pub);
//        System.out.println(p.pri);  //  私有内容不可访问了
        System.out.println(p.def);
    }
}
