package com.example.knife4jdemo.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created on 2022/5/25 23:25
 */
public interface HttpService {

    // GET 请求获取响应结果(json格式的返回格式)
    String httpGet(String urlStr);

    // POST 请求获取响应结果(json格式的返回格式)
    JSONObject httpPost(String urlStr);
}
