package 接口;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 景风眠
 * @Date: 2021/08/14/5:00
 * @Description:
 */
public class Test {

    public static void main(String[] args) {

//        Gold g = new Gold();
//        // 接口也具有多态性
//        Valuable g_1 = new Gold();
//        g.getMoney();

        Panda panda = new Panda();
        panda.eat();
        panda.getMoney();
        panda.hide();

        //向上转型

        //站在动物的角度，只能执行eat()
        Animal a = new Panda();
        //站在值钱的角度，只能getMoney
        Valuable v = new Panda();
        //站在保护的角度，只能藏
        Protectable p = new Panda();
    }
}
