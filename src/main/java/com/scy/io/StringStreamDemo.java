package com.scy.io;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

/**
 * 类名： StringStreamDemo <br>
 * 描述：StringReader || StringWriter字符串流 <br>
 * 创建日期： 2019/3/8 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class StringStreamDemo {

    public static void main(String[] args) {
        stringReaderMethod();
    }

    private static void stringReaderMethod() {
        StringReader reader = new StringReader("it's never too old to learn");
        //流标记器
        StreamTokenizer st = new StreamTokenizer(reader);
        int count = 0;
        //TT_EOF表示最后一个  it's 和 it is 结果不同
        //it's xxx 切分为 it  s xxxx两个部分
        while (st.ttype != StreamTokenizer.TT_EOF) {
            try {
                if (st.nextToken() == StreamTokenizer.TT_WORD) {
                    count++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        reader.close();
        System.out.println("统计到的单词数：" + count);
    }
}
