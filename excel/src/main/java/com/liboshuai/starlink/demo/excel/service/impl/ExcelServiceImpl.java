package com.liboshuai.starlink.demo.excel.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.liboshuai.starlink.demo.excel.common.utils.ExcelUtil;
import com.liboshuai.starlink.demo.excel.pojo.dao.UserExcel;
import com.liboshuai.starlink.demo.excel.service.ExcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
public class ExcelServiceImpl implements ExcelService {


    @Override
    @Async("starlinkAsyncExecutor")
    public void writeDataToExcel() {

        final int TOTAL_COUNT = 10_000_000; // 总数据条数
        final int SHEET_SIZE = 1_000_000; // 每sheet写入的数据条数
        final int BATCH_SIZE = 1_000; // 每次批量写入的数据条数
        final String filePath = "C:\\Users\\libos\\Desktop\\Users.xlsx"; // 写入的文件路径

        ExcelWriter excelWriter = EasyExcel.write(filePath, UserExcel.class).build();
        log.info("开始写入数据到Excel文件：");
        log.info("文件路径：{}", filePath);
        log.info("总条数：{}", TOTAL_COUNT);
        log.info("每Sheet条数：{}", SHEET_SIZE);
        log.info("批量写入条数：{}", BATCH_SIZE);
        int sheetNo = 0;
        for (int i = 0; i < TOTAL_COUNT; i += SHEET_SIZE) {
            WriteSheet writeSheet = EasyExcel.writerSheet(sheetNo++, "Sheet " + sheetNo).build();

            List<UserExcel> batchList = new ArrayList<>(BATCH_SIZE);
            for (int j = 0; j < SHEET_SIZE; j++) {
                if ((i + j) >= TOTAL_COUNT) break;
                batchList.add(generateUser(i + j));

                if (batchList.size() == BATCH_SIZE) {
                    excelWriter.write(batchList, writeSheet);
                    log.info("Sheet {}: 已写入 {} 条数据", sheetNo, (i + j + 1));
                    batchList.clear();
                }
            }

            // 写入剩余的数据
            if (!batchList.isEmpty()) {
                excelWriter.write(batchList, writeSheet);
                log.info("Sheet {}: 已写入 {} 条数据", sheetNo, (i + SHEET_SIZE));
            }
        }

        // 关闭资源
        if (excelWriter != null) {
            excelWriter.finish();
            log.info("所有数据已写入完毕，共计 {} 条数据", TOTAL_COUNT);
        }
    }

    @Override
    public List<UserExcel> importExcel(InputStream inputStream, Class<UserExcel> userExcelClass) {
        return ExcelUtil.importExcel(inputStream, userExcelClass);
    }

    private UserExcel generateUser(int id) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        UserExcel user = new UserExcel();
        user.setId(id);
        user.setName("Name" + id);
        user.setEmail("user" + id + "@example.com");
        user.setAge(random.nextInt(18, 60));
        return user;
    }
}
