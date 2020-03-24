package com.zhangqi.javaee.Annotaion.BeanXml;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Configuration
//  excludeFilters   排除扫描有@Controller注解的类
@ComponentScan(basePackages = "com.zhangqi.javaee.Annotaion.BeanXml",excludeFilters ={
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
} )
public class TestConfig {

//    @Bean
//    public Student student(){
//        return new Student("liwei","11111","99");
//    }
}
