package com.zhangqi.javaee.BeanXml;


import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Configuration
@ImportResource(locations = { "classpath:beans.xml" })
@Controller
@RequestMapping("/info")
public class Test {

    @Autowired
    @Qualifier("merchNos")
    List merchNos;

    @Autowired
    @Qualifier("student")
    Student student;

    @Autowired
    StuServiceImpl stuServiceImpl;


    @RequestMapping(value = {"/list"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object list() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("status", "000000");
        map.put("data", merchNos);
        return map;
    }

    @RequestMapping(value = {"/student"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object student() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("status", "000000");
        map.put("data", student);
        return map;
    }


    @RequestMapping(value = {"/getList"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object getList() {
//
//        StuServiceImpl stuService = new StuServiceImpl();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("status", "000000");
        map.put("data", stuServiceImpl.getInfo());
        return map;
    }


    @RequestMapping(value = {"/exception"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object getList1() {
        try {
            int i =1/0;
        } catch (Exception e) {
            e.printStackTrace();
            return "有异常";
        }
//
//        StuServiceImpl stuService = new StuServiceImpl();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("status", "000000");
        map.put("data", "没有异常");
        return map;
    }
}
