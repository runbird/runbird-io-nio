package com.utils;

import java.io.File;

/**
 * 类名： ReplaceFileNameUtil <br>
 * 描述： <br>
 * 创建日期： 2021/9/19 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ReplaceFileNameUtil {

    public static void main(String[] args) {
        String projectPath = "E:\\Learning\\===课程===\\黑马架构师";
        File project = new File(projectPath);
        replaceName(project);
//        String name = "aaaa【海量资源尽在 666java.com】.txt";
//        System.out.println(name.replaceAll("【海量资源尽在 666java.com】",""));
    }

    private static void replaceName(File project) {
        if (!project.exists()) {
            System.out.println("project is empty");
        } else {
            File[] files = project.listFiles();
            if (files != null && files.length > 0) {
                for (int i = 0; i < files.length; i++) {
                    File directory = files[i];
                    if (!directory.isDirectory()) {
                        if (directory.getName().contains(".baiduyun.downloading") || directory.getName().contains("baiduyun.downloading.cfg")) {
                            directory.delete();
                        }
                        if (directory.getName().contains("【海量资源尽在 666java.com】")) {
                            String name = directory.getName();
                            String newName = name.replace("【海量资源尽在 666java.com】", "");
                            System.out.println("Path: "+directory.getPath());
                            directory.renameTo(new File(directory.getParent()+File.separator+newName));
                        }
                    } else {
                        replaceName(directory);
                    }
                }
            }
        }
    }
}
