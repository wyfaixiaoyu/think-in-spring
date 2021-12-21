package com.huyang.think.in.spring.bean.definition;

import com.huyang.think.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAliasDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        User user = applicationContext.getBean("user", User.class);
        User user1 = applicationContext.getBean("huyang-user", User.class);
        System.out.println(user == user1);
    }
}
