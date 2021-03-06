package com.sunqian.file;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class FileTest {

    public static void main(String[] args) {
        readSetFromFile("/Users/sunqian/test.txt");
    }

    public static void readSetFromFile(String name){
        String preOrderId="";

        JSONObject body=new JSONObject();
        JSONArray cancelList=new JSONArray();
        JSONArray postList=new JSONArray();
        body.put("cancelList",cancelList);
        body.put("postList",postList);
        body.put("requestId","42220852255_20210319161630");
        body.put("token","order_2003");
        body.put("consistency",false);


        try {
            FileReader fr = new FileReader(name);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                String[] params=str.split("\t");
                if(preOrderId==""){
                    preOrderId=params[3];
                    body.put("orderId",params[3]);
                }
                if(preOrderId.equals(params[3])){
                    JSONObject cancel=new JSONObject();
                    cancel.put("productId",params[0]);
                    cancel.put("warehouseId",30);
                    cancelList.add(cancel);

                    JSONObject post=new JSONObject();
                    //"isPresaleOrder": 0,
                    //		"opNum": 80,
                    //		"orderAssortingType": 0,
                    //		"productId": 28499291,
                    //		"productType": 0,
                    //		"warehouseId": 22
                    post.put("isPresaleOrder",0);
                    post.put("opNum",params[1]);
                    post.put("orderAssortingType",0);
                    post.put("productId",params[0]);
                    post.put("productType",0);
                    post.put("warehouseId",22);
                    postList.add(post);
                }else {
                    System.out.println(body.getString("orderId")+":"+body.toJSONString());
                    System.out.println();


                    preOrderId=params[3];
                    body=new JSONObject();
                     cancelList=new JSONArray();
                     postList=new JSONArray();
                     body.put("orderId",params[3]);
                     body.put("cancelList",cancelList);
                    body.put("postList",postList);
                    body.put("requestId","42220852255_20210319161630");
                    body.put("token","order_2003");
                    body.put("consistency",false);
                    JSONObject cancel=new JSONObject();
                    cancel.put("productId",params[0]);
                    cancel.put("warehouseId",30);
                    cancelList.add(cancel);

                    JSONObject post=new JSONObject();
                    //"isPresaleOrder": 0,
                    //		"opNum": 80,
                    //		"orderAssortingType": 0,
                    //		"productId": 28499291,
                    //		"productType": 0,
                    //		"warehouseId": 22
                    post.put("isPresaleOrder",0);
                    post.put("opNum",params[1]);
                    post.put("orderAssortingType",0);
                    post.put("productId",params[0]);
                    post.put("productType",0);
                    post.put("warehouseId",22);
                    postList.add(post);
                }
            }
            System.out.println(body.getString("orderId")+":"+body.toJSONString());
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
