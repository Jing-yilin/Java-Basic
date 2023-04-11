package com.hspedu.tankgame4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.Vector;

/**
 * @ClassName MyPanel
 * @Description
 * @Author Jing Yilin
 * @Date 2022/1/20 22:14
 * @Version 1.0
 **/

/*
 * 坦克大战的绘图区
 * 为了让Panel不停绘制，需要把他做成线程，实现Runnable
 */
@SuppressWarnings("all")
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义我的坦克
    Hero hero = new Hero(300, 300, 0, 10);
    //定义坦克爆炸的bomb
    Bomb heroBomb = null;
    //敌方坦克数量
    int jokerSize = 10;
    //一个Vector存放敌方坦克
    Vector<Joker> jokers = new Vector<>();
    //一个Vetor存放Bomb
    Vector<Bomb> bombs = new Vector<>();
    //是否继续
    boolean continueGame = true;


    public MyPanel() {
        Recorder.setHero(hero);
        Recorder.setJokers(jokers);
        //每个joker传入数组
        Joker.setJokers(jokers);

        System.out.println("您想要继续游戏吗?(y/n)");
        Scanner scanner = new Scanner(System.in);
        char c = Character.toUpperCase(scanner.next().charAt(0));
        if (c == 'Y') {
            continueGame = true;

        } else {
            continueGame = false;
        }
        //重新开始游戏
        if (!continueGame) {
            this.hero = new Hero(150, 150, 0, 10);//初始化一个我方坦克
            Joker.setJokers(jokers);
            // 初始化敌人的坦克
            for (int i = 0; i < jokerSize; i++) {
                Joker joker = new Joker(30 + 50 * i, 50, 1);
                jokers.add(joker);
                if (joker.hero == null) {
                    joker.setHero(this.hero);
                }
                //启动joker线程
                Thread thread = new Thread(joker);
                thread.start();
            }
        }


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //作为背景板
        g.fillRect(0, 0, TankGame04.FRAME_WIDTH, TankGame04.FRAME_HEIGHT);
        //绘制我方hero坦克
        if (hero != null && hero.isLive) {
            drawTank(hero, g);
        }
        if (hero == null)
        {
            System.out.println("hero = null");
        }
        //绘制hero发出的子弹
        drawBullet(hero, g);
        //绘制炸弹
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.isLive) {
                g.drawImage(bomb.myImage, bomb.x - Bomb.WIDTH / 2, bomb.y - Bomb.LENGTH / 2, Bomb.WIDTH, Bomb.LENGTH, this);
            } else {
                bombs.remove(bomb);
            }
        }
        //绘制敌方坦克
        for (int i = 0; i < jokers.size(); i++) {
            Joker joker = jokers.get(i);
            if (joker.isLive)
                drawTank(jokers.get(i), g);
            else {//TODO:  if (!joker.isLive && joker.shots.size() == 0)
                jokers.remove(joker);
            }
        }
        //绘制jokers发射子弹
        for (int i = 0; i < jokers.size(); i++) {
            Joker joker = jokers.get(i);
            for (int j = 0; j < joker.shots.size(); j++) {
                Shot shot = joker.shots.get(j);
                if (shot.isLive) {
                    g.draw3DRect(shot.getX(), shot.getY(), Shot.WIDTH, Shot.LENGTH, false);
                } else {
                    joker.shots.remove(shot);
                }

            }
        }

        //展现信息
        showInfo(g);
        //如果hero已经死亡,显示游戏结束
//        if (!hero.isLive) {
//            g.setColor(Color.gray);
//            g.fill3DRect(0, 0, TankGame04.FRAME_WIDTH, TankGame04.FRAME_HEIGHT, true);
//            g.setColor(Color.blue);
//            g.drawString("Game Over", TankGame04.FRAME_WIDTH / 2, TankGame04.FRAME_HEIGHT / 2);
//        }

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
        int w = Tank.WIDTH;
        int l = Tank.LENGTH;

        //根据坦克的方向绘制坦克
        switch (direct) {
            case 0://坦克向上
                g.fill3DRect(x - w / 2, y - l / 2, w * 3 / 10, l, false);
                g.fill3DRect(x + w / 5, y - l / 2, w * 3 / 10, l, false);
                g.fill3DRect(x - w / 2 + w * 3 / 10, y - l / 2 + l * 2 / 10, w * 4 / 10, l * 6 / 10, false);
                g.fillOval(x - w * 15 / 100, y - w * 15 / 100, w * 3 / 10, w * 3 / 10);
                g.fill3DRect(x - w * 1 / 20, y - l * 35 / 100, w * 1 / 10, l * 35 / 100, true);
                break;
            case 1://坦克向下
                g.fill3DRect(x - w / 2, y - l / 2, w * 3 / 10, l, false);
                g.fill3DRect(x + w / 5, y - l / 2, w * 3 / 10, l, false);
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

    public void hitHero() {
        if (hero != null && hero.isLive) {
            for (int i = 0; i < jokers.size(); i++) {
                Joker joker = jokers.get(i);
                for (int j = 0; j < joker.shots.size(); j++) {
                    Shot shot = joker.shots.get(j);
                    if (hero.isLive && shot.isLive) {
                        hitTank(shot, hero);
                    }
                }

            }
            if (!hero.isLive) {
//                System.out.println("hero已经死亡...");
                Bomb bomb = new Bomb(hero.getX(), hero.getY());
                bombs.add(bomb);
                bomb.start();
//                System.out.println("炸弹已经启动");
            }
        }
    }

    public void hitJoker() {
        if (hero != null) {
            for (int i = 0; i < hero.shots.size(); i++) {
                Shot shot = hero.shots.get(i);
                if (shot.isLive) {
                    for (int j = 0; j < jokers.size(); j++) {
                        Joker joker = jokers.get(j);
                        hitTank(shot, joker);//TODO
                        if (!joker.isLive) {
                            Bomb bomb = new Bomb(joker.getX(), joker.getY());
                            bombs.add(bomb);
                            bomb.start();
                        }
                    }
                }
            }
        }

    }


    public void drawBullet(Tank tank, Graphics g) {
        if (tank != null && tank.shots != null && tank.shots != null) {
            for (int i = 0; i < tank.shots.size(); i++) {
                Shot shot = tank.shots.get(i);
                if (shot.isLive) {
                    int x = shot.getX();
                    int y = shot.getY();
                    int direct = shot.getDirect();
                    int w = Shot.WIDTH;
                    int l = Shot.LENGTH;
                    //根据不同类型的坦克设置不同的颜色
                    switch (shot.getType()) {
                        case 0://我们的坦克
                            g.setColor(Color.cyan);
                            break;
                        case 1://敌人的坦克
                            g.setColor(Color.yellow);
                            break;
                    }
                    switch (direct) {
                        case 0:
                            g.fillRect(x - w / 2, y - l, l, w);
                            break;
                        case 1:
                            g.fillRect(x - w / 2, y, l, w);
                            break;
                        case 2:
                            g.fillRect(x, y - w / 2, w, l);
                            break;
                        case 3:
                            g.fillRect(x - l, y - w / 2, w, l);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    public void showInfo(Graphics g) {
        g.setColor(Color.BLACK);
        Font font = new Font("宋体", Font.BOLD, 15);
        g.setFont(font);
        g.drawString("您累计击毁敌方坦克", TankGame04.FRAME_WIDTH + 50, 30);
        drawTank(new Joker(TankGame04.FRAME_WIDTH + 50, 100, 0), g);
        g.setColor(Color.BLACK);
        Font NumFont = new Font("宋体", Font.BOLD, 100);
        g.setFont(font);
        g.drawString(new Integer(Recorder.destroyedJokerNum).toString(), TankGame04.FRAME_WIDTH + 150, 100);
    }

    //编写方法，判断子弹是否击中坦克
    public void hitTank(Shot shot, Tank tank) {
        switch (tank.getDirect()) {
            case 0:
            case 1:
                if (shot.getX() > tank.getX() - tank.WIDTH / 2 && shot.getX() < tank.getX() + tank.WIDTH / 2
                        && shot.getY() > tank.getY() - tank.LENGTH / 2 && shot.getY() < tank.getY() + tank.LENGTH / 2) {
                    tank.isLive = false;
                    shot.isLive = false;
                    if (tank instanceof Joker) {
                        Recorder.addDestroyedJokerNum();
                    }
                }
                break;
            case 2:
            case 3:
                if (shot.getX() > tank.getX() - tank.LENGTH / 2 && shot.getX() < tank.getX() + tank.LENGTH / 2
                        && shot.getY() > tank.getY() - tank.WIDTH / 2 && shot.getY() < tank.getY() + tank.WIDTH / 2) {
                    tank.isLive = false;
                    shot.isLive = false;
                    if (tank instanceof Joker) {
                        Recorder.addDestroyedJokerNum();
                    }
                }
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
        if (hero != null) {
            int oldX = hero.getX();
            int oldY = hero.getY();
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
            //防止hero撞到joker
            for (int i = 0; i < jokers.size(); i++) {
                Joker joker = jokers.get(i);
                Tank.aVoidCrush(hero, joker);
            }
            if (keyCode == KeyEvent.VK_J) {
//            System.out.println("用户按下了J，开始射击！");
                hero.shotEnemyTank();
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void run() {//每隔50ms，重绘区域

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Recorder recorder = new Recorder();

        //如果继续游戏
        if (continueGame) {
            //读取记录的数据
            Recorder.readRecord();
            //启动joker线程
            for (Joker joker : jokers) {
                Thread thread = new Thread(joker);
                thread.start();
            }
        }

        //创建一个线程单独控制joker的行为
        AutoControlJoker autoControlJoker = new AutoControlJoker(jokers, hero);
        autoControlJoker.start();
        //启动Recorder自动寻当
        Thread recorderThread = new Thread(recorder);
        recorderThread.start();

        while (true) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //判断子弹是否击中敌方坦克
            hitJoker();
            //判断敌方坦克是否击中自己
            hitHero();

            this.repaint();

        }
    }
}
