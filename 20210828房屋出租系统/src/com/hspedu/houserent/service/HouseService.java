package com.hspedu.houserent.service;

import com.hspedu.houserent.domain.House;
import com.hspedu.houserent.utils.Utility;

public class HouseService {

    private House[] houses; //保存House数据
    private int houseNumber = 3;    //记录当前房屋数量
    private int idCounter = 3;  //记录当前id的值

    public HouseService(int size) {

        houses = new House[size];   //当创建HouseService对象，指定数组大小

        houses[0] = new House(1, "jack", "112", "海淀区", 2314, "未出租");
        houses[1] = new House(2, "Yoshiki", "1821", "Tokyo", 1231, "已出租");
        houses[2] = new House(3, "Hide", "9712", "三浦公园", 9746, "已出租");
    }

    public House[] list() {
        return houses;
    }

    //add方法，添加新对象，返回boolean
    public boolean add(House newHouse) {
        //判断是否还是以继续添加
        if (houseNumber == houses.length) {
//            System.out.println("数组已经满了，不能再添加了！！！");
            return false;
        }

        //在数组尾部加入新的房屋
        houses[houseNumber++] = newHouse;
        newHouse.setId(++idCounter);
        return true;
    }

    //删除房屋，返回boolean
    public boolean del(int delId) {

        int index = -1;
        for (int i = 0; i < houseNumber; i++) {
            if (delId == houses[i].getId()) {
                //如果找到对应的房子，就用index记录Id
                index = i;
            }
        }

        if (index == -1) {
            System.out.println("您输入的编号不存在！！！");
            return false;
        }

        //把被删除房子后的所有的房子都往前移动一位
        for (int i = index; i < houseNumber - 1; i++) {
            houses[i] = houses[index + 1];
        }
        //把之前已有房子的最后一个置空
        houses[--houseNumber] = null;;
        return true;

    }

    public House findById (int findId) {
        for (int i = 0; i < houseNumber; i++) {
            if (findId == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
    }

}
