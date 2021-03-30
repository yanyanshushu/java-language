package com.sunqian;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sunqian.http.HttpUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JSONTest {

    //一个post请求，拼参数脚本。

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
                    post.put("isPresaleOrder",0);
                    post.put("opNum",params[1]);
                    post.put("orderAssortingType",0);
                    post.put("productId",params[0]);
                    post.put("productType",0);
                    post.put("warehouseId",22);
                    postList.add(post);
                }else {
                    callAndPrint(body);


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
                    post.put("isPresaleOrder",0);
                    post.put("opNum",params[1]);
                    post.put("orderAssortingType",0);
                    post.put("productId",params[0]);
                    post.put("productType",0);
                    post.put("warehouseId",22);
                    postList.add(post);
                }
            }
            callAndPrint(body);

            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //调接口，并打印结果。
    private static void callAndPrint(JSONObject body) {
        System.out.println(body.getString("orderId") + ":" + body.toJSONString());
        String path = "http://";
        String result = HttpUtil.postRequestByJson(path, body.toJSONString());
        System.out.println(result);
        System.out.println();
    }
}
