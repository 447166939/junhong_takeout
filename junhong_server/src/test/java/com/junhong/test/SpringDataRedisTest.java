package com.junhong.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest(classes = com.junhong.JunhongApplication.class)
public class SpringDataRedisTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    @Test
    public void testRedisTemplate(){
        // 测试RedisTemplate是否正确注入
        System.out.println("RedisTemplate: " + redisTemplate);
        
        // 测试Redis操作
        try {
            System.out.println("开始测试Redis操作...");
            redisTemplate.opsForValue().set("test", "Hello Redis");
            System.out.println("设置值成功");
            Object value = redisTemplate.opsForValue().get("test");
            System.out.println("获取值成功");
            System.out.println("Redis value: " + value);
        } catch (Exception e) {
            System.out.println("Redis操作失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
}