package com.liboshuai.starlink.demo.excel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ExcelApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExcelApplication.class, args);
    }
}
