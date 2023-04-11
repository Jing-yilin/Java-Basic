package com.hspedu.map_;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @ClassName Map_
 * @Description TODO D:\Desktop\\Java_Study\\20211207集合\\Iterator\\Map\\Map.md
 * @Author Jing Yilin
 * @Date 2021/12/20 20:27
 * @Version 1.0
 **/
public class Map_ {
    public static void main(String[] args) {

        //Map的特点
        //1. Map与Collection并列存在。用于保存具有映射关系的数据：Key-Value
        //2. Map中的key和value可以是任何引用类型的数据，会封装到HashMap$Node对象中
        //3. Map中的key不允许重复，原因和HashSet一样，前面分析过源码
        Map map = new HashMap();
        map.put("景奕林",666);//k-v
        map.put("自由",777);//k-v
        map.put("景奕林",777);//k-v
        map.put(null, null);



        System.out.println("map = " + map);//会发现还是无序的，因为hashMap底层是根据hash排放的

        //5. Map中的value可以重复。当放入的k-v和其他的k重复，但是v不同相当于替换k
        //6. Map 的key可以为null,value也可以为null,注意key为null,只能有一个，value为null,可以多个.
        //7. 常用String类作为Map的key
        //8. key和value之间存在单向一对一关系，即通过指定的key总能找到对应的value

    }
}
