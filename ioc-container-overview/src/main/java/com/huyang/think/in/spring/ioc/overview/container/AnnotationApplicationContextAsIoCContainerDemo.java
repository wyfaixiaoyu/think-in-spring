package com.huyang.think.in.spring.ioc.overview.container;

import com.huyang.think.in.spring.ioc.overview.dependency.lookup.DependencyLookupDemo;
import com.huyang.think.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class AnnotationApplicationContextAsIoCContainerDemo {

    public static void main(String[] args) {
        //创建BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前类  AnnotationApplicationContextAsIoCContainerDemo 作为配置类 （Configuration Class）
        applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class);
        applicationContext.refresh();
        DependencyLookupDemo.getCollectionByType(applicationContext);
    }

    /**
     * 通过java注解的方式，定义了一个Bean
     * @return
     */
    @Bean
    public User user() {
        User user = new User();
        user.setId(123L);
        user.setName("哈哈");
        return user;
    }
}
