# Properties配置文件

![image-20220201150700999](https://s2.loli.net/2022/02/01/1eA429KoCh8qyRO.png)

## 基本介绍

![image-20220201175421485](https://s2.loli.net/2022/02/01/bQOCsophxZRdWM8.png)

1. 专门用于读写配置文件的集合类
   配置文件的的格式：
   键=值
2. 注意：键值对不需要有空格，值不需要引号，默认类型为String。

## Properties常见的方法

![image-20220201175805788](https://s2.loli.net/2022/02/01/3xnmCZFD7cMwbfd.png)

## 应用案例

1. 使用Properties类完成对mysql.properties的读取

```java
//1. 创建properties
Properties properties = new Properties();
//2. 加载指定配置文件
properties.load(new FileReader("src\\mysql.properties"));
//3. 把K-V显示到控制台
properties.list(System.out);
```

![image-20220201201839436](https://s2.loli.net/2022/02/01/Egz3PTqduVQkSpy.png)

```java
//4. 根据k-v获取对应的值
String user = properties.getProperty("user");
String pwd = properties.getProperty("pwd");
System.out.println("用户名 = " + user);
System.out.println("密码 = " + pwd);
```

![image-20220201202059070](https://s2.loli.net/2022/02/01/UMOjkvWrGi7681T.png)

2. 使用Properties类添加或者修改K-V到新文件mysql2.properties中

```java
//使用Properties类创建配置文件，修改配置文件
Properties properties = new Properties();
//创建
//如果该文件没有key，则创建，有这个key，就是修改
properties.setProperty("charset", "utf-8");
properties.setProperty("user", "Tom");
properties.setProperty("pwd", "aabbcc");

//将K-V存储到文件中
// public void store(OutputStream out, String comments)
properties.store(new FileOutputStream("src\\mysql2.properties"), null);
System.out.println("保存配置文件成功~");
```

![image-20220201202715067](https://s2.loli.net/2022/02/01/sYpnNdzwOAvi1cj.png)

