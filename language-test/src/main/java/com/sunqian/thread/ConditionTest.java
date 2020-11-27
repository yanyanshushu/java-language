package com.sunqian.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangliang
 * <p>
 * 2016年4月8日 下午5:48:54
 */
public class ConditionTest {

    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        ConditionTest test = new ConditionTest();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();


        consumer.start();
        producer.start();
    }

    class Consumer extends Thread {

        @Override
        public void run() {
            consume();
        }

        private void consume() {

            try {
                lock.lock();
                System.out.println("我在等一个新信号" + this.currentThread().getName());
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("拿到一个信号" + this.currentThread().getName());
                lock.unlock();
            }

        }
    }

    class Producer extends Thread {

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            try {
                lock.lock();
                System.out.println("我拿到锁" + this.currentThread().getName());
                condition.signalAll();
                System.out.println("我发出了一个信号：" + this.currentThread().getName());
            } finally {
                lock.unlock();
            }
        }
    }

}
