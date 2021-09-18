package com.sunqian;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

public class Test {

    /**
     * test whatever you like.
     * @param args
     */
    public static void main(String[] args) throws MalformedURLException {
        People[] o1 = {new People("sunqian")};
        People[] o2 = Arrays.copyOf(o1, o1.length);
        o1[0].setName("sunqianXXX");
        System.out.println(o2[0].getName());

        Integer a=null;
        System.out.println(a==null);
    }

}
class People{
    String name;

    People(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}