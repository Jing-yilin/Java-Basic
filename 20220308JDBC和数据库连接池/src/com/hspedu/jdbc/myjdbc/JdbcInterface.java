package com.hspedu.jdbc.myjdbc;

/**
 * 我们规定的jdbc接口
 */
public interface JdbcInterface {
    //连接
    public Object getConnection();
    //crud
    public void crud();
    //关闭接口
    public void close();
}
