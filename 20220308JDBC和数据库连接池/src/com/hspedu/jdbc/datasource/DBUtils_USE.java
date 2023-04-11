package com.hspedu.jdbc.datasource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DBUtils_USE
 * @Description 使用 Apache的DBUtils工具类 + druid 完成对actor表的crud
 * @Author Zephyr
 * @Date 2022/5/8 22:59
 * @Version 1.0
 */
public class DBUtils_USE {
    /*
    演示apache的DBUtils + 返回多条记录
     */
    @Test
    public void testQueryMany() throws Exception{ //返回结果是多行数据
        //1. 得到连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. 使用DBUtils的类和接口，需要先引入相关的jar包
        //3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4. 就可以执行相关方法
//        String sql = "select * from actor where id >= ?";
        String sql = "select id, name from actor where id >= ?";// 可以只获取一部分信息
        //解读
        //(1) query方法就是执行一个SQL语句，得到resultSet -> 封装到 -> ArrayList 集合中
        //(2) 返回集合
        //(3) connection: 连接
        //(4) sql: 执行的sql语句
        //(5) new BeanListHandler<>(Actor.class): 再将resultSet -> Actor对象 -> 封装到ArrayList
        //      底层使用反射机制，获取Actor类的属性
        //(6) 1 就是sql语句里面的 ? ，是可变参数，可以有多个
        //(7) 底层得到的resultSet, 会在query 关闭，关闭 prepareStatement
        List<Actor> list = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
        System.out.println("输出集合的信息");
        for (Actor actor: list){
            System.out.println(actor);
        }

        //释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    /*
    演示apache的DBUtils + 返回单行记录（单个对象）
     */
    @Test
    public void testQuerySingle() throws Exception{
        //得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //sql语句
        String sql = "select * from actor where id = ?";
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 3);
        System.out.println("输出对象的信息");
        if (actor == null){
            System.out.println("未查询到该条记录！");
        } else {
            System.out.println(actor);
        }

        //释放资源
        JDBCUtilsByDruid.close(null, null, connection);

    }

    /*
    演示apache的DBUtils + druid 返回单行单列（即一个Object对象)
     */
    @Test
    public void testScalar() throws Exception{
        //得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //sql语句
        String sql = "select name from actor where id = ?";
        Object o = queryRunner.query(connection, sql, new ScalarHandler(), 3);
        System.out.println("输出对象的信息");
        if (o == null){
            System.out.println("未查询到该条记录！");
        } else {
            System.out.println("o = " + o);
        }

        //释放资源
        JDBCUtilsByDruid.close(null, null, connection);

    }

    /*
    演示 apache-DBUtils + druid 完成DML (update, insert, delete)
     */
    @Test
    public void testDML() throws Exception{
        //得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();

        //组织sql 完成 update, insert, delete
//        String sql = "update actor set phone = ? where id = ?";
        String sql = "insert into actor values(null,  '景奕林', '男', '2002-03-30', '13819122899')";//update也可以执行insert语句
//        String sql = "delete from actor where id = ?";
        int affectedRow = queryRunner.update(connection, sql);//返回受影响的行数
        System.out.println(affectedRow > 0 ? "执行成功" : "执行没有影响到表");

        //释放资源
        JDBCUtilsByDruid.close(null, null, connection);

    }
}
