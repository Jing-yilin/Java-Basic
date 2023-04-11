# IO流原理以及流的分类

## IO流原理

1. I/O是Input/Output的缩写，I/O技术是非常实用的技术，用于处理数据传输。如读/写文件，网络通讯等。
2. Java程序中，对于数据的输入/输出操作以”流（stream)”的方式进行。
3. java.io包下提供共了各种”流”类和接口，用以获取不同种类的数据，并通过方法输入或输出数据
4. 输入input:读取外部数据(磁盘、光盘等存储设备的数据）到程序（内存）中。
5. 输出output:将程序（内存）数据输出到磁盘、光盘等存储设备中

## 流的分类

- 按操作数据单位不同分为：字节流（8 bit),字符流（按字符）
- 按数据流的流向不同分为：输入流，输出流
- 按流的角色的不同分为：节点流，处理流/包装流

<img src="https://s2.loli.net/2022/01/29/Yym9eF5XfWowTAP.png" alt="image-20220129170832589" style="zoom: 67%;" />

> Java的IO流共涉及40多个类，实际上非常规则，都是从如上4个抽象基类派生的。
>
> 由这四个类派生出来的子类名称都是以其父类名作为子类名后缀。

![image-20220129171120229](https://s2.loli.net/2022/01/29/AWYCDQUSrcLdZtz.png)![image-20220129171140246](https://s2.loli.net/2022/01/29/U2zVc93xK1q8EI6.png)



<img src="https://s2.loli.net/2022/01/29/MLEVNWeHvBG1JAR.png" style="zoom:80%;" /><img src="https://s2.loli.net/2022/01/29/9yngoeb6k5r1TCW.png" alt="image-20220129171331353" style="zoom: 67%;" />

他们都是抽象类

- InputStream -- 字节的输入流
- OutputStream -- 字节的输出流
- Reader -- 字符的输入流
- Writer -- 字节的输出流

## IO流体系图-常用的类

![img](https://images2015.cnblogs.com/blog/999727/201611/999727-20161109130405092-2025696523.png)

### InputStream的常用子类

- FileInputStream:文件输入流
- BufferInputStream:缓冲字节输入流
- ObjectInputStream:对象字节输入流

![image-20220129173120100](https://s2.loli.net/2022/01/29/xGKlIrX93Yv5EzF.png)

#### FileInputStream

![image-20220129173830317](https://s2.loli.net/2022/01/29/hfKULQTumoqtJBx.png)

```java
//使用read()方法读取文件
@Test
public void readFile01() throws IOException {
    String fileName = "D:\\Test\\hello.txt";
    int readData = 0;
    //创建fileInputStream对象用于读取 文件
    FileInputStream fileInputStream = new FileInputStream(fileName);
    //public int read()从此输入流中读取一个数据字节。如果没有输入可用，则此方法将阻塞。
    //如果已到达文件末尾，则返回 -1,表示读取完毕
    while ((readData = fileInputStream.read()) != -1){
        System.out.print((char)readData);
    }
    //关闭流
    fileInputStream.close();
}

```

```java
//使用read(byte[] b)方法读取文件
//从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中
@Test
public void readFile02() throws IOException {
    String fileName = "D:\\Test\\hello.txt";
    //字节数组
    byte[] b = new byte[8]; // 一次读取8个字节
    int readLen = 0;
    //创建fileInputStream对象用于读取 文件
    FileInputStream fileInputStream = new FileInputStream(fileName);
    //如果已到达文件末尾，则返回 -1,表示读取完毕;
    //如果读取正常，就返回实际读取的字节数
    while ((readLen = fileInputStream.read(b)) != -1){
        System.out.print(new String(b,0,readLen));
    }
    fileInputStream.close();
}
```

### OutStream的常用子类

#### FileOutStream

![image-20220129183203488](https://s2.loli.net/2022/01/29/4zUB7xHqLFmgbCp.png)

![image-20220129183350199](https://s2.loli.net/2022/01/29/kiNryA9p2ablXdg.png)

```java
    /**
    * 演示使用FileOutputStream 将数据写入文件
    * 如果该文件不存在则创建
    */
    @Test
    public void writeFile() throws IOException {

        //创建FileOutputStream对象
        //1. new FileOutputStream(fileName) 创建方式 回覆盖原先所有内容
        //2. new FileOutputStream(fileName, true) 会追加内容
        String fileName = "D:\\Test\\a.txt";
        FileOutputStream fileOutputStream = null;
        fileOutputStream = new FileOutputStream(fileName, true);
        //写入一个字节
//        fileOutputStream.write('a');

        //通过循环写入多个字节
//        String content = "Galneryus";
//        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
//        for (int i = 0; i < bytes.length; i++) {
//            fileOutputStream.write(bytes[i]);
//        }

        //一次性写入多个字节 public void write(byte b[])
//        String content = "Galneryus and X Japan";
//        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
//        fileOutputStream.write(bytes);

        //指定输入字节数  write(byte[] b, int off, int len)
        //将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。
        String content = "Galneryus and X Japan";
        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        fileOutputStream.write(bytes,0,10);


        System.out.println("成功写入...");
        fileOutputStream.close();
    }
```

演示文件拷贝

```java
/**
 * 完成文件拷贝:
 * 将"D:\\Test\\testpic.png"拷贝到"D:\\Test\\Test2\\testpic.png""
 *
 * 思路:
 * 1.创建文件输入流，将文件读取到程旭
 * 2.创建文件的输出流，将读取到的文件数据，写入指定的文件
 */
System.out.println("程序启动");
long l1 = System.currentTimeMillis();
FileInputStream fileInputStream = null;
FileOutputStream fileOutputStream = null;
String originPath = "D:\\Test\\testpic.png";
String targetPath = "D:\\Test\\Test2\\testpic.png";
fileInputStream = new FileInputStream(originPath);
fileOutputStream = new FileOutputStream(targetPath);
byte[] buf = new byte[1024];//定义数组，提高读取效率
int readLen = 0;
while((readLen = fileInputStream.read(buf)) != -1){
    fileOutputStream.write(buf,0,readLen);
}
fileInputStream.close();
fileOutputStream.close();
long l2 = System.currentTimeMillis();
System.out.println("拷贝完毕，用时:" + ((double)l2-l1)/1000 + "秒");
```

### FileReader和FileWriter

<img src="https://s2.loli.net/2022/01/29/p2RVbQsUjdK9vZ4.png" alt="image-20220129191059853" style="zoom:60%;" /><img src="https://s2.loli.net/2022/01/29/ixfOzdwqE2HFphZ.png" alt="image-20220129191200171" style="zoom:50%;" />

FileReader和FileWriter是字符流，即按照字符来操作IO。

#### FileReader相关用法

![image-20220130103834430](https://s2.loli.net/2022/01/30/s3AGCD65IlKaTUt.png)

![image-20220130103432021](https://s2.loli.net/2022/01/30/FxCTH814zXAvGuN.png)

```java
        String fileName = "D:\\Test\\story.txt";
        //1. 创建一个FileReader
        FileReader fileReader = new FileReader(fileName);

        //2. 循环读取 使用raed()
//        int data;
//        while((data = fileReader.read()) != -1){
//            System.out.print((char) data);
//        }

        //2.或者使用数组记录
        char[] buf = new char[8];
        int readLen = 0;
        while((readLen = fileReader.read(buf)) != -1){
            System.out.print(new String(buf,0,readLen));
        }


        //3. 关闭FileReader
        fileReader.close();
```

#### FileWriter相关用法

![image-20220130103907153](https://s2.loli.net/2022/01/30/YxBLv6Fb5VSCGyI.png)

![image-20220130103921973](https://s2.loli.net/2022/01/30/WaAyJNx9emXSKnT.png)

> 注意：FileWriter使用后，必须关闭（close）或者（flush），否则写不到指定的文件。

```java
String content = "保研清华";
String fileName = "D:\\Test\\保研清华.txt";
FileWriter fileWriter = new FileWriter(fileName);

//1. write(int c) 
//写入单个字符
fileWriter.write('Q');
//2. write(char cbuf[])
//写入指定数组
fileWriter.write(content.toCharArray());
//3. write(char cbuf[], int off, int len)
//写入指定数组的指定部分指定长度
fileWriter.write(content.toCharArray(),0,2);
//4. write(String str)
//写入字符串
fileWriter.write(content);
//5. write(String str, int off, int len)
//写入字符串的的指定部分指定长度
fileWriter.write(content, 0,2);

//一定要close()关闭或者flush()刷新
fileWriter.close();

System.out.println("写入成功");
```

