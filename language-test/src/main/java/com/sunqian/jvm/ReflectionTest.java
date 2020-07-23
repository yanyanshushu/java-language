package com.sunqian.jvm;

public class ReflectionTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class reflectionClass=ReflectionTest.class;
        ReflectionTest test=(ReflectionTest)reflectionClass.newInstance();
        test.print();
    }

    public void print(){
        System.out.println("实例方法被调用！");
    }

}
