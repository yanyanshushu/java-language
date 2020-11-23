package com.sunqian.thread;

public class ThreadTest {

    /**
     * 该测试，两个线程，线程内部方法加锁，测试不同代码处线程的状态。
     *
     * 阻塞状态是不能打印的，jstack可能能输出出来。
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Task3());
        Thread thread2=new Thread(new Task3());
        System.out.println("0:"+thread.getName()+":"+thread.getState());
        thread.start();
        thread2.start();


    }
}
class Task3 implements Runnable{

    @Override
    public void run() {
        System.out.println("1:"+Thread.currentThread().getName()+":"+Thread.currentThread().getState());
        try{
            lock();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("2:"+Thread.currentThread().getName()+":"+Thread.currentThread().getState());
    }

    public static synchronized void lock() throws InterruptedException {
        Thread.sleep(2*1000);
        System.out.println("3:"+Thread.currentThread().getName()+":"+Thread.currentThread().getState());
    }
}