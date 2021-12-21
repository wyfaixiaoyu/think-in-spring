package com.huyang.think.in.spring.ioc.overview.dependency.lookup;

import com.huyang.think.in.spring.ioc.overview.annotation.Super;
import com.huyang.think.in.spring.ioc.overview.domain.SuperUser;
import com.huyang.think.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class DependencyLookupDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-lookup-context.xml");
        //getBeanByIdInRealTime(beanFactory);
        //getBeanByTypeInRealTime(beanFactory);
        //getBeanByIDInLazy(beanFactory);
        //getCollectionByType(beanFactory);
        //getCollectionByAnnotationType(beanFactory);
    }

    public static void getBeanByIdInRealTime(BeanFactory beanFactory) {
        User user = (User)beanFactory.getBean("user");
        System.out.println("根据ID实时获取Bean:" + user);
    }

    public static void getBeanByTypeInRealTime(BeanFactory beanFactory) {
        User user = (User)beanFactory.getBean(User.class);
        System.out.println("根据类型实时获取Bean:" + user);
    }

    public static void getBeanByIDInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory)beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("根据ID延迟获取Bean:" + user);
    }

    public static void getCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(beansOfType);
        }
    }

    public static void getCollectionByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> beansOfType = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println(beansOfType);
        }
    }
}
