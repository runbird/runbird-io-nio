package com.scy.basic;

import java.io.Serializable;

/**
 * 类名： Dog <br>
 * 描述：进行序列化对象 <br>
 * 创建日期： 2019/3/7 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class Dog implements Serializable {

    private String name;
    private int age;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Dog(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
