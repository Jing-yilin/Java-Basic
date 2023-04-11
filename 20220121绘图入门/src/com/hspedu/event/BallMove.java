package com.hspedu.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @ClassName BallMove
 * @Description TODO 演示小球通过键盘控制上下左右的移动
 * @Author Jing Yilin
 * @Date 2022/1/21 12:37
 * @Version 1.0
 **/
public class BallMove extends JFrame{
    MyPanel mp = null;
    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        this.addKeyListener(mp);//增加事件的监听 addKeyListener(KeyListener l)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//实现KeyListener,是个监听器
class MyPanel extends JPanel implements KeyListener {

    private int x = 10;
    private int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);//默认黑色
    }

    //有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //某个键按下去，该方法会被触发
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println((char)e.getKeyCode() + "被按下了!");

        //根据用户按下的不同键来处理小球的移动
        //每一个键都有一个值
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {// public static final int VK_DOWN           = 0x28;
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        }

        //让面板重绘
        this.repaint();
    }

    //某个键松开了，该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println((char)e.getKeyCode() + "被松开了!");
    }
}
