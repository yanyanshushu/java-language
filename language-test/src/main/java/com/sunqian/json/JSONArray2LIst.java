package com.sunqian.json;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class JSONArray2LIst {
    public static void main(String[] args) {
        String json="[{\"traceNo\":\"9891234567890\"},{\"traceNo\":\"9891234567891\"}]";
        List<Trace> list = JSON.parseArray(json, Trace.class);
    }
}
