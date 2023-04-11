package com.hspedu.tankgame4;

import java.util.Vector;

/**
 * @ClassName Tank
 * @Description Tank类
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
        if (y - Tank.LENGTH / 2 < 0) {
//            System.out.println("不要超出上边界！");
            y = Tank.LENGTH / 2;
        }
    }

    public void moveDown() {
        y += speed;
        if (y + Tank.LENGTH / 2 > TankGame04.FRAME_HEIGHT) {
//            System.out.println("不要超出下边界！");
            y = TankGame04.FRAME_HEIGHT - Tank.LENGTH / 2;
        }
    }

    public void moveRight() {
        x += speed;
        if (x + Tank.LENGTH / 2 > TankGame04.FRAME_WIDTH) {
//            System.out.println("不要超出右边界！");
            x = TankGame04.FRAME_WIDTH - Tank.LENGTH / 2;
        }
    }

    public void moveLeft() {
        x -= speed;
        if (x - Tank.LENGTH / 2 < 0) {
//            System.out.println("不要超出左边界！");
            x = Tank.LENGTH / 2;
        }
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

    /**
     * 防止两个坦克重叠
     */
    public static void aVoidCrush(Tank tank1, Tank tank2) {
        if (tank1 != null && tank2 != null) {
            //tank1作为动的坦克，tank2作为不动的坦克
            int tank1Direct = tank1.getDirect();
            int tank2Direct = tank2.getDirect();
            //
            boolean isHorizontal = true;
            if (tank2Direct == 0 || tank2Direct == 1)
                isHorizontal = false;
            switch (tank1Direct) {
                case 0:
                    if (isHorizontal) {
                        if ((tank1.x + Tank.WIDTH / 2 > tank2.x - Tank.LENGTH / 2) && (tank1.x - Tank.WIDTH / 2 < tank2.x + Tank.LENGTH / 2)) {
                            if (tank1.y - tank2.y <= (Tank.LENGTH + Tank.WIDTH) / 2 && tank1.y - tank2.y > 0) {
                                tank1.y = tank2.y + (Tank.LENGTH + Tank.WIDTH) / 2;
                            }
                        }
                    } else {
                        if ((tank1.x + Tank.WIDTH / 2 > tank2.x - Tank.WIDTH / 2) && (tank1.x - Tank.WIDTH / 2 < tank2.x + Tank.WIDTH / 2)) {
                            if (tank1.y - tank2.y <= Tank.LENGTH && tank1.y - tank2.y > 0) {
                                tank1.y = tank2.y + Tank.LENGTH;
                            }
                        }
                    }
                    break;
                case 1:
                    if (isHorizontal) {
                        if ((tank1.x + Tank.WIDTH / 2 > tank2.x - Tank.LENGTH / 2) && (tank1.x - Tank.WIDTH / 2 < tank2.x + Tank.LENGTH / 2)) {
                            if (tank2.y - tank1.y <= (Tank.LENGTH + Tank.WIDTH) / 2 && tank2.y - tank1.y > 0) {
                                tank1.y = tank2.y - (Tank.LENGTH + Tank.WIDTH) / 2;
                            }
                        }
                    } else {
                        if ((tank1.x + Tank.WIDTH / 2 > tank2.x - Tank.WIDTH / 2) && (tank1.x - Tank.WIDTH / 2 < tank2.x + Tank.WIDTH / 2)) {
                            if (tank2.y - tank1.y <= Tank.LENGTH && tank2.y - tank1.y > 0) {
                                tank1.y = tank2.y - Tank.LENGTH;
                            }
                        }
                    }
                    break;
                case 2:
                    if (isHorizontal) {
                        if ((tank1.y - Tank.WIDTH / 2 < tank2.y + Tank.WIDTH / 2) && (tank1.y + Tank.WIDTH / 2 > tank2.y - Tank.WIDTH / 2)) {
                            if (tank2.x - tank1.x <= Tank.LENGTH && tank2.x - tank1.x > 0) {
                                tank1.x = tank2.x - Tank.LENGTH;
                            }
                        }
                    } else {
                        if ((tank1.y - Tank.WIDTH / 2 < tank2.y + Tank.LENGTH / 2) && (tank1.y + Tank.WIDTH / 2 > tank2.y - Tank.LENGTH / 2)) {
                            if (tank2.x - tank1.x <= (Tank.LENGTH + Tank.WIDTH) / 2 && tank2.x - tank1.x > 0) {
                                tank1.x = tank2.x - (Tank.LENGTH + Tank.WIDTH) / 2;
                            }
                        }
                    }
                    break;
                case 3:
                    if (isHorizontal) {
                        if ((tank1.y - Tank.WIDTH / 2 < tank2.y + Tank.WIDTH / 2) && (tank1.y + Tank.WIDTH / 2 > tank2.y - Tank.WIDTH / 2)) {
                            if (tank1.x - tank2.x <= Tank.LENGTH && tank1.x - tank2.x > 0) {
                                tank1.x = tank2.x + Tank.LENGTH;
                            }
                        }
                    } else {
                        if ((tank1.y - Tank.WIDTH / 2 < tank2.y + Tank.LENGTH / 2) && (tank1.y + Tank.WIDTH / 2 > tank2.y - Tank.LENGTH / 2)) {
                            if (tank1.x - tank2.x <= (Tank.LENGTH + Tank.WIDTH) / 2 && tank1.x - tank2.x > 0) {
                                tank1.x = tank2.x + (Tank.LENGTH + Tank.WIDTH) / 2;
                            }
                        }
                    }
                    break;
                default:
                    break;
            }


        }
    }
}
