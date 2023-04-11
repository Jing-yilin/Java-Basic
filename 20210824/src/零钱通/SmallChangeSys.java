package 零钱通;
import java.util.Scanner;

public class SmallChangeSys {
    public static void main(String[] args) {

        // 定义相关变量
        boolean loop = true;
        // 直接输入 new Scanner(System.in).var
        Scanner scanner = new Scanner(System.in);
        String key;

        do{
            System.out.println("-------------零钱通菜单------------");
            System.out.println("\t\t\t\t1 零钱通明细");
            System.out.println("\t\t\t\t2 收益入账");
            System.out.println("\t\t\t\t3 小消费");
            System.out.println("\t\t\t\t1 退出");
            System.out.println("请选择(1-4)");

            key = scanner.next();

            System.out.println("-------------零钱通明细------------");
            switch (key)
            {
                case "1":
                    System.out.println("您要查看零钱通明细");
                    break;
                case "2":
                    System.out.println("您要查看收益入账");
                    break;
                case "3":
                    System.out.println("您要小消费");
                    break;
                case "4":
                    System.out.println("您要退出");
                    loop = false;
                    break;
            }
        }while (loop);

        System.out.println("您退出了零钱通！");

    }
}
