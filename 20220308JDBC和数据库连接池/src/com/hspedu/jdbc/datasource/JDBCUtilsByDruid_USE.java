package com.hspedu.jdbc.datasource;

import com.hspedu.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;

/**
 * @ClassName JDBCUtilsByDruid_USE
 * @Description TODO
 * @Author Zephyr
 * @Date 2022/5/8 22:59
 * @Version 1.0
 */
public class JDBCUtilsByDruid_USE {
    @Test
    public ArrayList<Actor> testSelect() {
        System.out.println("使用德鲁伊连接池完成~");
        //1.得到连接
        Connection connection = null;
        //2.组织sql
        String sql = "select * from actor where id >= ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        ArrayList<Actor> list = new ArrayList<>();
        try {
            //获取连接
            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            //执行得到数据集
            set = preparedStatement.executeQuery();
            //输出查询结果
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date bornDate = set.getDate("borndate");
                String phone = set.getString("phone");
                //把得到的结果封装进Actor对象
                list.add(new Actor(id, name, sex, bornDate, phone));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭查询
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }
        //因为已经封装到集合里了，所以关闭连接后数据还在
//        System.out.println("list集合数据 : " + list);
        for(Actor actor:list){
            System.out.println("id =" + actor.getId() + "\t" + actor.getName());
        }

        //甚至可以返回集合
        return list;
    }

    /*
    使用土方法，把ResultSet的结果封装到ArrayList
     */
    @Test
    public void testResultSetToArrayList(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //创建ArrayList，用来存放Actor
        ArrayList<Actor> list = new ArrayList<>();
        String sql = "SELECT * FROM actor";
        try {
            //获取连接
            connection = JDBCUtilsByDruid.getConnection();
            //获取预处理语句
            preparedStatement = connection.prepareStatement(sql);
            //执行预处理语句
            preparedStatement.executeQuery();
            //获得查询结果
            resultSet = preparedStatement.getResultSet();
            //输出查询结果
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String sex = resultSet.getString(3);
                Date bornDate = resultSet.getDate(4);
                String phone = resultSet.getString(5);
                //把记录封装到Actor对象，再放入ArrayList集合
                list.add(new Actor(id, name, sex, bornDate, phone));
            }

            for(Actor actor:list){
                System.out.println("id = " + actor.getId() + "\t" + "name = " + actor.getName());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //关闭查询
            JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
        }
    }
}
