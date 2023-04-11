/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 景风眠
 * @Date: 2021/08/13/15:00
 * @Description: https://www.bilibili.com/video/BV1RU4y1h7my?p=56&spm_id_from=pageDriver
 */
// package必须写在第一行
package xyz.demo_1;
// 导入包
import xyz.jingyilin.Person;

public class TestPerson {
    public String pub = "public";
    private String pri = "private";
    String def = "default";

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p.pub);
//        System.out.println(p.pri);  //  访问不了了
//        System.out.println(p.def);  //  访问不了了
    }
}
