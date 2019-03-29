package com.scy.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名： HashCodeDemo <br>
 * 描述：TODO <br>
 * 创建日期： 2019/3/6 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class HashCodeDemo {

    public static void main(String[] args) {
        Person p1 = new Person(1, "hello");
        Person p2 = new Person(1, "hello");
        Map<Object, String> map = new HashMap<>();
        map.put(p1, "1");
        System.out.println(map.get(p2));
        System.out.println(p1.equals(p2));
    }
}
