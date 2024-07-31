package com.liboshuai.starlink.demo.excel.controller;

import com.liboshuai.starlink.demo.excel.common.result.CommonResult;
import com.liboshuai.starlink.demo.excel.service.ExcelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/excel")
@Api(tags = "excel演示相关接口")
public class ExcelController {

    @Resource
    private ExcelService excelService;

    @ApiOperation("往excel写入数据")
    @GetMapping("/writeDataToExcel")
    public CommonResult<Boolean> writeDataToExcel() throws IOException {

        excelService.writeDataToExcel();

        return CommonResult.success(true,"数据已经开始异步写入了，请查看控制台日志输出情况");
    }
}
