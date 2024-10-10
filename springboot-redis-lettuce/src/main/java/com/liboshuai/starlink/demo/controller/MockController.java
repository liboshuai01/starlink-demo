package com.liboshuai.starlink.demo.controller;

import com.liboshuai.starlink.demo.common.result.CommonResult;
import com.liboshuai.starlink.demo.service.MockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/mock")
public class MockController {

    @Resource
    private MockService mockService;

    @GetMapping("/testRedisCluster")
    public CommonResult<String> testRedisCluster() throws InterruptedException {
        mockService.testRedisCluster();
        return CommonResult.success("测试redis集群，正在运行......");
    }
}
