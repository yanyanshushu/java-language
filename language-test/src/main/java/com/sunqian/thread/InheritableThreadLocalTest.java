package com.sunqian.thread;

public class InheritableThreadLocalTest {

    static InheritableThreadLocal<String> inheritableThreadLocal=new InheritableThreadLocal<>();

    public static void main(String[] args) {
        inheritableThreadLocal.set("这是主线程中设置的值");
        ChildThread childThread=new ChildThread(inheritableThreadLocal);
        childThread.run();
    }
}

class ChildThread implements Runnable{
    InheritableThreadLocal<String> inheritableThreadLocal=null;

    ChildThread(InheritableThreadLocal inheritableThreadLocal){
        this.inheritableThreadLocal=inheritableThreadLocal;
    }

    @Override
    public void run() {
        System.out.println(inheritableThreadLocal.get());
    }
}