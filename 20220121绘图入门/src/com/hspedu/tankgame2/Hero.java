package com.hspedu.tankgame2;

/**
 * @ClassName Hero
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/20 22:12
 * @Version 1.0
 **/
public class Hero extends Tank {
    public Hero(int x, int y) {
        super(x, y);
    }
    public Hero(int x, int y, int direct) {
        super(x, y, direct);
    }
    public Hero(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }
    {
        setType(0);
    }
}
