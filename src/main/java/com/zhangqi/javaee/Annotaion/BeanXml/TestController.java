package com.zhangqi.javaee.Annotaion.BeanXml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/3 21:57
 * @Version 1.0
 */
@Controller
@RequestMapping("/bean")
public class TestController {
    @Autowired
    private  Student stu;

    private  Car  car;

    public void setCar(Car car) {
        this.car = car;
    }

    @RequestMapping(value = {"/list"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object list() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("status", "000000");
        map.put("data", stu);
        this.car = new Car();
        Car car = new Car();
        car.setAge("888");
        car.setName("tomcat");
        this.car = car;
        return map;
    }


    @RequestMapping(value = {"/getCar"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object list1() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("status", "000000");
        map.put("data", car);
        return map;
    }
}