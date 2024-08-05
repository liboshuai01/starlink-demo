package com.liboshuai.starlink.demo.excel.controller;

import com.liboshuai.starlink.demo.excel.common.result.CommonResult;
import com.liboshuai.starlink.demo.excel.pojo.dao.UserExcel;
import com.liboshuai.starlink.demo.excel.service.ExcelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/excel")
@Api(tags = "excel演示相关接口")
public class ExcelController {

    @Resource
    private ExcelService excelService;

    @ApiOperation("往excel写入数据")
    @GetMapping("/writeDataToExcel")
    public CommonResult<Boolean> writeDataToExcel() {

        excelService.writeDataToExcel();

        return CommonResult.success(true,"数据已经开始异步写入了，请查看控制台日志输出情况");
    }

    @ApiOperation("excel同步导入(适用于小数据量)")
    @PostMapping(value = "/importExcel",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CommonResult<List<UserExcel>> importExcel(@RequestPart("file") MultipartFile file) throws IOException {

        try (InputStream is = file.getInputStream()) {
            List<UserExcel> userExcels = excelService.importExcel(is, UserExcel.class);
            return CommonResult.success(userExcels);
        } catch (IOException e) {
            log.error("", e);
            return CommonResult.failed(e.getMessage());
        }
    }
}
