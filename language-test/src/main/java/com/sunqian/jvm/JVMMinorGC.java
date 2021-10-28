package com.sunqian.jvm;

public class JVMMinorGC {

    private static final int _1MB=1024*1024;
    /**
     *  GVM 参数：-verbose:gc -Xms=20m -Xmx=20m -Xmn=10M -XX:PrintGCDetails -XX:SurvivorRatio=8
     */

    public static void testAllotcation(){
        byte[] allotcation1,allotcation2,allotcation3,allotcation4;
        allotcation1=new byte[2 * _1MB];
        allotcation1=new byte[2 * _1MB];
        allotcation1=new byte[2 * _1MB];
        allotcation1=new byte[4 * _1MB];//出现一次full gc
    }

    public static void main(String[] args) {
        testAllotcation();
    }
}
