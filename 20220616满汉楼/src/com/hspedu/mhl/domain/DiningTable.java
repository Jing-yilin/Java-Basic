package com.hspedu.mhl.domain;

/**
 * @ClassName DiningTable
 * @Description diningTable的javabean，映射diningTable表
 * @Author zephyr
 * @Date 2022/6/16 23:07
 * @Version 1.0
 */
public class DiningTable {
    private Integer id;
    private String state;
    private String orderName;
    private String orderTel;

    public DiningTable(){}

    public DiningTable(Integer id, String state, String orderName, String orderTel) {
        this.id = id;
        this.state = state;
        this.orderName = orderName;
        this.orderTel = orderTel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }

    @Override
    public String toString() {
        return "DiningTable{" +
                "id=" + id +
                ", 状态='" + state + '\'' +
                ", 订餐人='" + orderName + '\'' +
                ", 订餐人电话='" + orderTel + '\'' +
                '}';
    }
}
