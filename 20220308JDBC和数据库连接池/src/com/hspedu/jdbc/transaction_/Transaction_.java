package com.hspedu.jdbc.transaction_;

import com.hspedu.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName Transaction_
 * @Description 演示如何使用事务
 * @Author Jing Yilin
 * @Date 2022/3/11 9:05
 * @Version 1.0
 **/
public class Transaction_ {

    @Test
    public void TestTransaction(){
        //1. 得到连接
        Connection connection = null;
        //2. 组织sql语句
        String sql1 = "UPDATE account SET balance = balance - 100 WHERE id = 1";
        String sql2 = "UPDATE account SET balance = balance + 100 WHERE id = 2";
        PreparedStatement preparedStatement = null;
        //3. 创建 preparedStatement
        try {
            connection = JDBCUtils.getConnection();

            //将connection设置为不自动提交
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

            //提交事务
            connection.commit();
            System.out.println("操作成功！");
        } catch (Exception e) {
            System.out.println("发生异常，回滚事务");
            //这里可以执行回滚操作
            //默认回滚到事务开始的状态
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
