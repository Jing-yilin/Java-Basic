package com.hspedu.printstream;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

/**
 * @ClassName PrintStream_
 * @Description 演示PrintStream(字节打印流)
 * @Author Jing Yilin
 * @Date 2022/2/1 11:56
 * @Version 1.0
 **/
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        // PrintStream输出数据的位置是 标准输出，即显示器
        /**
         * public void print(String s) {
         *         write(String.valueOf(s));
         *     }
         *
         * private void write(String s) {
         *         try {
         *             synchronized (this) {
         *                 ensureOpen();
         *                 textOut.write(s);
         *                 textOut.flushBuffer();
         *                 charOut.flushBuffer();
         *                 if (autoFlush && (s.indexOf('\n') >= 0))
         *                     out.flush();
         *             }
         *         }
         *         catch (InterruptedIOException x) {
         *             Thread.currentThread().interrupt();
         *         }
         *         catch (IOException x) {
         *             trouble = true;
         *         }
         *     }
         **/
        out.print("我爱学JAVA,");
        out.write("我要上清华".getBytes());

        out.close();

        //我们可以修改打印流的输出位置/设备
        System.setOut(new PrintStream("D:\\Test\\f1.txt"));
        System.out.println("我要上清华！");

    }
}
