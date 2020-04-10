package com.sunqian.http;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;

public class HttpClientTest {

    public static void main(String[] args) {
        String url="http://10.7.41.194:8088/upload/image/1";
        fileUpload(url,"book.jpg");

    }

    public static JSONObject fileUpload(String url, String filePath){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost(url);

            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(200000).setSocketTimeout(200000).build();
            httppost.setConfig(requestConfig);

            String path=HttpClientTest.class.getResource("/").getPath();
            FileBody bin = new FileBody(new File(path+File.separator+filePath));
            StringBody sessionId = new StringBody("pc_d130a883320072c5a4c3a09504a2db61f8a0154801c70d7f673f553c65f15476", ContentType.TEXT_PLAIN);
            StringBody roomId = new StringBody("4982129", ContentType.TEXT_PLAIN);
            StringBody tenantId = new StringBody("1", ContentType.TEXT_PLAIN);
            StringBody userType = new StringBody("1", ContentType.TEXT_PLAIN);

            HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("file", bin)
                    .addPart("sessionId", sessionId).addPart("userType",userType)
                    .addPart("roomId",roomId).addPart("tenantId",tenantId).build();

            httppost.setEntity(reqEntity);

            System.out.println("executing request " + httppost.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                System.out.println(response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    String responseEntityStr = EntityUtils.toString(response.getEntity());
                    System.out.println(responseEntityStr);
                    System.out.println("Response content length: " + resEntity.getContentLength());
                }
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
