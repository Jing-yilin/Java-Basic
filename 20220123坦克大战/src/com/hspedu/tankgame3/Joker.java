package com.hspedu.tankgame3;

import java.util.Random;
import java.util.Vector;

/**
 * @ClassName Joker
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/21 13:37
 * @Version 1.0
 **/
public class Joker extends Tank implements Runnable {
    public boolean heroInWay = false;
    public int futureSteps = 0;
    public static Hero hero = null;

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    {
        setSpeed(2);
        setType(1);
        shots = new Vector<>();
    }

    public Joker(int x, int y, int direct) {
        super(x, y, direct);
    }

    //判断是否发现hero
    public void checkHero(Hero hero) {
        heroInWay = false;
        if (hero.isLive) {
            int jokerX = this.getX();
            int jokerY = this.getY();
            int heroX = hero.getX();
            int heroY = hero.getY();

            switch (this.getDirect()) {
                case 0:
                    if (jokerX > heroX - Tank.WIDTH / 2 && jokerX < heroX + Tank.WIDTH / 2 && heroY < jokerY)
                        this.heroInWay = true;
                    break;
                case 1:
                    if (jokerX > heroX - Tank.WIDTH / 2 && jokerX < heroX + Tank.WIDTH / 2 && heroY > jokerY)
                        this.heroInWay = true;
                    break;
                case 2:
                    if (jokerY > heroY - Tank.WIDTH / 2 && jokerY < heroY + Tank.WIDTH / 2 && heroX > jokerX)
                        this.heroInWay = true;
                    break;
                case 3:
                    if (jokerY > heroY - Tank.WIDTH / 2 && jokerY < heroY + Tank.WIDTH / 2 && heroX < jokerX)
                        this.heroInWay = true;
                    break;
                default:
                    break;
            }
            if (heroInWay)
                System.out.println("Hero被敌方坦克发现...");
        }

    }

    public void shotHero() {
        //清理一遍shots里的子弹，如果!isLive就删除
        for (int i = 0; i < shots.size(); i++) {
            if (!shots.get(i).isLive) {
                shots.remove(i);
            }
        }
        if (heroInWay) {
//            System.out.println("发现敌人");
            shot = new Shot(this);
            shot.setType(this.getType());
            shot.setSpeed(1);
            shots.add(shot);
            Thread thread = new Thread(shot);
            thread.start();
            System.out.println("Joker子弹发射...");
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " -- joker starts...");
        while (isLive) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (futureSteps <= 0) {
                Random random = new Random();
                //生成[10,50)内的任意步数
                futureSteps = 10 + random.nextInt(50);
//                futureSteps = 200;
                //生成任意方向
                direct = random.nextInt(4);
//                direct = 2;
            }
            while (futureSteps >= 0) {
                switch (direct) {
                    case 0 -> {
                        moveUp();
                        if (y - Tank.LENGTH / 2 <= 0 || MyPanel.isOverLap(this, hero)) {
                            futureSteps = 0;
                        }
                    }
                    case 1 -> {
                        moveDown();
                        if (y + Tank.LENGTH / 2 >= TankGame03.FRAME_HEIGHT || MyPanel.isOverLap(this, hero)) {
                            futureSteps = 0;
                        }
                    }
                    case 2 -> {
                        moveRight();
                        if (x + Tank.LENGTH / 2 >= TankGame03.FRAME_WIDTH || MyPanel.isOverLap(this, hero)) {
                            futureSteps = 0;
                        }
                    }
                    case 3 -> {
                        moveLeft();
                        if (x - Tank.LENGTH / 2 <= 0 || MyPanel.isOverLap(this, hero)) {
                            futureSteps = 0;
                        }
                    }
                    default -> {
                    }
                }
                futureSteps -= speed;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
