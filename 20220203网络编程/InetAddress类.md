# InetAddress类

```java
class InetAddress implements java.io.Serializable {}
```

![image-20220203174937186](https://s2.loli.net/2022/02/03/ucIZHoDfBijOaK1.png)

## 相关方法

```java
//1. 获取本机的InetAddress对象
InetAddress localHost = InetAddress.getLocalHost();
System.out.println(localHost);// MyMatebook14/192.168.1.28

//2. 根据指代的主机名 获取InetAddress对象
InetAddress host1 = InetAddress.getByName("MyMatebook14");
System.out.println("host1 = " + host1);// host1 = MyMatebook14/192.168.1.28

//3. 根据一个域名，返回InetAddress对象，比如 www.baidu.com
InetAddress host2 = InetAddress.getByName("www.baidu.com");
System.out.println("host2 = " + host2);// host2 = www.baidu.com/36.152.44.95

//4. 通过 InetAddress对象, 获取对应主机地址
String hostAddress = host2.getHostAddress();
System.out.println("host2 对应的ip = " + hostAddress);// host2 对应的ip = 36.152.44.95

//5. 通过 InetAddress对象, 获取对应主机名(或者是域名)
String hostName = host2.getHostName();
System.out.println("host2 对应的域名(或者主机名) = " + hostName);// host2 对应的域名(或者主机名) = www.baidu.com
```

