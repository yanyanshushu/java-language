package com.sunqian.jvm;

public class CustomerClassLoader extends ClassLoader {

    public static void main(String[] args) {
//        CustomerClassLoader loader=new CustomerClassLoader();
////        System.out.println(loader.getClass());
////        System.out.println(loader.getParent().getClass());
////        System.out.println(loader.getParent().getParent().getClass());
////        System.out.println(loader.getParent().getParent().getParent().getClass());
//        Short s=  Short.valueOf(1s);
//        System.out.println(s.toString());

        Class clazz=CustomerClassLoader.class;
        System.out.println(clazz.getName());
        System.out.println(clazz.getSuperclass());

    }

}
