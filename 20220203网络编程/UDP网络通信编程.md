# UDP网络通信编程

## 基本介绍

1. 类 `DatagramSocket`和 `DatagramPacket` (数据包/数据报)实现了基于 **UDP协议**网络程序。
2. UDP数据报 通过 数据报套接字 `DatagramSocket`发送和接收，系统不保证UDP数据报一定能够安全送到目的地，也不能确定什么时候可以抵达。
3. `DatagramPacket`对象封装了UDP数据报，在数据报中包含了**发送端的IP地址**和端口号以及**接收端的IP地址**和**端口号**。
4. UDP协议中每个数据报都给出了完整的地址信息，因此无须建立发送方和接收方的连接

![image-20220204160847410](https://s2.loli.net/2022/02/04/iX4b6UK1NBvDcWg.png)

**说明：**

1. 没有明确的客户端和服务端，而是数据的发送端和接收端
2. 接受数据和发送数据是通过`DatagramSocket`对象完成的
3. 将数据封装到 `DatagramPacket` 对象/装包，发送
4. 当接收到 `DatagramPacket` 对象，需要进行拆包，取出数据
5. `DatagramSocket`可以指定在那个端口接收数据

## 基本流程

1. 核心的两个类/对象 `DatagramSocket`与`DatagramPacket`
2. 建立发送端，接收端（没有服务端和客户端概念）
3. 发送数据前，建立数据包/报 `DatagramPacket`对象
4. 调用`DatagramSocket`的发送、接收方法
5. 关闭`DatagramSocket`

![image-20220204161512044](https://s2.loli.net/2022/02/04/bQonuhxt6P3B5mA.png)

## 应用案例1

1. 编写一个接收端A,和一个发送端B
2. 接收端A在9999端口等待接收数据（`receive`)
3. 发送端B向接收端A发送数据"hello,明天吃火锅~"
4. 接收端A接收到发送端B发送的数据，回复“好的，明天见”，再退出
5. 发送端接收 回复的数据，再退出

### 接收端A代码

```java
public class UDPReceiverA {
    public static void main(String[] args)  throws IOException {
        //1. 创建一个 DatagramSocket对象，在9999端口监听
        DatagramSocket socket = new DatagramSocket(9999);

        //2. 构建一个 DatagramPacket对象，准备接受数据
        //   数据包最大为64KB
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        //3. 调用接收方法，将 通过网络传输的packet对象 填充到 我们的空的packet
        //   当有数据包发送到本机的9999端口，就会接收数据
        //   如果没有收到数据，就会堵塞
        System.out.println("---------------接收端A等待接收数据---------------");
        socket.receive(packet);

        //4. 可以对packet进行拆包，取出数据，并显示
        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        //发送反馈
        byte[] bytes = "好的，明天见啦~".getBytes();
        DatagramPacket packet1 = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.0.109"), 9998);
        socket.send(packet1);

        //关闭socket
        socket.close();
        System.out.println("---------------接收端A退出---------------");
    }
}
```

![image-20220204164532183](https://s2.loli.net/2022/02/04/ZoYFDdGs9RzLWMh.png)

### 发送端B代码

```java
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //1. 创建一个 DatagramSocket对象，准备在9999端口接受数据
        //   因为发送端也可以接收数据，所以也需要一个端口
        DatagramSocket socket = new DatagramSocket(9998);

        //2. 构建一个 DatagramPacket对象，放入要发送的数据
        byte[] bytes = "Hello, 今晚吃火锅吗?".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.0.109"), 9999);

        //3. 发送数据包
        socket.send(packet);

        //4. 接受并拆解数据包
        System.out.println("---------------接受来自接受端A的消息---------------");
        byte[] buf = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(buf, buf.length);
        socket.receive(packet1);
        int length = packet1.getLength();
        byte[] data = packet1.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        //关闭socket
        socket.close();
        System.out.println("---------------发送端B退出---------------");

    }
}
```

![image-20220204164539818](https://s2.loli.net/2022/02/04/rlmZe8cP7C9QV2j.png)

