package com.sunqian.thread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池相关操作测试类,使用Executors的静态方法
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executor=Executors.newSingleThreadExecutor();

        for (int i=0;i<10;i++){
            executor.submit(new TaskOne());
        }

        executor.shutdown();

        System.out.println(1<<29);

    }
}

class TaskOne implements Runnable{

    @Override
    public void run() {
        System.out.println("我是一个runnable任务");
    }
}

class TaskTwo implements Callable{

    @Override
    public Boolean call() throws Exception {
        System.out.println("我是一个callable任务");
        return true;
    }
}
