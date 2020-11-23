package com.sunqian.classLoader;


public class ClassLoaderTest {
    /**
     * 测试类加载器，更多说明TO-DO
     */
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
    }
}
