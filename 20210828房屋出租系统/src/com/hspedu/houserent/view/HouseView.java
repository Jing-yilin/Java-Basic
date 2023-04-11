package com.hspedu.houserent.view;

import com.hspedu.houserent.domain.House;
import com.hspedu.houserent.service.HouseService;
import com.hspedu.houserent.utils.Utility;

/**
 * 1.显示界面
 * 2.接受用户输入
 * 3.调用HouseService完成各种操作
 */

public class HouseView {

    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(10);   //HouseService里houses数组地大小为10


    //显示房屋列表
    public void listHouses() {
        System.out.println("==============房屋列表===========");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态（未出租/已出租）");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {

            if (houses[i] == null) {//如果为null，就不再显示了
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("==========房屋列表显示完毕=========");
    }

    //添加房屋
    public void addHouse() {
        System.out.println("==============添加房屋===========");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(8);
        //创建一个新的House对象，并加入到数组里，id由系统自行分配
        House house = new House(0, name, phone, address, rent, state);
        if(houseService.add(house)) {
            System.out.println("=============添加房屋成功============");
        } else {
            System.out.println("=============添加房屋失败============");
        }

    }

    //删除房屋
    public void delHouse() {
        System.out.println("=================删除房屋==================");
        System.out.println("===========请输入待删除房屋的编号(-1退出)============");
        int delId = Utility.readInt();
        if(delId == -1) {
            System.out.println("==============放弃删除房屋信息=============");
            return;
        }
//        System.out.println("请确认是否删除(Y/N),请小心选择");
        char choice = Utility.readConfirmSelection();   //  该方法有循环判断逻辑
        if(choice == 'Y') {
            if(houseService.del(delId)) {
                System.out.println("============删除成功===========");
            }
        } else {
            System.out.println("您放弃了删除！");
        }

    }

    //推出房屋出租系统
    public void quitHouse() {
//        System.out.println("请确认是否退出(Y/N): ");
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            loop = false;
        } else {
            loop = true;
        }
    }

    public void findHouse() {
        System.out.println("==============查找房屋信息==============");
        System.out.println("请输入你要查找的Id:");
        int findId = Utility.readInt();
        //调用方法
        House house = houseService.findById(findId);
        if (house != null) {
            System.out.println(house);
        } else {
            System.out.println("==========查找房屋信息id不存在===========");
        }
    }

    public void updateHouse() {
        System.out.println("============修改房屋信息===========");
        System.out.println("请选择待修改房屋编号(-1表示退出)");
        int updateId = Utility.readInt();
        if (updateId == -1) {
            System.out.println("============你放弃了修改==========");
            return;
        }
        House house = houseService.findById(updateId);
        if (house == null) {
            System.out.println("===============此房屋不存在=============");
            return;
        }

        System.out.print("姓名("+house.getName()+"): ");
        String name = Utility.readString(8, "");//如果用户回车则跳过
        if (!"".equals(name)) {
            house.setName(name);
        }

        System.out.print("电话("+house.getPhone()+"): ");
        String phone = Utility.readString(12);
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }



    }

    //显示主菜单
    public void mainMenu() {
        do {
            System.out.println("==============房屋出租系统============");
            System.out.println("\t\t1 新 增 房 源");
            System.out.println("\t\t2 查 找 房 屋");
            System.out.println("\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t5 房 屋 列 表");
            System.out.println("\t\t6 退      出");
            System.out.print("请输入你的选择(1-6): ");

        key = Utility.readChar();
        switch (key) {
            case '1' :
                addHouse();
                break;
            case '2' :
                findHouse();
                break;
            case '3' :
                delHouse();
                break;
            case '4' :
                updateHouse();
                break;
            case '5' :
                listHouses();
                break;
            case '6' :
                quitHouse();
                break;
            }
        } while (loop);

    }
}
