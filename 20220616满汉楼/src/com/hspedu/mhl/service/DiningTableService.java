package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.DiningTableDAO;
import com.hspedu.mhl.domain.DiningTable;

import java.util.List;

/**
 * @ClassName DiningTableService
 * @Description 用于管理diningTable服务
 * @Author zephyr
 * @Date 2022/6/16 23:10
 * @Version 1.0
 */
public class DiningTableService {
    private DiningTableDAO diningTableDAO = new DiningTableDAO();
//    private List<DiningTable> diningTablesList = null;

    /**
     * 返回数据库中所有的diningTable
     */
    public List<DiningTable> getAllDiningTableInfo(){
        List<DiningTable> diningTables = diningTableDAO.queryMulti("select id, state from diningTable", DiningTable.class);
        return diningTables;
    }

    /**
     * 根据id查询对应的餐桌，如果返回空某促成对应的餐桌不不存在
     */
    public DiningTable getDiningTableById(int id){
        DiningTable diningTable = diningTableDAO.querySingle("select * from diningTable where id = ?", DiningTable.class, id);
        return diningTable;
    }

    /**
     * 如果餐桌可以预定，则对其进行更新（包括预订人的名字和电话）
     */
    public boolean orderDiningTable(int id, String orderName, String orderTel){
        int update = diningTableDAO.update("update diningTable set state='已被预订', orderName=?, orderTel=? where id = ?", orderName, orderTel, id);
        return update > 0;
    }

    /**
     * 一个更新餐桌状态的方法
     */
    public boolean updateDiningTableState(int id, String state) {
        int update = diningTableDAO.update("update diningTable set state = ? where id = ?", state, id);
        return update > 0;
    }

    /**
     * 检验餐桌是否存在
     */
    public boolean exist(int id){
        return diningTableDAO.querySingle("select * from diningTable where id = ?", DiningTable.class, id) != null;
    }

    /**
     * 把某一餐桌的状态设置为初始态
     * 返回是否设置成功
     */
    public boolean setInit(int id){
        int update = diningTableDAO.update("update diningTable set state = '空', orderName = '', orderTel = '' where id = ?", id);
        return update > 0;
    }
}
