package com.scy.io;

import java.io.*;

/**
 * 类名： CopyFileDemo <br>
 * 描述：文件复制 <br>
 * 创建日期： 2019/3/2 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class CopyFileDemo {

    public static void main(String[] args) {
        String src = "c:\\scy\\test.txt";
        String target = "c:\\scy\\test-copy.txt";
        copy(src, target);
    }

    private static void copy(String src, String target) {
        try (InputStream input = new FileInputStream(src);
             OutputStream output = new FileOutputStream(target)) {

            byte[] bytes = new byte[1024];
            int len;
            while ((len = input.read(bytes)) != -1) {
                output.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
