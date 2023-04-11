package com.hspedu.mhl.view;

import com.hspedu.mhl.dao.MultiTableBeanDAO;
import com.hspedu.mhl.domain.*;
import com.hspedu.mhl.service.BillService;
import com.hspedu.mhl.service.DiningTableService;
import com.hspedu.mhl.service.EmployeeService;
import com.hspedu.mhl.service.MenuService;
import com.hspedu.mhl.utils.Utility;

import java.util.List;

/**
 * @ClassName MHLView
 * @Description 满汉楼的显示主界面
 * @Author zephyr
 * @Date 2022/6/16 21:36
 * @Version 1.0
 */
public class MHLView {

    public static void main(String[] args) {
        new MHLView().mainView();
    }

    private boolean loop = true; // 控制是否退出菜单
    private final EmployeeService employeeService = new EmployeeService(); // employeeService对象
    private final DiningTableService diningTableService = new DiningTableService();
    private final MenuService menuService = new MenuService();
    private final BillService billService = new BillService();

    /**
     * 显示所有diningTable的信息
     */
    public void showAllDiningTableInfo(){
        List<DiningTable> diningTablesList = diningTableService.getAllDiningTableInfo();
        System.out.println("编号\t状态");
        if (diningTablesList != null){
            for (DiningTable diningTable: diningTablesList){
                System.out.println(diningTable.getId() + "\t" + diningTable.getState());
            }
        }
        System.out.println("===========显示完毕===========");
    }


    /**
     * 完成预定
     */
    public void orderDiningTable(){
        System.out.print("请选择要预定的餐桌编号(-1退出): ");
        int id = Utility.readInt();
        if (id == -1){
            System.out.println("===========取消预订===========");
            return;
        }
        DiningTable diningTable = diningTableService.getDiningTableById(id);
        if (diningTable == null){
            System.out.println("不存在该餐桌!");
            return;
        }
        if (!diningTable.getState().equals("空")){
            System.out.println("该餐桌已被预定或就餐中!");
            return;
        }
        System.out.print("请确认是否预定(Y/N): ");
        char key = Utility.readConfirmSelection();
        if (key == 'Y'){
            System.out.print("预订人姓名: ");
            String orderName = Utility.readString(50);
            System.out.print("预订人电话: ");
            String orderTel = Utility.readString(20);
            if (diningTableService.orderDiningTable(id, orderName, orderTel)){
                System.out.println("===========预定成功===========");
            } else {
                System.out.println("===========预定失败===========");
            }
        } else {
            System.out.println("===========取消预订===========");
        }
    }

    /**
     * 显示所有菜品
     */
    public void showMenuList(){
        List<Menu> menuList = menuService.getMenuList();
        System.out.println("编号\t\t菜品名\t\t类别\t\t价格");
        for (Menu menu: menuList){
            System.out.println(menu.getId() + "\t\t" + menu.getName() + "\t\t" +
                    menu.getType() + "\t\t" + menu.getPrice());
        }
    }

    /**
     * 点菜
     */
    public void orderMenu(){
        System.out.print("请选择点餐的桌号(-1退出): ");
        int diningTableId = Utility.readPositiveInt();
        if (diningTableId == -1){
            System.out.println("==========退出点餐==========");
            return;
        }
        if (!diningTableService.exist(diningTableId)){
            System.out.println("==========餐桌不存在,退出点餐==========");
            return;
        }
        System.out.print("请选择菜品的编号(-1退出): ");
        int menuId = Utility.readPositiveInt();
        if (menuId == -1){
            System.out.println("==========退出点餐==========");
            return;
        }
        if (!menuService.exist(menuId)){
            System.out.println("==========菜品不存在,退出点餐==========");
            return;
        }
        System.out.print("请输入菜品的数量(-1退出): ");
        int nums = Utility.readPositiveInt();
        if (nums == -1){
            System.out.println("==========退出点餐==========");
            return;
        }
        System.out.print("确认是否要点这个菜(Y/N) ");
        char key = Utility.readConfirmSelection();
        if (key == 'N'){
            System.out.println("==========退出点餐==========");
            return;
        }
        if (billService.orderMenu(menuId, nums, diningTableId)){
            System.out.println("==========点餐成功==========");
        } else {
            System.out.println("==========点餐失败==========");
        }
    }

    /**
     * 展示所有的账单
     */
    public void showAllBill(){
//        System.out.println("\t编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t状态");
//        List<Bill> billList = billService.getBillList();
//        for (Bill bill:billList){
//            System.out.println("\t" + bill.getId()+"\t\t"+bill.getMenuId()+"\t\t\t" + bill.getNums()+
//                    "\t\t\t"+bill.getMoney() + "\t" + bill.getDiningTableId() + "\t\t" + bill.getBillDate() +"\t\t" + bill.getState());
//        }
        System.out.println("\t编号\t\t菜品名\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t状态");
        List<MultiTableBean> multiTableBeanList = billService.getBillList2();
        for (MultiTableBean bill:multiTableBeanList){
            System.out.println("\t" + bill.getId()+"\t\t"+bill.getName()+"\t\t" + bill.getNums()+
                    "\t\t\t"+bill.getMoney() + "\t" + bill.getDiningTableId() + "\t\t" + bill.getBillDate() +"\t\t" + bill.getState());
        }
    }

    /**
     * 完成结账
     */
    public void payBill(){
        System.out.print("请选择要结账的餐桌编号(-1退出): ");
        int diningTableId = Utility.readPositiveInt();
        if (diningTableId == -1){
            System.out.println("==========退出结账==========");
            return;
        }
        if (!diningTableService.exist(diningTableId)){
            System.out.println("==========该餐桌不存在==========");
            return;
        }
        if (!billService.hasPayBill(diningTableId)){
            System.out.println("==========该餐桌不需要结账==========");
            return;
        }
        System.out.print("结账方式(现金/支付宝/微信): ");
        String payMode = Utility.readString(3);
        if (billService.payBill(diningTableId, payMode)){
            System.out.println("==========结账成功==========");
            return;
        } else {
            System.out.println("==========结账失败==========");
        }
    }

    /**
     * 显示主菜单
     */
    public void mainView(){
        while (loop){
            System.out.println("===========满汉楼===========");
            System.out.println("\t\t 1 登录满汉楼");
            System.out.println("\t\t 2 退出满汉楼");

            System.out.print("请输入你的选择： ");
            // 接收用户的输入
            String key = Utility.readString(1);
            switch(key){
                case "1":
                    System.out.print("请输入员工号: ");
                    String empId = Utility.readString(50);
                    System.out.print("请输入密 码: ");
                    String pwd = Utility.readString(50);
                    Employee employee = employeeService.getEmployeeByIdAndPwd(empId, pwd);
                    //到数据库判断验证
                    if (employee != null){ //说明存在该用户
                        System.out.println("==========登陆成功("+employee.getName()+")==========");
                        //显示二级菜单
                        System.out.println();
                        while (loop){
                            System.out.println("=========满汉楼二级菜单=========");
                            System.out.println("\t\t 1 显示餐桌状态");
                            System.out.println("\t\t 2 预定餐桌");
                            System.out.println("\t\t 3 显示所有菜品");
                            System.out.println("\t\t 4 点餐服务");
                            System.out.println("\t\t 5 查看账单");
                            System.out.println("\t\t 6 结账");
                            System.out.println("\t\t 9 退出");
                            System.out.print("请输入你的选择： ");

                            key = Utility.readString(1);
                            switch (key){
                                case "1":
                                    System.out.println("==========显示餐桌状态==========");
                                    this.showAllDiningTableInfo();
                                    break;
                                case "2":
                                    System.out.println("==========预定餐桌==========");
                                    this.orderDiningTable();
                                    break;
                                case "3":
                                    System.out.println("==========显示所有菜品==========");
                                    this.showMenuList();
                                    break;
                                case "4":
                                    System.out.println("==========点餐服务==========");
                                    this.orderMenu();
                                    break;
                                case "5":
                                    System.out.println("==========查看账单==========");
                                    this.showAllBill();
                                    break;
                                case "6":
                                    System.out.println("==========结账==========");
                                    this.payBill();
                                    break;
                                case "9":
                                    loop = false; //退出
                                    System.out.println("==========成功退出==========");
                                    break;
                                default:
                                    System.out.println("输入有误，请重新输入!");
                                    break;
                            }

                        }
                    } else {
                        System.out.println("==========登陆失败==========");
                    }
                    break;
                case "2":
                    loop = false;
                    System.out.println("成功退出!");
                    break;
                default:
                    System.out.println("输入有误，请重新输入!");
                    break;
            }
        }
    }

}
