package com.hspedu.tankgame3;

import javax.swing.*;

/**
 * @ClassName JylTankGame01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/20 22:17
 * @Version 1.0
 **/
public class TankGame03 extends JFrame {

    //定义一个panel
    MyPanel mp = null;
    public static final int FRAME_WIDTH = 1500;//画框宽度
    public static final int FRAME_HEIGHT = 1000;//画框高度
    public static void main(String[] args) {
        new TankGame03();
    }

    public TankGame03(){
        mp = new MyPanel();
        //将mp放入thread并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);//窗口大小
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
