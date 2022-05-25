package com.example.knife4jdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.knife4jdemo.service.HttpService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

/**
 * Created on 2022/5/25 23:25
 */
@Service
public class HttpServiceImpl implements HttpService {

    @Override
    public String httpGet(String urlStr) {
        String str = "";
        try {
//            String urlStr = "https://www.dmoe.cc/random.php?return=json";
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(urlStr);
            //获取 GET 请求响应值
            CloseableHttpResponse response = httpClient.execute(httpGet);
            //将请求响应值转换为String类型
            // InputStream content = response.getEntity().getContent(); // 如果你只想获取响应内容，通过此方式
            String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
            //将String类型转换为json对象
            JSONObject responseJson = JSON.parseObject(responseString);
            //获取对应的value值
            System.out.println(responseJson);
            str = responseJson.get("imgurl").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public JSONObject httpPost(String urlStr) {
        JSONObject responseJson = null;
        try {
//            String urlStr = "https://www.dmoe.cc/random.php?return=json";
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(urlStr);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String responseString = EntityUtils.toString(response.getEntity());
            responseJson = JSON.parseObject(responseString);
            System.out.println(responseJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson;
    }
}