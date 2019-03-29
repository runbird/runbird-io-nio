package com.scy.io;

import com.scy.basic.Dog;

import java.io.*;

/**
 * 类名： SerializableStreamDemo <br>
 * 描述：ObjectInputStream ObjectOutputStream 序列化 <br>
 * 创建日期： 2019/3/7 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SerializableStreamDemo {

    public static void main(String[] args) {
//        Dog dog = new Dog("mi", 2, "femal");
//        writeObject(dog);
//        readObject();
        System.out.println(Integer.MAX_VALUE);
    }

    /**
     * 反序列化
     */
    private static void readObject() {
        File file = new File("c:\\scy\\dog.obj");
        try {
            FileInputStream inputStream = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            Dog o = (Dog)ois.readObject();
            ois.close();
            System.out.println(o.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 序列化
     * @param dog
     */
    private static void writeObject(Dog dog) {
        File file = new File("c:\\scy\\dog.obj");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream oot = new ObjectOutputStream(outputStream);
            oot.writeObject(dog);
            oot.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
