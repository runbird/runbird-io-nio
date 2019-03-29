package com.scy.nio;

import java.nio.ByteBuffer;

/**
 * 类名： NIODemo <br>
 * 描述：NIO - ByteBuffer <br>
 * 创建日期： 2019/3/28 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class NIODemo {

    public static void main(String[] args) {
        //创建一个字节缓冲区 申请内存空间为8字节
        ByteBuffer buffer = ByteBuffer.allocate(8);
        // 0 8 8
        System.out.println("<------position: " + buffer.position());
        System.out.println("<------limit: " + buffer.limit());
        System.out.println("<------capacity: " + buffer.capacity());
        System.out.println("======================================");
        //向缓冲区写入数据
        buffer.put((byte) 10);
        buffer.put((byte) 20);
        buffer.put((byte) 30);
        buffer.put((byte) 40);
        System.out.println("<------position: " + buffer.position());
        System.out.println("<------limit: " + buffer.limit());
        System.out.println("<------capacity: " + buffer.capacity());

        System.out.println("======================================");
        //缓冲区只写入了4个字节 进行反转，去除多余空间
        buffer.flip();
        System.out.println("<------position: " + buffer.position());
        System.out.println("<------limit: " + buffer.limit());
        System.out.println("<------capacity: " + buffer.capacity());

        //当前位置position和限制limit之间是否有元素
        if (buffer.hasRemaining()) {
            System.out.println("between position and limit have existed elements");

            for (int i = 0; i < buffer.remaining(); i++) {
                byte b = buffer.get(i);
                System.out.println("the element :" + b);
            }
        }
    }
}
