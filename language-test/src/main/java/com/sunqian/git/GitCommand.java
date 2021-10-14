package com.sunqian.git;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sunqian.http.HttpUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GitCommand {

    public static void main(String[] args) {
        List<String> urls= getGitHttpUrl("xa/kefu");
        String dir="/Users/sunqian/IdeaProjects/xakefu";
        for(String url:urls){
            gitClone(url,dir);
        }
    }

    private static List<String> getGitHttpUrl( String group) {
        String url="http://git.dangdang.com/api/v4/projects?private_token=CXwDEx_-XzHVMxyUC3CS&order_by=id&sort=asc&membership=true&simple=true&per_page=100&page=##";
        int page=1;
        List<String> list=new ArrayList();
        JSONArray projects=null;
        do{
            String  getUrl=url.replace("##",page+"");
            String result = HttpUtil.get(getUrl);
            projects=JSONArray.parseArray(result);

            for(int i=0;i<projects.size();i++){
                JSONObject item=projects.getJSONObject(i);
                int id=item.getInteger("id");
                String path_with_namespace=item.getString("path_with_namespace");
                String http_url_to_repo=item.getString("http_url_to_repo");
                System.out.println("处理到："+id);
                System.out.println(http_url_to_repo);
                if(path_with_namespace.startsWith(group)){
                    list.add(http_url_to_repo);
                }
            }
            page++;
        }while (projects.size()>0);

        return list;

    }

    public static void gitClone(String cloneUrl,String targetDir){
        String command="git clone "+cloneUrl;
        File dir=new File(targetDir);
        System.out.println("start exec command : " + command);
        try {
            Process exec = Runtime.getRuntime().exec(command, null, dir);
            exec.waitFor();
            String successResult = inputStreamToString(exec.getInputStream());
            String errorResult = inputStreamToString(exec.getErrorStream());
            System.out.println("successResult: " + successResult);
            System.out.println("errorResult: " + errorResult);
            System.out.println("================================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String inputStreamToString(final InputStream input) {
        StringBuilder result = new StringBuilder();
        Reader reader = new InputStreamReader(input);
        BufferedReader bf = new BufferedReader(reader);
        String line;
        try {
            while ((line = bf.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

}
