package instanceof关键字;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 景风眠
 * @Date: 2021/08/14/6:00
 * @Description:
 */
public class Cat extends Animal{

    public static void main(String[] args) {
        Animal ani = new Cat();


        if (ani instanceof Cat) {
            System.out.println("我要撸猫");
        } else {
            System.out.println("不是一只猫");
        }
    }
}
