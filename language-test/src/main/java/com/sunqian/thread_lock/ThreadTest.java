package com.sunqian.thread_lock;

public class ThreadTest {

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