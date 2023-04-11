package com.hspedu.inputstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @ClassName ObjectInputStream_
 * @Description 使用ObjectInputStream读取data.dat并反序列化恢复数据
 * @Author Jing Yilin
 * @Date 2022/1/31 12:20
 * @Version 1.0
 **/
public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //指定反序列化文件
        String fileName = "D:\\Test\\data.dat";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));

        //读取（反序列化）
        //1. 读取的顺序需要和保存数据的顺序一致,否则会出现异常
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        //dog的编译类型是 Object,运行类型是Dog
        Object dog = ois.readObject();
        System.out.println("运行类型 = " + dog.getClass());
        System.out.println("dog = " + dog);//底层Object->Dog

        //如果我们要使用Dog的方法，需要向下转型
        Dog myDog = (Dog)dog;
        System.out.println(myDog.getAge());


        //关闭流，关闭外层流即可
        ois.close();
        System.out.println("读取完毕");

    }
}
