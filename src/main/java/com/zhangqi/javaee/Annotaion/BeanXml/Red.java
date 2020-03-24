package com.zhangqi.javaee.Annotaion.BeanXml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 加上@Component   就是把当前类注入到ioc容器中
 */
@Component
public class Red implements ApplicationContextAware , BeanNameAware, BeanFactoryAware {
    private  ApplicationContext applicationContext ;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("传入的applicationContext is"+applicationContext);
        //  下面是将applicationContext  注入到这个类中 这个类中然和地方都可以使用applicationContext
        this.applicationContext =applicationContext;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("传入的beanFactory is"+beanFactory);
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("传入的beanName is"+s);


    }
}
