package com.liboshuai.starlink.demo.excel.pojo.dao;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class UserExcel {
    @ExcelProperty("ID")
    private Integer id;
    @ExcelProperty("Name")
    private String name;
    @ExcelProperty("Email")
    private String email;
    @ExcelProperty("Age")
    private Integer age;
}
