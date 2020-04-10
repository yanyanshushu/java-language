package com.sunqian.jvm;

public class JVMStackOFE {

    private int stackDepth;

    private void stackLeak(){
        stackDepth++;
        System.out.println(this.stackDepth);
        String name="";

//        int  unused1=0,unused2=0,unused3=0,unused4=0,unused5=0,unused6=0,unused7=0,
//                unused8=0,unused9=0,unused10=0,unused11=0,unused12=0,unused13=0,unused14=0,unused15=0,
//                unused23=0,unused22=0,unused21=0,unused20=0,unused19=0,unused18=0,unused17=0,unused16=0,
//                unused24=0,unused25=0,unused26=0,unused27=0,unused28=0,unused29=0,unused30=0,unused31=0;
        stackLeak();
    }

    public static void main(String[] args) {

        JVMStackOFE oom=new JVMStackOFE();
        oom.stackLeak();
    }
}
