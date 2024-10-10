package com.liboshuai.starlink.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Hello world!
 *
 */
@EnableAsync
@SpringBootApplication
public class RedisLettuceApplication
{
    public static void main(String[] args) {
        SpringApplication.run(RedisLettuceApplication.class, args);
    }
}
