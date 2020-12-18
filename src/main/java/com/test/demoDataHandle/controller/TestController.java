package com.test.demoDataHandle.controller;

import com.test.demoDataHandle.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demoDataHandle
 * @description:
 * @author: gaoy
 * @create: 2020-12-18 10:37
 **/
@RestController
public class TestController {

    @Autowired
    public RedisUtil redisUtil;

    @RequestMapping("/getReidsTest")
    public String getReidsTest(){

        String testStr = (String) redisUtil.get("test");

        if (StringUtils.isEmpty(testStr)){
            redisUtil.set("test","content");
            return "还未加入redis，第一次加入";
        }
        return "redis缓存内容："+testStr;
    }

}
