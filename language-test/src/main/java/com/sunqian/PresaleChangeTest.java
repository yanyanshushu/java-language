package com.sunqian;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sunqian.http.HttpUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PresaleChangeTest {

    //一个post请求，拼参数脚本。

    public static void main(String[] args) {
        readSetFromFile("/Users/sunqian/test.txt");
    }

    public static void readSetFromFile(String name){
        JSONObject body=new JSONObject();
        body.put("productId","29288022");
        body.put("targetWarehouseId",30);
        body.put("consistency",false);


        try {
            FileReader fr = new FileReader(name);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            int i=0;
            while ((str = bf.readLine()) != null) {
                String[] params=str.split("\t");
                body.put("orderId",params[0]);
                body.put("warehouseId",params[1]);
                callAndPrint(body);
                System.out.println("处理到了第几个："+(i++));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //调接口，并打印结果。
    private static void callAndPrint(JSONObject body) {
        System.out.println(body.getString("orderId") + ":" + body.toJSONString());
        String path = "http://10.7.8.122:8089/warehouseService/change";
        String result = HttpUtil.postRequestByJson(path, body.toJSONString());
        System.out.println(result);
        System.out.println();
    }
}
