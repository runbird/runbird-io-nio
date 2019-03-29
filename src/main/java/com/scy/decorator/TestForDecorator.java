package com.scy.decorator;

import java.io.*;

/**
 * 类名： TestForDecorator <br>
 * 描述：Decorator test method <br>
 * 创建日期： 2019/3/28 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class TestForDecorator {

    public static void main(String[] args) {
        BasicClass decorated = new DecoratedClass();
        FirstDecorator first = new FirstDecorator(decorated);
        SecondDecorator second = new SecondDecorator(first);
        ThirdDecorator third = new ThirdDecorator(second);

        System.out.println("the price: " + third.price());
        System.out.println("the description: " + third.desc());
    }

    private static void example() throws FileNotFoundException {
        OutputStream output = new FileOutputStream("test");
        BufferedOutputStream bos = new BufferedOutputStream(output);
        PrintStream ps = new PrintStream(bos);
        ps.print("");
    }
}
