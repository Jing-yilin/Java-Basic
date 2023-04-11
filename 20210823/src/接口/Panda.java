package 接口;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 景风眠
 * @Date: 2021/08/14/5:04
 * @Description:
 */
public class Panda extends Animal implements Protectable, Valuable{
    @Override
    public void hide() {
        System.out.println("hide");
    }

    @Override
    public void getMoney() {
        System.out.println("get money");
    }

    @Override
    public void eat() {
        System.out.println("eat");
    }
}
