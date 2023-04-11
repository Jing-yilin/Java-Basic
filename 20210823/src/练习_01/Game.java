package 练习_01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 景风眠
 * @Date: 2021/08/13/16:54
 * @Description:
 */
public class Game {
    String name = "未设置名称";
    public void play(){
        System.out.println("你正在玩"+this.name + "！");
    }
    public void start(){
        System.out.println("游戏开始啦！");
    }
    public void end(){
        System.out.println("游戏结束啦！");
    }
}
