package com.liboshuai.starlink.demo.excel.common.utils;

import com.alibaba.excel.EasyExcel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExcelUtil {

    /**
     * 同步导入(适用于小数据量)
     *
     * @param is 输入流
     * @return 转换后集合
     */
    public static <T> List<T> importExcel(InputStream is, Class<T> clazz) {
        try {
            return EasyExcel.read(is).head(clazz).autoCloseStream(false).sheet().doReadSync();
        } finally {
            // 确保输入流被关闭
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    log.error("",e);
                }
            }
        }
    }
}
