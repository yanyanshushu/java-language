package com.sunqian.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 *      测试过，对单个线程ReentrantLock是可重入的，多个线程共用的话，不可重入；
 *
 *      主线程，和新起的线程，共用一把锁，不能同时获得。而线程内部可以多次获得
 */
public class ReentrantLockTest {

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();

        for (int i = 1; i <= 3; i++) {
            lock.lock();
        }

        for(int i=1;i<=3;i++){
            try {
                if(lock.isLocked())
                    System.out.println("已加锁"+lock.getHoldCount());
                else
                    System.out.println("未加锁");
            } finally {
                lock.unlock();
            }
        }

        for (int i=0;i<100;i++){
            Thread  thread =new Thread(new Task(lock));
            thread.start();
        }
    }
}

class Task implements Runnable{

    ReentrantLock lock;

    Task(ReentrantLock lock){
        this.lock=lock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());
        this.lock.lock();
        try{
//            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" now:"+System.currentTimeMillis()+" lock time:"+lock.getHoldCount()+" queue count:"+lock.getQueueLength());
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());
            this.lock.unlock();
        }
    }
}
