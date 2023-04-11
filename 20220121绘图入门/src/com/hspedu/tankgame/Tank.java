package com.hspedu.tankgame;

/**
 * @ClassName Tank
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/20 22:11
 * @Version 1.0
 **/
public class Tank {
    private int x;//横坐标
    private int y;//纵坐标

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
