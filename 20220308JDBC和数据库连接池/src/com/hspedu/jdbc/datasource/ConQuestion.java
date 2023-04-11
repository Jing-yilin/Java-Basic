package com.hspedu.jdbc.datasource;

import com.hspedu.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

/**
 * @ClassName ConQuestion
 * @Description 测试传统的数据库连接，使用JDBC
 * @Author Zephyr
 * @Date 2022/5/8 10:08
 * @Version 1.0
 */
public class ConQuestion {

    //代码 连接mysql 5000次
    @Test
    public void testCon(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            //使用传统的JDBC得到链接
            Connection connection = JDBCUtils.getConnection();
            //关闭
            JDBCUtils.close(null, null, connection);
        }
        long end = System.currentTimeMillis();
        System.out.println("传统连接5000次数据库耗时" + (end-start) + "ms");
    }
}
