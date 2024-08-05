package com.liboshuai.starlink.demo.excel.service;

import com.liboshuai.starlink.demo.excel.pojo.dao.UserExcel;

import java.io.InputStream;
import java.util.List;

public interface ExcelService {

    void writeDataToExcel();

    List<UserExcel> importExcel(InputStream inputStream, Class<UserExcel> userExcelClass);
}
