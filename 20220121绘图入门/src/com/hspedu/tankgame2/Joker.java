package com.hspedu.tankgame2;

/**
 * @ClassName Joker
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/21 13:37
 * @Version 1.0
 **/
public class Joker extends Tank{

    public Joker(int x, int y) {
        super(x, y);
    }

    public Joker(int x, int y, int direct) {
        super(x, y, direct);
    }

    public Joker(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }
    {
        setType(1);
    }
}
