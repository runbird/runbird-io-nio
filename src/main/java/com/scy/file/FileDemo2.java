package com.scy.file;

import java.io.File;
import java.util.Arrays;

/**
 * 类名： FileDemo2 <br>
 * 描述：File API Demo <br>
 * 创建日期： 2019/2/19 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class FileDemo2 {

    public static void main(String[] args) {

        findFile(new File("c://"),".jpg");
    }

    private static void findFile(File target, String ext) {
        if (target == null) return;
        if (target.isDirectory()) {
            File[] files = target.listFiles();
            // c盘有不能访问的系统文件
            if (files != null) {
                // 递归调用直到找到需要类型文件
                Arrays.stream(files).forEach(file -> findFile(file, ext));
            }
        } else {
            // 此处表示File是一个文件
            String fileName = target.getName().toUpperCase();
            if (fileName.endsWith(".JPG")) {
                System.out.println("找到文件："+fileName);
                System.out.println("绝对路径："+target.getAbsolutePath());
            }
        }
    }
}
