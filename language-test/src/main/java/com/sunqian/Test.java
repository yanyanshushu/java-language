package com.sunqian;

import java.net.MalformedURLException;
import java.util.Arrays;

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