package com.liboshuai.starlink.demo.service.impl;

import com.liboshuai.starlink.demo.service.MockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class MockServiceImpl implements MockService {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    @Async("starlinkAsyncExecutor")
    public void testRedisCluster() throws InterruptedException {
        while (true) {
            for (int i = 0; i < 1; i++) {
                String key = "key:" + System.currentTimeMillis() + ":" + i;
                String value = "value:" + i;
                redisTemplate.opsForValue().set(key, value);
                System.out.printf("Stored in Redis: {%s} = {%s}%n", key, value);
            }
            Thread.sleep(1000);
        }
    }
}