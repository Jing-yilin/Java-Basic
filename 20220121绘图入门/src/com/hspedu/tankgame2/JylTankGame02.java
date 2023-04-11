package com.hspedu.tankgame2;

import javax.swing.*;

/**
 * @ClassName JylTankGame01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/20 22:17
 * @Version 1.0
 **/
public class JylTankGame02 extends JFrame {

    //定义一个panel
    MyPanel mp = null;
    public static final int FRAME_WIDTH = 1000;//画框宽度
    public static final int FRAME_HEIGHT = 750;//画框高度
    public static void main(String[] args) {
        new JylTankGame02();
    }

    public JylTankGame02(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);//窗口大小
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
