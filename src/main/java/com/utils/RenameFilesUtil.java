package com.utils;

import java.io.File;

/**
 * 类名： RenameFilesUtil <br>
 * 描述：the util for rename files <br>
 * 创建日期： 2019/3/29 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class RenameFilesUtil {

    public static void main(String[] args) {
        String path = "F:\\Learning_movies\\===GO语言===\\尚硅谷 Go语言核心编程课程\\Go语言核心编程课程视频";
        String targetPath = "F:\\Learning_movies\\===GO语言===\\尚硅谷 Go语言核心编程课程\\Go语言视频";
        String regex = "尚硅谷_Go核心编程";
        File filePath = new File(path);
        rename(filePath, targetPath,regex);
    }

    private static void rename(File filePath, String targetPath,String regex) {
        if (!filePath.exists()) {
            System.out.println("this file path not exists ....");
        } else {
            File[] files = filePath.listFiles();
            if (files != null && files.length != 0) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        rename(filePath, targetPath,regex);
                    } else {
                        String originName = file.getName();
                        String newName = file.getName().replaceAll(regex, "_");
                        File newFile;
                        if (originName.contains(regex)) {
                            System.out.println("<=== file origin name: " + originName);
                            newFile = new File(targetPath + "\\" + newName);
                            System.out.println("=========================================== " + file.getAbsolutePath());
                            boolean result = file.renameTo(newFile);
                            System.out.println(result + " and new name: " + newFile.getName());
                        }
                    }
                }
            } else {
                System.out.println("this directory is empty ...");
            }
        }
    }

    private static void test() {
        File file = new File("d:\\test\\aaa.txt");
        boolean b = file.renameTo(new File("d:\\bb.txt"));
        System.out.println(b);
    }
}
