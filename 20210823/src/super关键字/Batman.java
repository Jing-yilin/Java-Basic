package super关键字;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 景风眠
 * @Date: 2021/08/13/16:04
 * @Description:
 */
public class Batman extends Hero{

    public Batman(){
        super();
        System.out.println("我是子类的构造方法");
    }

    // 先用子类的变量
    String name = "蝙蝠侠";

    public void eat()
    {
        System.out.println(this.name + " is eating!");
        System.out.println(super.name + " is eating!");
    }

    public static void main(String[] args) {
        Batman batman = new Batman();
        batman.eat();
    }
}
