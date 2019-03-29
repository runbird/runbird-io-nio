package com.scy.io;

import java.io.*;

/**
 * 类名： FileDivisionDemo <br>
 * 描述：文件分割 <br>
 * 创建日期： 2019/3/23 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class FileDivisionDemo {

    public static void main(String[] args) {
        File target = new File("d:\\迅雷下载\\t28-520.MP4");
        long singleSize = 1024*1024*500;
        divisionFile(target, singleSize);
    }

    /**
     * 文件切割方法,按照 子文件大小切分
     *
     * @param targetFile
     * @param size
     */
    private static void divisionFile(File targetFile, long size) {
        if (targetFile == null) {
            return;
        }
        //源文件大小
        long fileSize = targetFile.length();
        //切割的份数
        int smallFileNum = (int) (fileSize % size == 0 ? fileSize / size : fileSize / size + 1);

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(targetFile))) {
            BufferedOutputStream bos = null;

            //需要读取的次数(小于1024读取一次)
            int count = 0;
            byte[] bytes;
            int len = -1;
            for (int i = 0; i < smallFileNum; i++) {
                bos = new BufferedOutputStream(new FileOutputStream("d:\\t285210-" + i + ".MP4"));
                // size为单个子文件大小，可能有余数，需要进行扫尾处理
                if (size >= 1024) {
                    bytes = new byte[1024];
                    //可能有玉树
                    count = (int) (size / 1024);
                } else {
                    bytes = new byte[(int) size];
                    count = 1;
                }

                //读取并分割文件
                while (count > 0 && (len = bis.read(bytes)) != -1) {
                    bos.write(bytes, 0, len);
                    bos.flush();
                    // ！！！ 很重要
                    count--;
                }

                //扫尾工作
                if (size % 1024 != 0) {
                    bytes = new byte[(int) (size % 1024)];
                    len = bis.read(bytes);
                    bos.write(bytes, 0, len);
                    bos.flush();
                    bos.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
