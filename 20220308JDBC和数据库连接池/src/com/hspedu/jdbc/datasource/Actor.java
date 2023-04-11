package com.hspedu.jdbc.datasource;

import java.util.Date;

/**
 * @ClassName Actor
 * @Description Actor对象用来记录ResultSet的每一条结果
 * @Author Zephyr
 * @Date 2022/5/9 8:45
 * @Version 1.0
 */
public class Actor {
    private Integer id;
    private String name;
    private String sex;
    private Date borndate;
    private String phone;
    public Actor(){ // 需要给一个无参构造器，因为底层可能用到反射

    };

    public Actor(Integer id, String name, String sex, Date borndate, String phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.borndate = borndate;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", borndate=" + borndate +
                ", phone='" + phone + '\'' +
                '}' + '\n';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBorndate(Date borndate) {
        this.borndate = borndate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Date getBorndate() {
        return borndate;
    }

    public String getPhone() {
        return phone;
    }
}
