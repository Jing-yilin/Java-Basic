package 抽象;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 景风眠
 * @Date: 2021/08/14/4:07
 * @Description:
 */
public class Cat extends Animal{
    //子类必须重写父类的抽象方法，否则子类必须也是抽象类
    public void eat(){
        System.out.println("猫吃鱼");
    }
}
