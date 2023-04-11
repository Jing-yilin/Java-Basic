package com.hspedu.jdbc.utils;

import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * @ClassName JDBCUtilsTest
 * @Description 该类演示如何使用JDBCUtils工具类
 * @Author Jing Yilin
 * @Date 2022/3/9 11:28
 * @Version 1.0
 **/
public class JDBCUtilsTest {

    /*
    测试查询操作
     */
    @Test
    public void testSelect(){
        //定义连接
        Connection connection = null;
        //定义preparedStatement
        PreparedStatement preparedStatement = null;
        //定义resultSet
        ResultSet  resultSet = null;
        //组织sql语句
        String sql = "SELECT * FROM actor";
        //接下来是try，里面的内容可能会报错
        try {
            //获取连接
            connection = JDBCUtils.getConnection();
            //获取预处理语句
            preparedStatement = connection.prepareStatement(sql);
            //执行预处理语句
            preparedStatement.executeQuery();
            //获得查询结果
            resultSet = preparedStatement.getResultSet();
            //输出查询结果
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String sex = resultSet.getString(3);
                Date bornDate = resultSet.getDate(4);
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + bornDate);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭查询
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }

    }

    /*
    测试DML操作
     */
    @Test
    public void testDML() {
        //1. 得到连接
        Connection connection = null;
        //2. 组织sql语句
        String sql = "UPDATE actor SET name = ? WHERE id = ?";
        PreparedStatement preparedStatement = null;
        //3. 创建 preparedStatement
        try {
            ///得到连接
            connection = JDBCUtils.getConnection();
            //得到预处理语句
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setString(1, "景风眠");
            preparedStatement.setInt(2, 3);
            //执行
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
