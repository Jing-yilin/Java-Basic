package com.hspedu.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName DrawCircle
 * @Description TODO 演示如何在面板上画圆
 * @Author Jing Yilin
 * @Date 2022/1/20 16:01
 * @Version 1.0
 **/
public class DrawCircle extends JFrame { //JFrame 是窗口,可以理解成一个画框

    //定义一个面板
    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle();
//        System.out.println("退出程序!");
    }

    public DrawCircle() {
        //初始化面板
        mp = new MyPanel();
        //把面板放入到窗口
        this.add(mp);
        //设置窗口的大小
        this.setSize(400, 400);
        //当点击窗口的X关闭，程序退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置可视化
        this.setVisible(true);
        //第一次可视化的时候，paint(Graphic g)被调用
    }
}

//1. 先定义一个面板MyPane,继承JPanel
class MyPanel extends JPanel {
    //说明：
    //1. MyPanel 对象就是一个画板
    //2. Graphics g 把 g 理解为一个画笔
    //3. Graphics 提供了很多绘图方法
    @Override
    public void paint(Graphics g) {//绘图的一个方法
        super.paint(g);//调用父类方法完成初始化
        //画一个圆形
        g.drawOval(30, 30, 100, 100);
//        System.out.println("paint方法被调用了!");

        //演示绘制不同的图形
        //画直线 drawLine(int x1, int y1, int x2, int y2)
        g.drawLine(10, 10, 100, 100);
        //画矩形边框
        g.drawRect(10, 10, 100, 100);
        //画椭圆
        g.drawOval(10, 10, 100, 100);
        //设置画笔颜色
        g.setColor(Color.blue);
        //填充矩形
        g.fillRect(10, 10, 100, 100);
        //填充椭圆
        g.setColor(Color.red);
        g.fillOval(10, 10, 100, 100);
        //画图片
        //获取图片资源
        Image image = Toolkit.getDefaultToolkit().getImage("D:/Desktop/Java_Study/20220121绘图入门/out/production/20220121绘图入门/img.png");
        g.drawImage(image, 10, 10, 300, 300, this);
        //画字符串
        //先设置画笔颜色和字体
        g.setColor(Color.yellow);
        g.setFont(new Font("宋体", Font.BOLD, 50));//传入Font对象:字体，粗细，size
        g.drawString("十万伏特!", 50, 50);

    }
}
