# Properties

![image-20211220203115587](https://s2.loli.net/2021/12/21/Mh9lEoIpSOdeWiP.png)

## 基本介绍

1. Properties类继承自Hashtable类并且是实现Map接口，也是以键值对的形式来保存数据
2. 它的使用特点和Hashtable类似
3. Properties还可以用于从 xxx.properties 文件中，加载数据到Prooerties类对象，并进行读取和修改
4. 说明：工作后 xxx.properties 文件通常作为配置文件：[(49条消息) Java中读取properties配置文件的八种方式总结_Thinkingcao的专栏-CSDN博客_properties配置文件读取](https://blog.csdn.net/Thinkingcao/article/details/111897862)
5. 

## 代码示例

```java
 Properties properties = new Properties();
        //增加
        properties.put("程隰", 100);//k-v
//        properties.put(null, 100);//不能放null键
//        properties.put("cx", null);//不能放null值
        properties.put("cilixx", 100);
        properties.put("zephyr", 100);
        properties.put("zephyr", 80);//替换
        System.out.println("Properties = " + properties);

        //通过k获取对应的值
        properties.get("程隰");//88

        //删除
        properties.remove("cilixx");

        //修改
        properties.put("程隰", 99);

        //查
        properties.get("程隰");
        properties.getProperty("程隰");
```

## get和getProperties的区别

- Properties 中 get 传入Object 的 key 返回 Object 类型的 value
- Properties 中 getProperty 传入String 类型 key 返回 String 类型的 value

