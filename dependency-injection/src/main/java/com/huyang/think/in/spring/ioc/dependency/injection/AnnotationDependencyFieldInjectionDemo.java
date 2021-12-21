package com.huyang.think.in.spring.ioc.dependency.injection;

import com.huyang.think.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;

public class AnnotationDependencyFieldInjectionDemo {
    @Autowired
    private UserHolder userHolder;

    @Resource
    private UserHolder userHolder2;

    public static void main(String[] args) {
        //创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册 Configuration Class(配置类)
        applicationContext.register(AnnotationDependencyFieldInjectionDemo.class);

        //启动应用上下文
        applicationContext.refresh();

        AnnotationDependencyFieldInjectionDemo annotationDependencyFieldInjectionDemo = applicationContext.getBean(AnnotationDependencyFieldInjectionDemo.class);

        System.out.println(annotationDependencyFieldInjectionDemo.userHolder);
        System.out.println(annotationDependencyFieldInjectionDemo.userHolder2);
        System.out.println(annotationDependencyFieldInjectionDemo.userHolder == annotationDependencyFieldInjectionDemo.userHolder2);

        //显示关闭Spring应用上下文
        applicationContext.close();

    }

    @Bean
    public UserHolder userHolder67() {
        User user = new User();
        user.setId(9090L);
        user.setName("James");
        return new UserHolder(user);
    }
}
