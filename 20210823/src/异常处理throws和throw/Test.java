package 异常处理throws和throw;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 景风眠
 * @Date: 2021/08/14/8:12
 * @Description:
 */


public class Test {

    public static void division(int a, int b) throws Exception {
        if (b == 0){
            throw new Exception("你不能让一个数除以零！");
        } else {
            System.out.println(a/b);
        }
    }

    public static void main(String[] args) {
        try {
            division(1, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
