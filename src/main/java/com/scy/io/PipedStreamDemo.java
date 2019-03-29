package com.scy.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类名： PipedStreamDemo <br>
 * 描述：PipedInputStream ||  PipedOutputStream <br>
 * 关于线程池的使用参考：https://blog.csdn.net/congge_1993/article/details/73497439
 * 创建日期： 2019/3/23 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class PipedStreamDemo {

    public static void main(String[] args) throws InterruptedException {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream();

        try {
            pis.connect(pos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ReadThread read = new ReadThread(pis);
        WriteThread write = new WriteThread(pos);

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder();
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(5, 200, 0L,
                        TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), namedThreadFactory);
        executor.execute(read);
        executor.execute(write);

        Thread.sleep(10);
        executor.shutdown();

//          new Thread(read).start();
//          new Thread(write).start();
    }
}

class ReadThread implements Runnable {

    private PipedInputStream pis;

    public ReadThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        byte[] bytes = new byte[1024];
//        int len = -1;

        try {
//            while ((len = pis.read(bytes)) != -1) {
//                System.out.println(new String(bytes, 0, len));
//            }
            //阻塞
            int len = pis.read(bytes);
            pis.close();
            String info = new String(bytes, 0, len);
            System.out.println("读到："+info);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class WriteThread implements Runnable {

    private PipedOutputStream pos;

    public WriteThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        String info = "好好敲代码，多思考，多总结";
        try {
            pos.write(info.getBytes());
            pos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ThreadFactoryBuilder implements ThreadFactory {

    private final AtomicInteger mThreadNum = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
        System.out.println(t.getName() + " has been created");
        return t;
    }
}

