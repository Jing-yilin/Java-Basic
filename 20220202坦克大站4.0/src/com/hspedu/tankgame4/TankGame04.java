package com.hspedu.tankgame4;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * @ClassName TankGame04
 * @Description 该版本要防止敌人坦克重叠
 *              并且使用Properties存储坦克坐标、数量、方向
 * @Author Jing Yilin
 * @Date 2022/2/22 22:17
 * @Version 4.0
 **/
public class TankGame04 extends JFrame {

    //定义一个panel
    MyPanel mp = null;
    public static final int FRAME_WIDTH = 700;//画框宽度
    public static final int FRAME_HEIGHT = 500;//画框高度
    public static void main(String[] args) {
        new TankGame04();
    }

    public TankGame04(){
        mp = new MyPanel();
        //将mp放入thread并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(FRAME_WIDTH+250, FRAME_HEIGHT+38);//窗口大小
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //监听窗口关闭
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Recorder.storeInfo();
//                    System.out.println("游戏结束，存档成功!");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
    }
}
