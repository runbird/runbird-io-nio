package com.scy.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 类名： ChannalDemo <br>
 * 描述：Channal
 * 比较IO操作的性能比较:
 * 1.内存映射最快
 * 2.NIO读写文件
 * 3.使用了缓存的IO流
 * 4.无缓存的IO流
 * <br>
 * 创建日期： 2019/3/28 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ChannalDemo {
    public static void main(String[] args) {
        copy();
        randomAccessFileCopy();
    }

    /**
     * 通过FileChannel实现的文件复制
     */
    private static void copy() {
        try (FileChannel fic = new FileInputStream("D:\\Dowlands\\seaAndJ.jpg").getChannel();
             FileChannel foc = new FileOutputStream("d:\\copy.jpg").getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while ((fic.read(buffer)) != -1) {
                buffer.flip();
                foc.write(buffer);
                // !!!!
                buffer.clear();
            }
            System.out.println("copy success !!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 内存映射copy文件
     */
    private static void randomAccessFileCopy() {
        try {
            RandomAccessFile in = new RandomAccessFile("D:\\Dowlands\\seaAndJ.jpg", "r");
            RandomAccessFile out = new RandomAccessFile("D:\\copy-2.jpg", "rw");

            FileChannel fcIn = in.getChannel();
            FileChannel fcOut = out.getChannel();

            long size = fcIn.size();
            //输入流的缓冲区
            MappedByteBuffer bufIn = fcIn.map(FileChannel.MapMode.READ_ONLY, 0, size);
            //输出流的缓冲区
            MappedByteBuffer bufOut = fcOut.map(FileChannel.MapMode.READ_WRITE, 0, size);

            for (int i = 0; i < size; i++) {
                bufOut.put(bufIn.get());
            }
            //关闭（关闭通道的时候会写入数据）
            fcIn.close();
            fcOut.close();
            in.close();
            out.close();
            System.out.println("copy success !!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
