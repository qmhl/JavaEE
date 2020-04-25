package com.zhangqi.javaee.IOC;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig {


    //例子
    @Bean("dataSource")
    //  方法中的JdbcProperties参数 相当于是@Autowired注入进来的
    public Map<String, String> dataSource(JdbcProperties jdbc) {
        Map<String, String> map = new HashMap<>();
        map.put("username",jdbc.getUsername());
        map.put("password",jdbc.getPassword());
        map.put("url",jdbc.getUrl());
        map.put("driverClassName",jdbc.getDriverClassName());

        return map;
    }
}