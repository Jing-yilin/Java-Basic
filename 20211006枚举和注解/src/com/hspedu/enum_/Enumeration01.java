package com.hspedu.enum_;

/**
 * @ClassName Enumeration01
 * @Description 对于有限个举例，使用类不好
 * @Author Jing Yilin
 * @Date 2021/10/5 12:56
 * @Version 1.0
 **/
public class Enumeration01 {
    public static void main(String[] args) {
        Season spring = new Season("spring", "warm");
        Season winter = new Season("winter", "cold");
        Season summer = new Season("summer", "hot");
        Season autumn = new Season("autumn", "cool");
    }
}

class Season{
    private String name;
    private String desc;//描述

    public Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
