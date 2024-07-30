package com.liboshuai.starlink.demo.excel.controller;

import com.liboshuai.starlink.demo.excel.common.annotation.TakeTime;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/excel")
@Api(tags = "excel演示相关接口")
public class ExcelController {

    @TakeTime
    @GetMapping("ping")
    @ApiOperation("ping一下")
    public String ping() {
        return "pong";
    }
}
