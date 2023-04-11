package com.hspedu.properties;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName Properties03
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/2/1 20:22
 * @Version 1.0
 **/
public class Properties03 {
    public static void main(String[] args) throws IOException {
        //使用Properties类创建配置文件，修改配置文件
        Properties properties = new Properties();
        //创建
        properties.setProperty("charset", "utf-8");
        properties.setProperty("user", "Tom");
        properties.setProperty("pwd", "aabbcc");

        //将K-V存储到文件中
        // public void store(OutputStream out, String comments)
        properties.store(new FileOutputStream("src\\mysql2.properties"), null);
        System.out.println("保存配置文件成功~");
    }
}
