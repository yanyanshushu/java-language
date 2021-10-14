package com.sunqian.git;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sunqian.http.HttpUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GitCloneCommand {

    //当当gitlab 列出项目api
    static String ddGigListUrl = "http://git.dangdang.com/api/v4/projects?private_token=CXwDEx_-XzHVMxyUC3CS&order_by=id&sort=asc&membership=true&simple=true&per_page=100&page=##";


    public static void main(String[] args) {
        //传入组名，通过git api 获得该组下的项目地址
        List<String> urls = getGitHttpUrl("xa/kefu");
        //clone到本机那个目录下
        String cloneToDir = "/Users/sunqian/IdeaProjects/xakefu";
        for (String url : urls) {
            System.out.println("开始克隆第【" + (urls.indexOf(url) + 1) + "】个项目");
            gitClone(url, cloneToDir);
        }
    }

    /**
     * 查询gitlab上某group下的所有项目列表，过滤出属于这个group的,分页查询，每页默认100个
     *
     * @param group group名，如xa/kefu、tms、ly_promise
     * @return 以http方式复制代码的urls
     */
    private static List<String> getGitHttpUrl(String group) {
        int page = 1;
        List<String> list = new ArrayList();
        JSONArray projects = null;
        do {
            String getUrl = ddGigListUrl.replace("##", page + "");
            String result = HttpUtil.get(getUrl);
            projects = JSONArray.parseArray(result);
            System.out.println("查询项目列表，第【" + page + "】页，共【" + projects.size() + "】个项目");

            for (int i = 0; i < projects.size(); i++) {
                JSONObject item = projects.getJSONObject(i);
                String path_with_namespace = item.getString("path_with_namespace");
                String http_url_to_repo = item.getString("http_url_to_repo");

                if (path_with_namespace.startsWith(group)) {
                    list.add(http_url_to_repo);
                    System.out.println("找到第【" + list.size() + "】个当前组下的项目：" + http_url_to_repo);
                }
            }
            page++;
        } while (projects.size() > 0);

        return list;
    }

    /**
     * 通过http url克隆项目
     *
     * @param cloneUrl  http方式克隆项目的地址
     * @param targetDir 克隆到哪个目录下，绝对路径
     */
    public static void gitClone(String cloneUrl, String targetDir) {
        String command = "git clone " + cloneUrl;
        File dir = new File(targetDir);
        System.out.println("start exec command : " + command);
        try {
            Process exec = Runtime.getRuntime().exec(command, null, dir);
            exec.waitFor();
            String successResult = inputStreamToString(exec.getInputStream());
            String errorResult = inputStreamToString(exec.getErrorStream());
            System.out.println("successResult: " + successResult);
            System.out.println("errorResult: " + errorResult);
            System.out.println("================ command executed ================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 流转字符串方法
     *
     * @param input
     * @return
     */
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
