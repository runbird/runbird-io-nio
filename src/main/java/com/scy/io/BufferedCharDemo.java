package com.scy.io;


import java.io.*;

/**
 * 类名： BufferedCharDemo <br>
 * 描述：FileReader内部使用的是FileInputStream，继承了InputeStreamReader，默认缓存为8K,StreamDecoder解码过程 byte->char
 * BufferedReader 默认也是8k，但是可以制定缓存大小new BufferedReader（in,size）。把数据读取到缓存中，减少每次转换的过程，效率更高
 *
 *      FileWriter
 * <br>
 * 创建日期： 2019/3/6 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class BufferedCharDemo {
    public static void main(String[] args) {
        write();
        read();

    }

    private static void read() {
        try {
            Reader fileReader = new FileReader("c:\\scy\\test.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            int len = -1;
            char[] cs = new char[1024];
            while ((len = reader.read(cs)) != -1) {
                System.out.println(new String(cs,0,len));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void write() {
        try {
            Writer fileWriter = new FileWriter("c:\\scy\\test.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write("重复系统的学习2");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
