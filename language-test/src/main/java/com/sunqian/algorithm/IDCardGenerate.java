package com.sunqian.algorithm;

public class IDCardGenerate {

    //1,输入区县6位，生日8位，顺序数3位（随机数值，奇男偶女），41062119600621124（女性）
    public static void main(String[] args) {
        String top17="41062119600621124";
        System.out.println(top17+caculateLastNum(top17));
    }

    public static char  caculateLastNum(String top17){
        int[] x = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
        char[] y = {'1','0','x','9','8','7','6','5','4','3','2'};
        int sum=0;
        for (int i = 0; i < top17.length(); i++) {
            int n=top17.charAt(i)-48;
            sum=sum+n*x[i];
        }
        sum=sum%11;
        return (y[sum]);
    }
}
