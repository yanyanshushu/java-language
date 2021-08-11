package com.sunqian.algorithm;

import java.util.Stack;

public class XmlVerify {
    public static void main(String[] args) {

        /*
            测试用例：
            conf为：<a><b></b><c><d><e></e></d></c></a> 输出：深度4
            conf为:<a><d></d><e><f></f></e><a> 输出：深度3
            conf为：<b></b> 输出：深度1
            conf为：<a></c> 输出：不合法
            conf为：<d>     输出：不合法
         */


        String conf="<a><b></b><c><d><e></e></d></c></a>";
        verifyXml(conf);
    }

    /**
     * 打印xml嵌套深度，或者不合法
     * @param conf 一段xml配置片段
     */
    private static void verifyXml(String conf) {
        Stack<String> stack=new Stack<>();
        int depth=0;

        for(int i=0;i< conf.length();){
            int tagStart= conf.indexOf("<",i);
            int tagEnd= conf.indexOf(">",i);
            String tag= conf.substring(tagStart,tagEnd+1);

            if(tag.indexOf("/")!=-1){
                String checkTag= stack.peek();
                String removedTag=tag.replace("/","");
                if(checkTag.equals(removedTag)){
                    stack.pop();
                }
            }else {
                stack.push(tag);
                if(stack.size()>depth){
                    depth=stack.size();
                }
            }
            i=tagEnd+1;
        }
        if(stack.size()>0){
            System.out.println("该xml片段不合法");
        }else {
            System.out.println("该xml片段最大深度："+depth);
        }
    }
}
