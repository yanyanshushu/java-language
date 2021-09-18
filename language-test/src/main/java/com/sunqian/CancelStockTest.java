package com.sunqian;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sunqian.http.HttpUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CancelStockTest {

    //一个post请求，拼参数脚本。

    public static void main(String[] args) {
        readSetFromFile("/Users/sunqian/test.txt");
    }

    public static void readSetFromFile(String name){
        JSONObject body=new JSONObject();
        body.put("requestId","20210323114001");
        body.put("opSourceId",6);


        try {
            FileReader fr = new FileReader(name);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            int i=0;
            while ((str = bf.readLine()) != null) {
                String[] params=str.split("\t");
                JSONArray orders=new JSONArray();
                JSONObject order=new JSONObject();
                order.put("orderId",Long.parseLong(params[0]));
                order.put("shopId",0);
                JSONObject pro=new JSONObject();
                pro.put("productId",23579654);
                JSONArray prods=new JSONArray();
                prods.add(pro);
                order.put("productIds",prods);
                orders.add(order);
                body.put("orders",orders);
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
        System.out.println(body.toJSONString());
        String path = "http://10.5.24.125:8034/stock/cancel.json";
        String result = HttpUtil.postRequestByJson(path, body.toJSONString());
        System.out.println(result);
        System.out.println();
    }
}
