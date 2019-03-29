package com.scy.io;

import java.io.*;
import java.nio.charset.Charset;

/**
 * 类名： CharAndByteStreamDemo <br>
 * 描述：字节流和字符流之间的转换 <br>
 *      OutputStreamWriter 将字符流转换为字节流
 *      InputStreamReader 将字节流转换为字符流
 *      文件 --> InputStream --> InputStreamReader --> 程序   （字节流 --> 字符流）
 * 创建日期： 2019/3/4 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class CharAndByteStreamDemo {

    public static void main(String[] args) throws FileNotFoundException {
        streamReader(new FileInputStream("c:\\tiejialog.log"));
        streamWriter(new FileOutputStream("c:\\scy\\test.txt"));
    }

    public static void streamReader(InputStream in) {
        Reader reader = new InputStreamReader(in, Charset.forName("GBK"));
        char[] cs = new char[1024];
        int len = -1;
        try {
            while ((len = reader.read(cs)) != -1) {
                System.out.println(new String(cs, 0, len));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void streamWriter(OutputStream out) {
        Writer writer = new OutputStreamWriter(out, Charset.forName("GBK"));
        try {
            writer.append("outputStreamWrite");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
