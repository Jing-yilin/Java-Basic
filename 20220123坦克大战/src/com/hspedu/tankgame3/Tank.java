package com.hspedu.tankgame3;

import java.util.Vector;

/**
 * @ClassName Tank
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/20 22:11
 * @Version 1.0
 **/
public class Tank {
    public static final int WIDTH = 30;
    public static final int LENGTH = 40;
    protected int x;//横坐标
    protected int y;//纵坐标
    protected int direct = 0;//默认方向向上
    protected int speed = 3;//默认速度为3
    int type = 0;//默认种类为1,亮蓝色
    public boolean isLive = true;

    public Shot shot = null;
    public Vector<Shot> shots = null;


    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tank(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public Tank(int x, int y, int direct, int speed) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = speed;
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveRight() {
        x += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
