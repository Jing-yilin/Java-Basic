# Socket

## 基本介绍

1. 套接字(Socket)开发网络应用程序被广泛采纳，以至于成为事实上的标准。
2. 通信的两端都要有Socket，是两台机器间通信的端点。
3. 网络通信其实就是Socket之间的通信。
4. Socket允许程序把网络连接当成一个流，数据在两个Socket间通过IO传输。
5. 一般主动发起通信的应用程序属于客户端，等待通信请求的为服务端。

![image-20220203182532667](https://s2.loli.net/2022/02/03/iNXvqznxIUmw8C9.png)

当我们需要通讯时（读写数据），可以使用socket的方法

1. socket.getOutputStream()
2. socket.getInputStream()

socket的理解：

1. TCP编程 -- 可靠的
2. UDP编程 -- 不可靠的

# TCP网络通信编程

## 基本介绍

1. 基于客户端 - 服务端的网络通信
2. 底层使用的是TCP/IP协议
3. 应用场景举例：客户端发送数据，服务端接受并显示控制台
4. 基于Socket的TCP编程

![image-20220203184145720](https://s2.loli.net/2022/02/03/eZ5hxgNVHYJoQ7P.png)

## 应用案例1

1. 编写一个服务器端，和一个客户端
2. 服务器端在9999端口监听
3. 客户端连接到服务器端，发送"hello,server",然后退出
4. 服务器端接收到客户端发送的信息，输出，并退出

![image-20220203184555038](https://s2.loli.net/2022/02/03/rluiLZJy1qH6fDc.png)

客户端：

1. 连接服务端（需要IP和端口9999）
2. 连接上后，生成Socket，通过socket.getOutputStream()
3. 通过输出流，写入到数据通道

服务端：

1. 在本机的9999端口监听，等待连接
2. 当没有客户端连接9999端口时，程序会阻塞，等待连接
3. 通过socket.getInputStream()读取 客户端写入到数据通道的数据

### 服务端代码

```java
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        //1. 在本机的9999端口监听，等待连接(要求9999端口没有被占用)
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器在9999端口监听，等待连接...");
        //2.当没有客户端连接9999端口时，程序会阻塞，等待连接
        //  如果有客户端连接，则会返回一个socket对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("服务器端socket = " + socket.getClass());
        //3. 通过socket.getInputStream()得到和socket对象关联的输出流对象
        InputStream socketInputStream = socket.getInputStream();
        //4. IO读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = socketInputStream.read(buf)) != -1){
            System.out.println(new String(buf, 0, readLen));
        }
        //5. 关闭流对象、socket和serverSocket
        socketInputStream.close();
        socket.close();
        serverSocket.close();


    }
}
```

细节：serverSocket可以通过accept() 返回多个Socket [多个服务端连接的并发]

输出：

![image-20220203192227814](https://s2.loli.net/2022/02/03/VAz2D5TMPmyEwB9.png)

### 客户端代码

```java
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //1. 连接服务端（需要IP和端口9999）
        //   public Socket(InetAddress address, int port)
        //   如果连接成功，返回一个socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端socket返回 = " + socket.getClass());

        //2. 通过socket.getOutputStream()得到和socket对象关联的输出流对象
        OutputStream socketOutputStream = socket.getOutputStream();
        //3. 通过是输出流，写入数据到 数据通道
        socketOutputStream.write("hello, server!".getBytes());
        //4. 关闭流对象和socket
        socketOutputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
```

输出：

![image-20220203192241454](https://s2.loli.net/2022/02/03/CWR2BQ4Gzj8SZkh.png)

## 应用案例2

1. 编写一个服务器端，和一个客户端
2. 服务器端在9999端口监听
3. 客户端连接到服务器端，发送"hello,server",并接收服务器端回发的"hello,client",再退出
4. 服务器端接收到客户端发送的信息，输出，并发送"hello,client",再退出

### 服务端代码

```java
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        //新建服务器主机端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("--------------等待来自客户端的请求-------------");
        Socket socket = serverSocket.accept();
        System.out.println("--------------收到来自客户端的请求-------------");

        //读取并输出来自客户端的信息
        System.out.println("收到来自客户端的信息:");
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }
        socket.shutdownInput();//关闭输入流，表示输入结束
        //向客户端发送信息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello, client!".getBytes());
        socket.shutdownOutput();//关闭输出流，表示输出结束
        //关闭服务器端
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("--------------服务器端退出-------------");
    }
}
```

![image-20220203195110428](https://s2.loli.net/2022/02/03/2fqMdky57SFNVJ3.png)

### 客户端代码

```java
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        //建立socket连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //向服务端发送信息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello, server!".getBytes());
        socket.shutdownOutput();//关闭输出流，表示输出结束
        //读取并输出来自服务端的信息
        System.out.println("收到来自服务端的信息:");
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }
        socket.shutdownInput();//关闭输入流，表示输入结束
        //关闭客户端
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("--------------客户端退出-------------");
    }
}
```

![image-20220203195137887](https://s2.loli.net/2022/02/03/arOU3sAu4dentiV.png)

> 细节：每次的输入输出需要结束，使用 `socket.shutdownOutput()` 和 `socket.shutdownInput()`

## 应用案例3(使用字符流)

1. 编写一个服务端，和一个客户端
2. 服务端在9999端口监听
3. 客户端连接到服务端，发送"hello,server",并接收服务端回发的"hello,client",再退出
4. 服务端接收到客户端发送的信息，输出，并发送"hello,client",再退出

### 服务端代码

```java
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        //新建服务器主机端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("--------------等待来自客户端的请求-------------");
        Socket socket = serverSocket.accept();
        System.out.println("--------------收到来自客户端的请求-------------");

        //读取并输出来自客户端的信息
        System.out.println("收到来自客户端的信息:");
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //向客户端发送信息
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("Hello, client!");
        bufferedWriter.newLine();//插入一个换行符，表示写入结束
        bufferedWriter.flush();//如果使用字符流，需要手动刷新

        //关闭服务器端
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();
        System.out.println("--------------服务器端退出-------------");
    }
}
```

![image-20220203201354904](https://s2.loli.net/2022/02/03/LnXhsiu3Y7rUOao.png)

### 客户端代码

```java
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        //建立socket连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //向服务端发送信息
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("Hello, server!");
        bufferedWriter.newLine();//插入一个换行符，表示写入结束，此时要求读取时使用readLine()
        bufferedWriter.flush();//如果使用字符流，需要手动刷新
        //读取并输出来自服务端的信息
        System.out.println("收到来自服务端的信息:");
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //关闭客户端
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        System.out.println("--------------客户端退出-------------");
    }
}
```

![image-20220203201432455](https://s2.loli.net/2022/02/03/sUeb5KLgSzmt9Cn.png)

## 应用案例4

1. 编写一个服务端，和一个客户端
2. 服务器端在9999端口监听
3. 客户端连接到服务端，发送一张图片e:\\qie.png
4. 服务器端接收到客户端发送的图片，保存到src下，发送“收到图片”再退出
5. 客户端接收到服务端发送的“收到图片”，再退出
6. 该程序要求使用 StreamUtils.java

### 服务端代码

```java
public class SocketTCP04Server {
    public static void main(String[] args) throws IOException {
        //新建服务器主机端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("--------------等待来自客户端的请求-------------");
        Socket socket = serverSocket.accept();
        System.out.println("--------------收到来自客户端的请求-------------");

        //接受来自客户端的信息流
        System.out.println("--------------开始保存来自客户端的图片-------------");
        String fileName = "src\\testpic.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] buf = new byte[1024];
        int readLen;
        while ((readLen = bis.read(buf)) != -1){
            bos.write(buf, 0, readLen);
        }
        bos.flush();
        socket.shutdownInput();
        System.out.println("--------------图片保存成功-------------");

        //向客户端发送收到图片的信息
        System.out.println("--------------向客户端发送反馈-------------");
        String msg = "收到信息";
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("收到信息".getBytes());
        outputStream.flush();
        socket.shutdownOutput();
        System.out.println("--------------成功发送反馈-------------");

        //关闭流
        outputStream.close();
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();
        System.out.println("--------------服务器端退出-------------");


    }
}
```

### 客户端代码

```java
public class SocketTCP04Client {
    public static void main(String[] args) throws IOException {
        //建立socket连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("--------------与客户端建立连接-------------");

        //客户端向服务端发送图片
        System.out.println("--------------开始发送图片-------------");
        String fileName = "D:\\Test\\testpic.png";
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
        byte[] buf = new byte[1024];
        int readLen;
        while ((readLen = bis.read(buf)) != -1){
            bos.write(buf);
        }
        bos.flush();
        socket.shutdownOutput();
        System.out.println("--------------图片发送完毕-------------");

        //接受来自客户端的反馈
        String msg = "收到信息";
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        inputStream.read(bytes);
        socket.shutdownInput();
        String s = bytes.toString();
        if (s.equals(msg)){
            System.out.println("--------------收到服务端接受成功的信息,开始执行退出-----------");
        }

        //关闭流
        inputStream.close();
        bis.close();
        bos.close();
        socket.close();
        System.out.println("--------------客户端退出-------------");
    }
}
```

## netstst指令

1. `netstat -an` 可以查看当前主机网络情况，包括**端口监听情况**和**网络连接情况**

![image-20220204153023291](https://s2.loli.net/2022/02/04/eRZxuDGtP8jH1k5.png)

**本机地址**就是本主机监听的端口

**外部地址**就是本主机连接到的客户端/端口

**状态**有LISTENING和ESTABLISHED

2. `netstat -an | more`可以分页显示
3. `netstat -anb`可以显示监听程序

## 其他

事实上，客户端也是通过一个端口与服务端连接的，这个端口由TCP/IP分配，是随机的。
