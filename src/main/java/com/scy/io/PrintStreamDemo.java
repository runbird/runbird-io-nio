package com.scy.io;

import java.io.*;

/**
 * 类名： PrintStreamDemo <br>
 * 描述：打印流，方便输出 <br>
 * 创建日期： 2019/3/6 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class PrintStreamDemo {

    public static void main(String[] args) {
        bytePrint();
        charPrint();
    }

    /**
     * 字节打印流，在字节输出时，可以增强输出功能
     */
    private static void bytePrint() {
        File file = new File("c:\\scy\\test.txt");
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(file);
            BufferedOutputStream writer = new BufferedOutputStream(outputStream);
            PrintStream ps = new PrintStream(writer);
            ps.println("会须一饮三百杯");
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符打印流
     */
    private static void charPrint() {
        File file = new File("c:\\scy\\test.txt");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            PrintWriter ps = new PrintWriter(writer);
            ps.append("与尔同销万古愁");
            ps.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
