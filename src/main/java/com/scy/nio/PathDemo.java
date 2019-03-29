package com.scy.nio;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;

/**
 * 类名： PathDemo <br>
 * 描述：Path <br>
 * 创建日期： 2019/3/28 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class PathDemo {
    public static void main(String[] args) {
        File file = new File("D:\\Dowlands\\seaAndJ.jpg");
        String filePath = file.getPath();
        System.out.println("filePath: " + filePath);

        Path p1 = Paths.get("D:\\Dowlands", "seaAndJ.jpg");
        System.out.println("p1: " + p1);

        Path p2 = file.toPath();
        System.out.println("p2: " + p2);

        Path p3 = FileSystems.getDefault().getPath("C:\\scy", "test.txt");
        String info = "nio utils files append comments";

        Path p4 = Paths.get("C:\\scy\\files-copy-test.txt");

        //写文件
        try {
            Files.write(p3, info.getBytes(Charset.defaultCharset()), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //读文件
        try {
            byte[] bytes = Files.readAllBytes(p3);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //copy文件
        try {
            Files.copy(p3,p4,StandardCopyOption.COPY_ATTRIBUTES);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //move文件
        try {
            Files.move(p3,p4,StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //delete文件 文件不存在会抛出异常
        try {
            Files.delete(p4);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //
        try {
            boolean isMoved = Files.deleteIfExists(p4);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path p5 = Paths.get("D:\\test");
        try {
            //除了最后一个文件，其他必须存在
            Files.createDirectory(p5);
            //创建中间不存在的文件
            Files.createDirectories(p5);

            Files.createFile(p5);
           // 创建文件 前缀 后缀
           // Files.createTempDirectory(dir,prefix);
           // Files.createTempFile(dir,prefix,suffix)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
