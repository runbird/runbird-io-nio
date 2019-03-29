package com.scy;

import java.math.BigDecimal;

/**
 * 类名： Demo01 <br>
 * 描述：ctrl + alt + t  <br>
 * 创建日期： 2019/2/19 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class Demo01 {
    public static void main(String[] args) {
        double a = 0.00;
        boolean result = BigDecimal.ZERO.equals(a);
        System.out.println(result);
    }
}
