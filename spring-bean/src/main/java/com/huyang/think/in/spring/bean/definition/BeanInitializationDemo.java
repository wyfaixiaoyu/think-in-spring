package com.huyang.think.in.spring.bean.definition;

import com.huyang.think.in.spring.bean.factory.DefaultUserFactory;
import com.huyang.think.in.spring.bean.factory.UserFactory;
import com.huyang.think.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration //Configuration Class
public class BeanInitializationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册 Configuration Class(配置类)
        applicationContext.register(BeanInitializationDemo.class);

        //启动应用上下文
        applicationContext.refresh();

        //非延迟初始化在Spring 应用上下文启动完成后，被初始化
        System.out.println("Spring 应用上下文已启动...");

        //依赖查找
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println(userFactory);

        System.out.println("Spring 应用上下文准备关闭...");

        //显示关闭Spring应用上下文
        applicationContext.close();

        System.out.println("Spring 应用上下文已关闭...");
    }

    @Bean(initMethod = "initUserFactory", destroyMethod = "doDestroy")
    @Lazy(value = false)
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }
}
