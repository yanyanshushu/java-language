package com.sunqian.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOutOfMemoryTest {

    public static void main(String[] args) {
        List<HeapOutOfMemoryTest> list=new ArrayList<>();
        while (true){
            list.add(new HeapOutOfMemoryTest());
        }
    }
}
