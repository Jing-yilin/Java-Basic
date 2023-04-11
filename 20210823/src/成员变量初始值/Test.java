package 成员变量初始值;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 景风眠
 * @Date: 2021/08/14/5:23
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Person p = new Person();
        System.out.println("byte = " + p.b);
        System.out.println("short = " + p.s);
        System.out.println("int = " + p.i);
        System.out.println("long = " + p.l);
        System.out.println("char = " + p.c);
        System.out.println("float = " + p.f);
        System.out.println("double = " + p.d);
        System.out.println("boolean = " + p.boo);
        System.out.println("String = " + p.str);
        System.out.println("Child = " + p.child);

    }
}
