package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.MenuDAO;
import com.hspedu.mhl.domain.DiningTable;
import com.hspedu.mhl.domain.Menu;

import java.util.List;

/**
 * @ClassName MenuService
 * @Description TODO
 * @Author zephyr
 * @Date 2022/6/17 11:09
 * @Version 1.0
 */
public class MenuService {

    private MenuDAO menuDAO = new MenuDAO();

    /**
     * 返回所有的菜品
     */
    public List<Menu> getMenuList() {
        return menuDAO.queryMulti("select * from menu", Menu.class);
    }

    /**
     * 根据id返回一个Menu对象
     */
    public Menu getMenuById(int id){
        return menuDAO.querySingle("select * from menu where id = ?", Menu.class, id);
    }

    /**
     * 检验菜品是否存在
     */
    public boolean exist(int id){
        return menuDAO.querySingle("select * from menu where id = ?", Menu.class, id) != null;
    }
}
