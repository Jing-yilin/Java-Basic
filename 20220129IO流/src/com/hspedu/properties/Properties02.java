package com.hspedu.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName Properties02
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/2/1 20:16
 * @Version 1.0
 **/
public class Properties02 {
    public static void main(String[] args) throws IOException {
        //使用Properties类完成对mysql.properties的读取

        //1. 创建properties
        Properties properties = new Properties();
        //2. 加载指定配置文件
        properties.load(new FileReader("src\\mysql.properties"));
        //3. 把K-V显示到控制台
//        properties.list(System.out);
        //4. 根据k-v获取对应的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名 = " + user);
        System.out.println("密码 = " + pwd);
    }
}
