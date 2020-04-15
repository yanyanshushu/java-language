package com.sunqian.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class FileTest {



    public static ArrayList<String> readSetFromFile(String name){
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            FileReader fr = new FileReader(name);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
