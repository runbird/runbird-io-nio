package com.scy.io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 类名： CompressionAndDecompressionDemo <br>
 * 描述：Compression and Decompression
 *      ZipOutputStream || ZipInputStream<br>
 * 创建日期： 2019/3/24 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class CompressionDemo {

    public static void main(String[] args) {
        compression("D:\\aa.zip",new File("D:\\ccccc\\闪现跳舞"));
    }

    /**
     * compreesion method
     *
     * @param zipTargetFileName
     * @param targetFile
     */
    private static void compression(String zipTargetFileName, File targetFile) {
        System.out.println("compression start .....");

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zipTargetFileName));
             BufferedOutputStream bos = new BufferedOutputStream(zout);
             InputStream input = new FileInputStream(targetFile);
             BufferedInputStream bis = new BufferedInputStream(input)) {

            zip(zout, targetFile, targetFile.getName(), bos, bis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("compression end .....");
    }

    /**
     * compression file method
     *
     * @param targetFile
     * @param fileName
     */
    private static void zip(ZipOutputStream zout, File targetFile, String fileName,
                            BufferedOutputStream bos, BufferedInputStream bis) throws IOException {
        if (targetFile.isDirectory()) {
            File[] files = targetFile.listFiles();
            if (files != null) {
                if (files.length == 0) {
                    //空文件夹
                    zout.putNextEntry(new ZipEntry(fileName + "/"));
                }
                // iter 快捷键
                for (File file : files) {
                    zip(zout, file, fileName + "/" + file.getName(), bos, bis);
                }
            }
        } else {
            //单个文件
            zout.putNextEntry(new ZipEntry(fileName));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            bis.close();
        }
    }
}
