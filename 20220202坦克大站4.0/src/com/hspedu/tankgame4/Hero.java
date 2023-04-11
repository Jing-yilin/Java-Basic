package com.hspedu.tankgame4;

import java.util.Vector;

/**
 * @ClassName Hero
 * @Description 我的坦克HERO
 * @Author Jing Yilin
 * @Date 2022/1/20 22:12
 * @Version 1.0
 **/
public class Hero extends Tank {
    {
        setType(0);
        shots = new Vector<>();
    }
    public Hero(int x, int y) {
        super(x, y);
    }

    public Hero(int x, int y, int direct) {
        super(x, y, direct);
    }

    public Hero(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }

    //射击
    public void shotEnemyTank() {
        if (isLive){
            shot = new Shot(this);
            shot.setType(this.getType());
            shots.add(shot);

            //清理一遍shots里的子弹，如果!isLive就删除
            for (int i = 0; i < shots.size(); i++) {
                if (!shots.get(i).isLive){
                    shots.remove(i);
                }
            }

//        System.out.println("目前存活子弹数目 = " + shots.size());

            Thread thread = new Thread(shot);
            thread.start();
        }
    }
}
