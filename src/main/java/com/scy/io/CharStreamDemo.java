package com.scy.io;

import java.io.*;

/**
 * 类名： CharStreamDemo <br>
 * 描述：字符流
 *  字符输出流：父类：Writer 对文件的操作使用子类FileWriter
 *  字符输入流：父类：Reader 对文件的操作使用子类FileReader<br>
 *  每次操作的单位是一个字符
 * 创建日期： 2019/2/20 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class CharStreamDemo {

    public static void main(String[] args) {
        writer();
        read();
    }

    private static void writer() {
        File file = new File("c:\\test\\test.txt");
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("你好世界！");
            writer.close();;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void read() {
        File file = new File("c:\\test\\test.txt");
        try {
            FileReader reader = new FileReader(file);
            char[] cs = new char[1];
            int len = -1;
            StringBuilder sb = new StringBuilder();
            while ((len = reader.read(cs)) != 1) {
                sb.append(new String(cs, 0, len));
            }
            reader.close();
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
