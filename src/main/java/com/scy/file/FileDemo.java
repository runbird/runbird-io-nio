package com.scy.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * 类名： FileDemo <br>
 * 描述：File API demo <br>
 * 创建日期： 2019/2/19 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class FileDemo {

    public static void main(String[] args) {
        //File类表示一个文件或目录 \\ --> /
        File file = new File("c:/test/demo.text");
        File file2 = new File("c" + File.separator + "test" + File.separator + "demo.text");

        if (!file.exists()) {
            try {
                boolean isCreated = file.createNewFile();// 创建文件
                System.out.println("创建结果：" + isCreated);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("是否为文件夹：" + file.isDirectory());

        boolean remove = file.delete();
        System.out.println("是否删除成功：" + remove);

        File direction = new File("c:\\go");
        String[] files = direction.list();
        if (files != null) {
            //System.out.println(Arrays.toString(files));
            Arrays.stream(files).forEach(System.out::println);
        }

        File[] files2 = direction.listFiles();
        if (files2 != null) {
            for (File f : files2) {
                System.out.println("length:" + f.length());
                System.out.println("name:" + f.getName());
                System.out.println("相对路径:" + f.getPath());
                System.out.println("绝对路径:" + f.getAbsolutePath());
                System.out.println("是否为隐藏文件：" + f.isHidden());
                System.out.println("是否可读：" + f.canRead());
                System.out.println("最后修改的时间：" + f.lastModified());
            }
        }

        File f2 = new File("c:\\test\\scy");
        boolean isMaked = f2.mkdirs();
        //重命名与移动文件
        boolean rename = f2.renameTo(new File("c:\\test\\scy02"));
        boolean move = f2.renameTo(new File("c:\\test"));

        File f3 = new File("c:\\test\\my");
        File[] filterFiles = f3.listFiles(pathname -> pathname.getName().endsWith(".txt"));
        System.out.println(Arrays.toString(filterFiles));
    }
}
