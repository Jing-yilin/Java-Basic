package com.hspedu.dao_.domain;

/**
 * @ClassName Goods
 * @Description 与数据库中的goods表字段一一对应的一个类
 * @Author zephyr
 * @Date 2022/5/26 08:17
 * @Version 1.0
 */
public class Goods {
    private Integer id;
    private String goods_name;
    private Integer price;

    //空构造器
    public Goods(){}

    public Goods(Integer id, String goods_name, Integer price) {
        this.id = id;
        this.goods_name = goods_name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goods_name='" + goods_name + '\'' +
                ", price=" + price +
                '}';
    }
}
