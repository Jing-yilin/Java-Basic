package com.hspedu.mhl.dao;

import com.hspedu.mhl.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

/**
 * @ClassName BasicDAO
 * @Description 开发BasicDAO，作为其他DAO的父类
 * @Author zephyr
 * @Date 2022/5/25 19:01
 * @Version 1.0
 */
public class BasicDAO<T> { //泛型指定具体类型

    private QueryRunner qr = new QueryRunner();

    //开发通用的dml方法，针对任意的表

    /**
     * 这是一个通用DML操作方法
     * @param sql sql语句，可以有?
     * @param parameters 替换sql语句里的?
     * @return 返回影响的行数
     */
    public int update(String sql, Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //返回多个对象

    /**
     *
     * @param sql 需要执行的sql语句,可以有?
     * @param clazz 传入一个类的Class对象,比如Actor.class
     * @param parameters 传入?的具体的值，可以有多个
     * @return 根据Class对象返回对应的ArrayList
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters){
        /*
         * 谈谈我对Class<T> clazz 的理解：
         * 首先Class类型是所有类都具有的一个属性，表示该类的类型
         * Class<T>则是指定了里面的泛型是T类
         * clazz 是T类的Class类的一个实例，表示T的类型
         */
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            List<T> query = qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
            return query; //返回对象数组
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }

    }


    //返回单行结果的通用方法

    /**
     *
     * @param sql 需要执行的sql语句,可以有?
     * @param clazz 传入一个类的Class对象,比如Actor.class
     * @param parameters 传入?的具体的值，可以有多个
     * @return 根据Class对象返回单行结果
     */
    public T querySingle(String sql, Class<T> clazz, Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            T query = qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);
            return query;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //返回单行结果的通用方法

    /**
     *
     * @param sql 需要执行的sql语句,可以有?
     * @param parameters 传入?的具体的值，可以有多个
     * @return 返回单个值
     */
    public Object queryScalar(String sql, Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new ScalarHandler(), parameters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }


}
