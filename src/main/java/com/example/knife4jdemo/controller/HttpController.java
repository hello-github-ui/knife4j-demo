package com.example.knife4jdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.knife4jdemo.common.R;
import com.example.knife4jdemo.service.HttpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2022/5/25 23:27
 */
@Api(tags = "HTTP API")
@RestController
@RequestMapping("free/api")
public class HttpController {

    @Autowired
    private HttpService httpService;

    /**
     * get
     */
    @GetMapping("/get")
    @ApiImplicitParam(name = "urlStr", value = "公共免费的API url 地址", required = true)
    @ApiOperation(value = "get请求")
    public R doGet(@RequestParam(value = "urlStr") String urlStr) {
        String result = httpService.httpGet(urlStr);
        return R.ok(result);
    }


    /**
     * post
     */
    @GetMapping("/post")
    @ApiImplicitParam(name = "urlStr", value = "公共免费的API url 地址", required = true)
    @ApiOperation(value = "post请求")
    public R doPost(@RequestParam(value = "urlStr") String urlStr) {
        JSONObject jsonObject = httpService.httpPost(urlStr);
        return R.ok(jsonObject);
    }

}
