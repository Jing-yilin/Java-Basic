package com.hspedu.houserent;

import com.hspedu.houserent.view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {
        //创建HouseView对象，是程序的入口
        new HouseView().mainMenu();
        System.out.println("==你退出了房屋出租系统==");
    }
}
