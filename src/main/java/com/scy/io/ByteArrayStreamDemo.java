package com.scy.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * 类名： ByteArrayStreamDemo <br>
 * 描述：TODO <br>
 * 创建日期： 2019/3/7 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ByteArrayStreamDemo {

    public static void main(String[] args) {
        byteArray();
    }

    private static void byteArray() {
        String info = "123456wertyhb%^&*ADGZDG";
        ByteArrayInputStream bis = new ByteArrayInputStream(info.getBytes());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int curr ;
        while ((curr = bis.read()) != -1) {
            if (curr >= 65 && curr <= 90 || curr >= 97 && curr <= 122) {
                bos.write(curr);
            }
        }
        //无需关闭，因为字节数组流是基于内存操作流
        System.out.println(bos.toString());
    }
}
