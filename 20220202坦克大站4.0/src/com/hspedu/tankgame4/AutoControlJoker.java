package com.hspedu.tankgame4;

import java.util.Vector;

/**
 * @ClassName AutoControlJoker
 * @Description 自动控制敌方坦克的射击
 * @Author Jing Yilin
 * @Date 2022/1/26 15:56
 * @Version 1.0
 **/
public class AutoControlJoker extends Thread{
    Vector<Joker> jokers = null;
    Hero hero = null;

    public AutoControlJoker(Vector<Joker> jokers, Hero hero) {
        this.jokers = jokers;
        this.hero = hero;
    }

    @Override
    public void run() {
        System.out.println("AutoControlJoker线程启动...");
        while (true) {
            if (jokers == null || hero == null)
                break;
            try {
                Thread.sleep(1300);//每隔一秒判断一次是否发现hero
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //判断敌方是否发现hero
            for (Joker joker : jokers) {
                joker.checkHero(hero);
            }
            //发射子弹
            for (Joker joker : jokers) {
                joker.shotHero();
            }
        }
    }
}
