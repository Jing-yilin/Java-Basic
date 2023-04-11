package com.hspedu.tankgame4;

/**
 * @ClassName Bullet
 * @Description 子弹
 * @Author Jing Yilin
 * @Date 2022/1/23 15:54
 * @Version 1.0
 **/
public class Shot implements Runnable {
    public static final int WIDTH = 1;
    public static final int LENGTH = 1;
    private int x = -1;
    private int y = -1;
    private int speed = 2;
    private int direct = 0;
    private int type = 0;
    boolean isLive = true; // 子弹是否还存活
    private Tank tank = null;

    public Shot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Shot(Tank tank) {
        this.tank = tank;
        this.direct = tank.getDirect();
        switch (direct) {
            case 0://坦克向上
                x = tank.getX();
                y = tank.getY() - Tank.LENGTH * 35 / 100;
                break;
            case 1://坦克向下
                x = tank.getX();
                y = tank.getY() + Tank.LENGTH * 35 / 100;
                break;
            case 2://坦克向右
                y = tank.getY();
                x = tank.getX() + Tank.LENGTH * 35 / 100;
                break;
            case 3://坦克向左
                y = tank.getY();
                x = tank.getX() - Tank.LENGTH * 35 / 100;
                break;
            default:
                break;
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    @Override
    public void run() {
        while (isLive) {
            //让子弹休眠50ms
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    y += speed;
                    break;
                case 2:
                    x += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            //测试
//            System.out.println("Bullet x=" + x+"; y = " + y);
            //碰到边界就
            if (x < 0 || x > TankGame04.FRAME_WIDTH || y < 0 || y > TankGame04.FRAME_HEIGHT) {
                isLive = false;
            }
        }
    }
}