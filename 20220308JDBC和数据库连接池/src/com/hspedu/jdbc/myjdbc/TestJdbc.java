package com.hspedu.jdbc.myjdbc;

/**
 * @ClassName TestJdbc
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/3/8 9:43
 * @Version 1.0
 **/
public class TestJdbc {
    public static void main(String[] args) {
        JdbcInterface jdbcInterface = new MySqlJdbcImplement();
        jdbcInterface.getConnection();
        jdbcInterface.crud();
        jdbcInterface.close();
    }
}
