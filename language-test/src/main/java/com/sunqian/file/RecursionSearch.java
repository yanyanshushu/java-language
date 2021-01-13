package com.sunqian.file;

import com.sunqian.collection.HashMapTableConcurrentMapTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RecursionSearch {

        //计算文件数量
        public static int count = 0;

        //关键字
        public static String keyWords = "productId";
        public static String keyWords_ = "product_id";
        public static Set<String> resultSet = new HashSet<>();

        //搜索后查询到的文件路径汇总文件地址
        public static String searchedFilePath = "d:/searchedFile.txt";

        public static File searchedFile = new File(searchedFilePath);

        public static void main(String[] args){
            String[] paths={"si-reverse","si-invoice","ost","reverse-order","si-orderCalcCenter","order"};
//            String[] paths={"order/NewTransitJob-ddjob"};
            for(String path :paths){
                String dir = "D:/product_id/"+path+"/";
                File file = new File(dir);
                File[] files = file.listFiles();
                getFiles(files);
            }
            Iterator it=resultSet.iterator();

            FileOutputStream fos = null;
            try{
                fos = new FileOutputStream(searchedFile);
                if(!searchedFile.exists()){
                    searchedFile.createNewFile();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            try {
                while (it.hasNext()){
                    fos.write((it.next() + System.lineSeparator()).getBytes());
                    fos.flush();
                }
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("共搜过文件数："+count);
        }
    //递归搜索文件
        public static void getFiles(File[] files){
            FileInputStream fis = null;
            try{
                for(File file : files){
                    if(file.isDirectory()){
                        getFiles(file.listFiles());
                    }else{
                        count++;
                        String path=file.getAbsolutePath();
                        if(!path.endsWith(".java") && !path.endsWith(".xml")){
                            continue;
                        }

                        StringBuilder sb = new StringBuilder();
                        byte[] bytes = new byte[1024];
                        fis = new FileInputStream(file);
                        int len = 0;
                        while((len = fis.read(bytes)) != -1){
                            sb.append(new String(bytes, 0, len));
                        }
                        fis.close();
                        if(sb.indexOf("ProductId") >= 0 ||sb.indexOf("productId") >= 0 ||sb.indexOf("productid") >= 0){
                            System.out.println(path);
                            path=path.replace("D:\\product_id\\","");
                            int endIndex=path.indexOf("\\",path.indexOf("\\")+ 1);
                            path=path.substring(0,endIndex);
                            if(!resultSet.contains(path)){
                                resultSet.add(path);
                                System.out.println(path);
                            }
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }


    }
