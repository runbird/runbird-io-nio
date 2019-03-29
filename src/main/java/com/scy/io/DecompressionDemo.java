package com.scy.io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 类名： DecompressionDemo <br>
 * 描述：Compression and Decompression
 * ZipOutputStream || ZipInputStream<br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class DecompressionDemo {

    public static void main(String[] args) {
        decompression("d:\\test.zip","d:\\ddd");
    }

    /**
     *
     * @param targetFilename
     * @param parent
     */
    private static void decompression(String targetFilename, String parent) {
        System.out.println("decompression start !");
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(targetFilename))
        ) {
            ZipEntry entry;
            File file;
            OutputStream out;
            //zip中有entry且entry不为文件夹
            while ((entry = zis.getNextEntry()) != null && !entry.isDirectory()) {
                //创建父目录和子目录
                file = new File(parent, entry.getName());
                if (!file.exists()) {
                    //创建该文件的目录
                    boolean mkdirs = new File(file.getParent()).mkdirs();
                    System.out.println(file.getName() + " make directions success");
                }
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
                byte[] bytes = new byte[1024];
                int len;
                while ((len = zis.read(bytes)) != -1) {
                    bos.write(bytes, 0, len);
                }
                bos.close();
                System.out.println(  file.getAbsolutePath() +" decompression success !");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
