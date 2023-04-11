package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.BillDAO;
import com.hspedu.mhl.dao.MultiTableBeanDAO;
import com.hspedu.mhl.domain.Bill;
import com.hspedu.mhl.domain.MultiTableBean;

import java.util.List;
import java.util.UUID;

/**
 * @ClassName BillService
 * @Description 处理和账单相关的业务
 * @Author zephyr
 * @Date 2022/6/17 18:19
 * @Version 1.0
 */
public class BillService {
    private BillDAO billDAO = new BillDAO();
    // 定义一个Menu对象
    private MenuService menuService = new MenuService();
    private DiningTableService diningTableService = new DiningTableService();
    private MultiTableBeanDAO multiTableBeanDAO = new MultiTableBeanDAO();

    /**
     * 点餐生成账单，同时更新对应餐桌的状态
     */
    public boolean orderMenu(int menuId, int nums, int diningTableId){
        //生成账单号UUID
        String billId = UUID.randomUUID().toString();
        //将账单写入bill表
        int update = billDAO.update("insert into bill values(null, ?, ?, ?, ?, ?,now(), '未结账')",
                billId, menuId, nums, menuService.getMenuById(menuId).getPrice() * nums, diningTableId);
        if (update <= 0){
            return false;
        }
        //更新餐桌状态
        return diningTableService.updateDiningTableState(diningTableId, "就餐中");
    }

    /**
     * 返回所有的账单
     */
    public List<Bill> getBillList(){
        return billDAO.queryMulti("select * from bill", Bill.class);
    }

    /**
     * 返回所有的账单,使用了联合查询获得菜品名
     */
    public List<MultiTableBean> getBillList2(){
        return multiTableBeanDAO.queryMulti("select bill.*, name, price from bill, menu where bill.menuId = menu.id", MultiTableBean.class);
    }

    /**
     * 查看某一餐桌是否有未结账账单
     */
    public boolean hasPayBill(int diningTableId){
        Bill bill = billDAO.querySingle("select * from bill where diningTableId = ? and state = '未结账' limit 0,1", Bill.class, diningTableId);
        return bill != null;
    }

    /**
     * 完成结账[如果餐桌存在，并且有未结账的账单]
     */
    public boolean payBill(int diningTableId, String payMode){
        //如果这里使用，需要使用ThreadLocal来解决

        //1. 修改bill表
        int update = billDAO.update("update bill set state = ? where diningTableId = ? and state = '未结账'",payMode,diningTableId);

        if (update <= 0){
            return false;
        }
        //2. 修改diningTable表
        return diningTableService.setInit(diningTableId);
    }
}
