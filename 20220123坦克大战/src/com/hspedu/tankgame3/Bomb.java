package com.hspedu.tankgame3;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

/**
 * @ClassName AutoControlBomb
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/28 19:05
 * @Version 1.0
 **/
public class Bomb extends Thread{
    public static final int WIDTH = 60;
    public static final int LENGTH = 60;

    int x, y;
    boolean isLive = true;
    //定义三张炸弹图片，用于显示炸弹效果
    private static Image image1 = Toolkit.getDefaultToolkit().getImage("D:\\Desktop\\Java_Study\\20220123坦克大战\\src\\com\\hspedu\\tankgame3\\image\\1.png");
    private static Image image2 = Toolkit.getDefaultToolkit().getImage("D:\\Desktop\\Java_Study\\20220123坦克大战\\src\\com\\hspedu\\tankgame3\\image\\2.png");
    private static Image image3 = Toolkit.getDefaultToolkit().getImage("D:\\Desktop\\Java_Study\\20220123坦克大战\\src\\com\\hspedu\\tankgame3\\image\\3.png");
    Image myImage = image2;
    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        long sleepTime = 30;
        System.out.println("爆炸效果启动");
        long l1 = System.currentTimeMillis();

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myImage = image3;
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myImage = image2;
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myImage = image1;
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long l2 = System.currentTimeMillis();
        System.out.println("炸弹死亡，花费时间"+((double)l2-l1)/1000+"s");
        isLive = false;
    }

    public void sleep(Long sleepTime){
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
