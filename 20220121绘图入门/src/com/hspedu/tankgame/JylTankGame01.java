package com.hspedu.tankgame;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName JylTankGame01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/20 22:17
 * @Version 1.0
 **/
public class JylTankGame01 extends JFrame {

    //定义一个panel
    MyPanel mp = null;
    public static void main(String[] args) {
        new JylTankGame01();
    }

    public JylTankGame01(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
