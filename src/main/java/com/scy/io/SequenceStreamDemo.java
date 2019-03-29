package com.scy.io;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 类名： SequenceStreamDemo <br>
 * 描述：SequenceInputStream 流媒体合并文件 <br>
 * 创建日期： 2019/3/8 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SequenceStreamDemo {

    public static void main(String[] args) {
        Vector<InputStream> vectors = getInputStreams();
        Enumeration<InputStream> es = vectors.elements();
        merge(es);
    }

    private static Vector<InputStream> getInputStreams() {
        File file1 = new File("f:\\test-1.mp4");
        File file2 = new File("f:\\test-2.mp4");
        File file3 = new File("f:\\test-3.mp4");
        File file4 = new File("f:\\test-4.mp4");
        InputStream in1 = null, in2 = null, in4 = null, in3 = null;
        try {
            in1 = new FileInputStream(file1);
            in2 = new FileInputStream(file2);
            in3 = new FileInputStream(file3);
            in4 = new FileInputStream(file4);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Vector<InputStream> vectors = new Vector<>();
        vectors.add(in1);
        vectors.add(in2);
        vectors.add(in3);
        vectors.add(in4);
        return vectors;
    }

    private static void merge(Enumeration<InputStream> es) {
        SequenceInputStream input = new SequenceInputStream(es);
        try {
            FileOutputStream outputStream = new FileOutputStream("f:\\合并文件.mp4");
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);
            int len;
            byte[] bytes = new byte[1024];
            while ((len = input.read()) != 1) {
                bos.write(bytes, 0, len);
                bos.flush();
            }
            input.close();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
