package com.zhangqi.javaee.BeanXml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuServiceImpl {
    @Autowired
    @Qualifier("merchNos")
    List merchNos;


    public List getInfo(){
        return merchNos;
    }
}
