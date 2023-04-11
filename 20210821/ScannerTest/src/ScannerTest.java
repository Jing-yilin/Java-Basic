//使用scanner类从键盘获取输入

//1.导包
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        System.out.println("Your numer is: " + num);
    }
}
