package com.scy.io;

import java.io.*;

/**
 * 类名： DataStreamDemo <br>
 * 描述：数据流 读取java中的数据类型<br>
 * 创建日期： 2019/3/23 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class DataStreamDemo {

    public static void main(String[] args) {
        dataOutputStream();
        dataIntputStream();
    }

    private static void dataOutputStream() {
        try {
            OutputStream out = new FileOutputStream("c:\\scy\\test.text");
            BufferedOutputStream bos = new BufferedOutputStream(out);
            DataOutputStream dos = new DataOutputStream(bos);
            //写入4个字节
            dos.writeInt(10);
            //写入1个字节
            dos.writeByte(4);
            dos.writeUTF("数据");
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dataIntputStream() {
        try (InputStream out = new FileInputStream("c:\\scy\\test.text");
             BufferedInputStream bis = new BufferedInputStream(out);
             DataInputStream dis = new DataInputStream(bis)) {
            System.out.println(dis.readInt() + "  " + dis.readByte() + "  " + dis.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
