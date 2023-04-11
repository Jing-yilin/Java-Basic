package com.hspedu.tankgame4;

import java.util.Random;
import java.util.Vector;

/**
 * @ClassName Joker
 * @Description Joker是一个线程，会自动移动
 * @Author Jing Yilin
 * @Date 2022/1/21 13:37
 * @Version 1.0
 **/
public class Joker extends Tank implements Runnable {
    public boolean heroInWay = false;
    public int futureSteps = 0;
    public static Vector<Joker> jokers = null;
    public static Hero hero = null;

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public  static void setJokers(Vector<Joker> jokers) {
        Joker.jokers = jokers;
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
//            if (heroInWay)
//                System.out.println("Hero被敌方坦克发现...");
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
//            System.out.println("Joker子弹发射...");
        }
    }

    public void aVoidJokerCrush(){
        if (this.jokers != null){
            for (int i = 0; i < jokers.size(); i++) {
                Joker joker2 = jokers.get(i);
                if (joker2 == this){
                    continue;
                } else {
                    aVoidCrush(this, joker2);
                }
            }
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
//                futureSteps = 0;
                //生成任意方向
                direct = random.nextInt(4);
//                direct = 0;
            }
            while (futureSteps > 0) {
                switch (direct) {
                    case 0 -> {
                        moveUp();
                        //防止joker坦克之间相撞
                        aVoidJokerCrush();
                        //防止joker和hero相撞
                        aVoidCrush(this,hero);
                        //撞墙则步数为0->重置方向
                        if (y - Tank.LENGTH / 2 <= 0) {
                            futureSteps = 0;
                        }
                    }
                    case 1 -> {
                        moveDown();
                        //防止joker坦克之间相撞
                        aVoidJokerCrush();
                        //防止joker和hero相撞
                        aVoidCrush(this,hero);
                        if (y + Tank.LENGTH / 2 >= TankGame04.FRAME_HEIGHT) {
                            futureSteps = 0;
                        }
                    }
                    case 2 -> {
                        moveRight();
                        //防止joker坦克之间相撞
                        aVoidJokerCrush();
                        //防止joker和hero相撞
                        aVoidCrush(this,hero);
                        if (x + Tank.LENGTH / 2 >= TankGame04.FRAME_WIDTH) {
                            futureSteps = 0;
                        }
                    }
                    case 3 -> {
                        moveLeft();
                        //防止joker坦克之间相撞
                        aVoidJokerCrush();
                        //防止joker和hero相撞
                        aVoidCrush(this,hero);
                        if (x - Tank.LENGTH / 2 <= 0) {
                            futureSteps = 0;
                        }
                    }
                    default -> {
                    }
                }
                futureSteps -= speed;



                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }



        }
    }
}
