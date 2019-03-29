package com.scy.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 类名： RandomAccessFileDemo <br>
 * 描述：RandomAccessFile 对应有 r 读取文件时，文件不存在抛出异常<br>
 * rw 写文件时，不存在则自动创建文件<br>
 * 已经被NIO 内存映射（memory-mapped file）替代
 * 创建日期： 2019/3/24 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) {
        try {
            RandomAccessFile r = new RandomAccessFile("c:\\scy\\test.txt", "r");
            RandomAccessFile rw = new RandomAccessFile("c:\\scy\\newTest.txt", "rw");
            int len;
            byte[] bytes = new byte[1024];
            while ((len = r.read(bytes)) != -1) {
                rw.write(bytes, 0, len);
            }
            rw.close();
            rw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
