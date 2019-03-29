package com.scy.io;

import java.io.*;
import java.util.Properties;

/**
 * 类名： PropertiesDemo <br>
 * 描述：读取配置文件 Propertis <br>
 * 创建日期： 2019/3/24 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class PropertiesDemo {
    private static String version;

    private static String username;

    private static String password;

    //使用静态代码块，只加载一次
    static {
        //initProperties();
    }

    public static void main(String[] args) {
        initProperties();
        System.out.println(version);
        System.out.println(username);
        System.out.println(password);

        updateProperties("2.0.0","root","root");
    }

    /**
     * read the config.properties
     */
    private static void initProperties() {
        Properties properties = new Properties();
        try {
            // 通过当前线程的类加载器对象 去加载指定包下的配置文件
            InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/resource/config.properties");
//          InputStream input = new FileInputStream("config.properties");
            properties.load(input);
            version = properties.getProperty("app.version");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * update file config.properties
     * @param version
     * @param username
     * @param password
     */
    private static void updateProperties(String version, String username, String password) {
        Properties properties = new Properties();
        properties.put("app.version", version);
        properties.put("db.username", username);
        properties.put("db.password", password);

        try {
            OutputStream output = new FileOutputStream("config.properties");
            properties.store(output, "备注信息");
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
