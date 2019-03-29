package com.scy.io;

import java.io.*;

/**
 * 类名： BufferedByteDemo <br>
 * 描述：BufferedOutputStream 内部缓存大小为8kb，write使用sychn修饰。每次写入都缓存数组byte中，当数组存满
 * 写入文件并flush<br>
 * 创建日期： 2019/3/6 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class BufferedByteDemo {
    public static void main(String[] args) {
        // write();
        read();
    }

    /**
     * BufferedOutputStream
     */
    private static void write() {
        try {
            OutputStream outputStream = new FileOutputStream("c:\\scy\\test.txt");
            BufferedOutputStream out = new BufferedOutputStream(outputStream);
            String info = "需要系统认真的学习，才能够进行提升";
            out.write(info.getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read() {
        File file = new File("c:\\scy\\test.txt");
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(file))) {
            int len = -1;
            byte[] bytes = new byte[1024];
            while ((len = input.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
