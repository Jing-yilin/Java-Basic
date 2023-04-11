package com.hspedu.outputstream;

import com.hspedu.inputstream.Dog;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @ClassName ObjectOutputStream_
 * @Description 演示ObjectOutputStream的使用，完成数据序列化
 * @Author Jing Yilin
 * @Date 2022/1/31 11:14
 * @Version 1.0
 **/
public class ObjectOutputStream_ {
    public static void main(String[] args) throws IOException {
        //序列化后保存的文件格式不是纯文本，而是按照他的格式
        String fileName = "D:\\Test\\data.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));

        //序列化数据到该文件中
        oos.writeInt(100);//int 自动装箱成Integer，而Integer在底层是实现了Serializable的
        oos.writeBoolean(true);//底层是实现了Serializable的
        oos.writeChar('a');//底层是实现了Serializable的
        oos.writeDouble(9.5);//底层是实现了Serializable的
        oos.writeUTF("清华大学");//String
        //保存一个Dog对象
        oos.writeObject(new Dog("旺财", 10));

        oos.close();
        System.out.println("数据保存完毕（序列化形式）");
    }
}


