package com.zhangqi.javaee.Filter;

import com.zhangqi.javaee.Annotaion.BeanXml.Car;
import com.zhangqi.javaee.Annotaion.BeanXml.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
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
@RequestMapping("/filter")
public class FilterController {




    @NeedLogin
    @RequestMapping(value = {"/list"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object list1() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("status", "000000");
        map.put("data", "nihao");
        return map;
    }
}