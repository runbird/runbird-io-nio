package com.scy.io;

import java.io.*;

/**
 * 类名： ByteStreamDemo <br>
 * 描述：字节输出流，
 * 输出流：超类：OutputStream 对文件的输出流使用子类 FileOutputStream <br>
 * 输入流：超类：inputStream 对文件的输入流使用子类 FileInputStream <br>
 * 创建日期： 2019/2/19 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ByteStreamDemo {

    public static void main(String[] args) {
        out();
        input();
    }

    private static void out() {
        // 1.构建一个文件输出流对象
        File file = new File("c://scy//byteDemo01.txt");
        try {
            FileOutputStream outputStream = new FileOutputStream(file, true);
            //2. 输出的内容
            String context = "nono \r\n !!";  //换行 /r/n  String lineSeparator = System.getProperty("line.separator");
            //3. 写到文件
            outputStream.write(context.getBytes());
            outputStream.close();
            System.out.println("write success !!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void input() {
        File file = new File("c://scy//e2e.txt");
        try {
            FileInputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            StringBuilder sb = new StringBuilder();
            // 读取的长度，表示每次读取的字节长度 int len = -1;
            // 把数据读入到数组中，并返回读取的字节数，当不等-1时，表示读取到数据。等于-1时，表示文件已经读完了
            while (inputStream.read(bytes) != -1) {
                //根据读取到的字节数组，再转化为字符串内容，添加到SB中
                sb.append(new String(bytes));
            }
            System.out.println(sb.toString());
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void input2() {
        File file = new File("c://scy//e2e.txt");
        try {
            FileInputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            StringBuilder sb = new StringBuilder();
            int len = -1;
            while ((len = inputStream.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len));
            }
            System.out.println(sb.toString());
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
