package com.hspedu.tankgame;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName MyPanel
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/20 22:14
 * @Version 1.0
 **/

/*
 * 坦克大战的绘图区
 * */
@SuppressWarnings("all")
public class MyPanel extends JPanel {
    //定义我的坦克
    Hero hero = null;

    public MyPanel() {
        hero = new Hero(100, 100);//初始化一个坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //作为背景板
        g.fillRect(0, 0, 1500, 1250);
        drawTank(hero.getX(), hero.getY(), g, 3, 0);
        drawTank(hero.getX()+300, hero.getY()+300, g, 1, 1);
    }

    /**
     * @param x      坦克左上角的x坐标
     * @param y      坦克左上角的y坐标
     * @param g      画笔
     * @param direct 坦克方向
     * @param type   坦克类型
     */

    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        //根据不同类型的坦克设置不同的颜色
        switch (type) {
            case 0://我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1://敌人的坦克
                g.setColor(Color.yellow);
                break;
        }

        //坦克的宽和长
        int w = 20;
        int l = 30;

        //根据坦克的方向绘制坦克
        switch (direct) {
            case 0://坦克向上
                g.fill3DRect(x - w / 2, y - l / 2, w * 3 / 10, l, false);
                g.fill3DRect(x - w / 2 + w * 7 / 10, y - l / 2, w * 3 / 10, l, false);
                g.fill3DRect(x - w / 2 + w * 3 / 10, y - l / 2 + l * 2 / 10, w * 4 / 10, l * 6 / 10, false);
                g.fillOval(x - w * 15 / 100, y - w * 15 / 100, w * 3 / 10, w * 3 / 10);
                g.fill3DRect(x - w * 1 / 20, y - l * 35 / 100, w * 1 / 10, l * 35 / 100, true);
                break;
            case 1://坦克向下
                g.fill3DRect(x - w / 2, y - l / 2, w * 3 / 10, l, false);
                g.fill3DRect(x - w / 2 + w * 7 / 10, y - l / 2, w * 3 / 10, l, false);
                g.fill3DRect(x - w / 2 + w * 3 / 10, y - l / 2 + l * 2 / 10, w * 4 / 10, l * 6 / 10, false);
                g.fillOval(x - w * 15 / 100, y - w * 15 / 100, w * 3 / 10, w * 3 / 10);
                g.fill3DRect(x - w * 1 / 20, y, w * 1 / 10, l * 35 / 100, true);
                break;
            case 2://坦克向右
                g.fill3DRect(x - l / 2, y - w / 2, l, w * 3 / 10, false);
                g.fill3DRect(x - l / 2, y + w * 2 / 10, l, w * 3 / 10, false);
                g.fill3DRect(x - l * 3 / 10, y - w * 2 / 10, l * 6 / 10, w * 4 / 10, false);
                g.fillOval(x - w * 15 / 100, y - w * 15 / 100, w * 3 / 10, w * 3 / 10);
                g.fill3DRect(x, y - w * 1 / 20, l * 35 / 100, w * 1 / 10, true);
                break;
            case 3://坦克向右
                g.fill3DRect(x - l / 2, y - w / 2, l, w * 3 / 10, false);
                g.fill3DRect(x - l / 2, y + w * 2 / 10, l, w * 3 / 10, false);
                g.fill3DRect(x - l * 3 / 10, y - w * 2 / 10, l * 6 / 10, w * 4 / 10, false);
                g.fillOval(x - w * 15 / 100, y - w * 15 / 100, w * 3 / 10, w * 3 / 10);
                g.fill3DRect(x - l * 35 / 100, y - w * 1 / 20, l * 35 / 100, w * 1 / 10, true);
                break;
            default:
                System.out.println("暂时不处理！");
        }
    }
}
