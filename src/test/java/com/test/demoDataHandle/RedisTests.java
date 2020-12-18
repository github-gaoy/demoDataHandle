package com.test.demoDataHandle;

import com.test.demoDataHandle.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.StringUtils;

/**
 * @program: demoDataHandle
 * @description: Redis单元测试
 * @author: gaoy
 * @create: 2020-12-18 11:10
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@SuppressWarnings("deprecation")
public class RedisTests {

    @Autowired
    public RedisUtil redisUtil;

    @Test
    public void testSetString() {
        String testString = (String) redisUtil.get("testString");
        if (StringUtils.isEmpty(testString)) {
            redisUtil.set("testString","测试String");
        }
        System.out.println(redisUtil.get("testString"));
    }

    @Test
    public void testSetStringWithTime() {
        String testString = (String) redisUtil.get("testStringTime");
        if (StringUtils.isEmpty(testString)) {
            redisUtil.set("testStringTime","测试testStringTime", 5);
        }
        System.out.println(redisUtil.get("testStringTime"));
    }

    @Test
    public void testIncr() {
        //redisUtil.set("testInt", 2);
        redisUtil.incr("testInt",100);
        System.out.println(redisUtil.get("testInt"));
    }

    @Test
    public void testDecr() {
        //redisUtil.set("testInt", 2);
        redisUtil.decr("testInt",1);
        System.out.println(redisUtil.get("testInt"));
    }



}
