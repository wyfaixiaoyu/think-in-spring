package com.huyang.think.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class AwareInterfaceDependencyInjectionDemo implements BeanNameAware {
    public static void main(String[] args) {
        //创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册 Configuration Class(配置类)
        applicationContext.register(AwareInterfaceDependencyInjectionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        beanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/dependency-setter-injection-context.xml");

        //启动应用上下文
        applicationContext.refresh();

        //显示关闭Spring应用上下文
        applicationContext.close();

    }

    @Override
    public void setBeanName(String name) {
        System.out.println(name);
    }

    @Bean
    public UserHolder userHolder123() {
        return new UserHolder();
    }
}
