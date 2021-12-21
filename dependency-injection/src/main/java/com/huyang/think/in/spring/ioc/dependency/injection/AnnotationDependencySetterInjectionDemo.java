package com.huyang.think.in.spring.ioc.dependency.injection;

import com.huyang.think.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class AnnotationDependencySetterInjectionDemo {
    public static void main(String[] args) {
        //创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册 Configuration Class(配置类)
        applicationContext.register(AnnotationDependencySetterInjectionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        beanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/dependency-setter-injection-context.xml");

        //启动应用上下文
        applicationContext.refresh();

        UserHolder userHolder = (UserHolder)applicationContext.getBean("userHolder");

        System.out.println(userHolder);

        //显示关闭Spring应用上下文
        applicationContext.close();

    }

    @Bean
    public UserHolder userHolder(User user) {
        user.setId(9090L);
        UserHolder userHolder = new UserHolder();
        userHolder.setUser(user);
        return userHolder;
    }
}
