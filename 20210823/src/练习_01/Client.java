package 练习_01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 景风眠
 * @Date: 2021/08/13/16:53
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        Game lol = new LOL();
        Game cs = new CS();
        Game dnf = new DNF();
        Player player1 = new Player();
        player1.happy(lol);
        player1.happy(cs);
        player1.happy(dnf);

    }
}
