package com.hspedu.jdbc.myjdbc;

/**
 * @ClassName MySqlJdbcImplement
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/3/8 9:29
 * @Version 1.0
 **/
public class MySqlJdbcImplement implements JdbcInterface{
    @Override
    public Object getConnection() {
        System.out.println("得到mysql的连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("mysql增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭mysql");

    }
}
