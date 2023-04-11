package com.hspedu.tankgame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

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
public class MyPanel extends JPanel implements KeyListener {
    //定义我的坦克
    Hero hero = null;
    //敌方坦克数量
    int jokerSize = 25;
    //一个Vector存放敌方坦克
    Vector<Joker> jokers = new Vector<>();

    public MyPanel() {
        hero = new Hero(150, 150, 0, 10);//初始化一个我方坦克
        //初始化敌人的坦克
        for (int i = 0; i < jokerSize; i++) {
            jokers.add(new Joker(30+50*i, 50, 1));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //作为背景板
        g.fillRect(0, 0, 1500, 1250);
        //绘制我方hero坦克
        drawTank(hero, g);
        //绘制敌方坦克
        for (int i = 0; i < jokers.size(); i++) {
            drawTank(jokers.get(i), g);
        }
    }

    /**
     * @param x      坦克左上角的x坐标
     * @param y      坦克左上角的y坐标
     * @param g      画笔
     * @param direct 坦克方向
     * @param type   坦克类型
     */

    public void drawTank(Tank tank, Graphics g) {
        int x = tank.getX();
        int y = tank.getY();
        int direct = tank.getDirect();
        int type = tank.getType();
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
        int w = 30;
        int l = 40;

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
            case 3://坦克向左
                g.fill3DRect(x - l / 2, y - w / 2, l, w * 3 / 10, false);
                g.fill3DRect(x - l / 2, y + w * 2 / 10, l, w * 3 / 10, false);
                g.fill3DRect(x - l * 3 / 10, y - w * 2 / 10, l * 6 / 10, w * 4 / 10, false);
                g.fillOval(x - w * 15 / 100, y - w * 15 / 100, w * 3 / 10, w * 3 / 10);
                g.fill3DRect(x - l * 35 / 100, y - w * 1 / 20, l * 35 / 100, w * 1 / 10, true);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //0：向上
    //1：向下
    //2：向右
    //3：向左
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        //处理WSAD四个键控制上下左右移动
        if (keyCode == KeyEvent.VK_W) {
            this.hero.setDirect(0);
            hero.moveUp();
        } else if (keyCode == KeyEvent.VK_S) {
            this.hero.setDirect(1);
            hero.moveDown();
        } else if (keyCode == KeyEvent.VK_A) {
            this.hero.setDirect(3);
            hero.moveLeft();
        } else if (keyCode == KeyEvent.VK_D) {
            this.hero.setDirect(2);
            hero.moveRight();
        }


        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
