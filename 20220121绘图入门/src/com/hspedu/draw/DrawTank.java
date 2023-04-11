package com.hspedu.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName DrawTank
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/20 21:01
 * @Version 1.0
 **/
public class DrawTank extends JFrame {

    private MyTankPanel mp = null;
    public static void main(String[] args) {
        new DrawTank();
    }
    DrawTank() {
        this.mp = new MyTankPanel();
        this.add(mp);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyTankPanel extends JPanel{

    int cx = 100;
    int cy = 100;
    int w = 150;
    int l = 200;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        //左车轮
//        g.setColor(Color.darkGray);
//        g.drawRect(cx-w/2, cy-l/2, w*3/10, l);
//        g.fillRect(cx-w/2, cy-l/2, w*3/10, l);
//        //右车轮
//        g.setColor(Color.darkGray);
//        g.drawRect(cx-w/2+w*7/10, cy-l/2, w*3/10, l);
//        g.fillRect(cx-w/2+w*7/10, cy-l/2, w*3/10, l);
//        //中间基座
//        g.setColor(Color.black);
//        g.drawRect(cx-w/2+w*3/10, cy-l/2+l*2/10, w*4/10, l*6/10);
//        g.fillRect(cx-w/2+w*3/10, cy-l/2+l*2/10, w*4/10, l*6/10);
//        //中间圆形驾驶舱
//        g.setColor(Color.gray);
//        g.drawOval(cx-w*15/100, cy-w*15/100, w*3/10, w*3/10);
//        g.fillOval(cx-w*15/100, cy-w*15/100, w*3/10, w*3/10);
//        //矩形炮管
//        g.setColor(Color.gray);
//        g.drawRect(cx-w*1/20, cy-l*35/100, w*1/10, l*35/100);
//        g.fillRect(cx-w*1/20, cy-l*35/100, w*1/10, l*35/100);

    }
}
