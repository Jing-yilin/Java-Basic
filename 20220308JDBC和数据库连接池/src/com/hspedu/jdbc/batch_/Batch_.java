package com.hspedu.jdbc.batch_;

import com.hspedu.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @ClassName Batch_
 * @Description 演示JAVA的批处理
 * @Author Jing Yilin
 * @Date 2022/3/11 10:05
 * @Version 1.0
 **/
public class Batch_ {

    /*
    传统方法，添加5000条数据到admin2
     */
    @Test
    public void noBatch() throws Exception{
        Connection connection = JDBCUtils.getConnection();
        String sql = "INSERT INTO admin2 VALUES(NULL, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方法耗时" + (end-start) + "ms");//传统方法耗时115111ms
        //关闭连接
        JDBCUtils.close(null, preparedStatement, connection);
    }

    /*
    使用批处理方式添加数据
     */
    @Test
    public void batch() throws Exception{
        Connection connection = JDBCUtils.getConnection();
        String sql = "INSERT INTO admin3 VALUES(NULL, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            //将 sql 语句添加到批处理 --> 看源码
            //1.第一就创建 ArrayList - elementData => 0bject[]
            //2. elementData => 0bject[] 就会存放我们预处理的sqL语句
            //3.当elementData满后，就按照1.5扩容
            //4.当添加到指定的值后，就executeBatch
            //5.批量处理会减少我们发送sqL语句的网络开销，而且减少编译次数，因此效率提高
            /*
                public void addBatch() throws SQLException {
                    synchronized(this.checkClosed().getConnectionMutex()) {
                        if (this.batchedArgs == null) {
                            this.batchedArgs = new ArrayList();
                        }

                        for(int i = 0; i < this.parameterValues.length; ++i) {
                            this.checkAllParametersSet(this.parameterValues[i], this.parameterStreams[i], i);
                        }

                        this.batchedArgs.add(new PreparedStatement.BatchParams(this.parameterValues, this.parameterStreams, this.isStream, this.streamLengths, this.isNull));
                    }
                }
             */
            preparedStatement.addBatch();
            //当有1000条记录时再批量执行
            if ((i + 1) % 1000 == 0){
                preparedStatement.executeBatch();
                //清空
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("批处理方法耗时" + (end-start) + "ms");//批处理方法耗时415ms
        //关闭连接
        JDBCUtils.close(null, preparedStatement, connection);
    }
}
