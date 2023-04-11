package 接口;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 景风眠
 * @Date: 2021/08/14/4:58
 * @Description:
 */
public class Gold implements Valuable{

    // 必须实现抽象方法
    public void getMoney(){
        System.out.println("黄金可以换钱！");
    }
}
