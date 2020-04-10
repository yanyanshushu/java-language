package com.sunqian.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapThradSafe {


    /**
     * HashMap的线程不安全性验证
     * @param args
     */
    public static void main(String[] args) {
        Map map=new HashMap<String,String>();

        for(int i=0;i<1000;i++){
            Thread t=new Thread(new Task(map,"key"+i));
            t.start();
        }
    }



}
class Task implements Runnable{
    Map map=null;
    String key=null;

    Task(Map map,String key){
        this.map=map;
        this.key=key;
    }

    @Override
    public void run() {

        map.put(key,key);
        System.out.println("插入key:"+key+" 当前size:"+map.size());

    }
}