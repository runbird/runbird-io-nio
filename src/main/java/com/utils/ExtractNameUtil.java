package com.utils;

import java.io.File;

public class ExtractNameUtil {
    public static void main(String[] args) {
        String filesPath = "E:\\Learning\\图解Java设计模式\\temp";
        String deleteName = "尚硅谷-图解Java设计模式-";
        String targetPat = "E:\\Learning\\图解Java设计模式\\temp1\\";

        File fileSys = new File(filesPath);
        if (!fileSys.exists()) {
            System.out.println(" file path is valid");
        } else {
            File[] files = fileSys.listFiles();
            if (!(files.length == 0)) {
                for (File file : files) {
                    String oldName = file.getName();
                    String newName = oldName + ".mp4";
                    //  String newName = oldName.replace(deleteName, "").replace("(Av57936239,P", "");
               //     String[] split = oldName.split("\\.");
               //     String newName = split[1];
                    File newFile = new File(targetPat + newName);
                    System.out.println(newName);
                    file.renameTo(newFile);
//                }
//                for (int i = 0; i < files.length; i++) {
//                    File file = files[i];
//                    String old = file.getName();
//                    old.split()
//                    String replace = old.replace(String.valueOf(i+1) + '.', "")
//                            .replace(String.valueOf(i+1)+").","");
//                    File newFile = new File(targetPat + replace);
//                    file.renameTo(newFile);
//                }
                }
            }
        }
    }
}
