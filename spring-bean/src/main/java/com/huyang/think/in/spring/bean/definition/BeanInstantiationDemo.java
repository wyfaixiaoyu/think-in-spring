package com.huyang.think.in.spring.bean.definition;

import com.huyang.think.in.spring.ioc.overview.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class BeanInstantiationDemo {
    public static void main(String[] args) {
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-creation-context.xml");

        Map<String, User> userBeans = beanFactory.getBeansOfType(User.class);

        System.out.println(userBeans);
    }
}
