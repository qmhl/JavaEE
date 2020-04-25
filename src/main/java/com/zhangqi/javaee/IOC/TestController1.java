package com.zhangqi.javaee.IOC;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/nf")
public class TestController1 {
    //  通过Autowired  注入
    @Autowired
    private JdbcProperties jdbcProperties;

//      下面是通过构造函数注入
//    private JdbcProperties jdbcProperties;
//
//    public TestController1(JdbcProperties jdbcProperties) {
//        this.jdbcProperties = jdbcProperties;
//    }


    @Autowired
    @Qualifier("dataSource")
    private Map<String,String> dataSource;

    @GetMapping("/auto")
    public RespVO info() {
        try {
            String username =jdbcProperties.getUsername();
            return new RespVO("000000", "", username);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespVO("999999", "失败字样");
        }
    }


    @GetMapping("/map")
    public RespVO info2() {
        try {
            Map<String, String> map =dataSource;
            return new RespVO("000000", "", map);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespVO("999999", "失败字样");
        }
    }

}
