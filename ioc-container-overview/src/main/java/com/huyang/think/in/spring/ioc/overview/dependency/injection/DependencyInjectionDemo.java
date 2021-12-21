package com.huyang.think.in.spring.ioc.overview.dependency.injection;

import com.huyang.think.in.spring.ioc.overview.domain.User;
import com.huyang.think.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DependencyInjectionDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");


        UserRepository userRepository = (UserRepository)beanFactory.getBean("userRepository");
        System.out.println(userRepository);

        UserRepository userRepository1 = (UserRepository)beanFactory.getBean("userRepository2");
        System.out.println(userRepository1);

        //依赖注入
        System.out.println(userRepository1.getBeanFactory() == beanFactory);
        System.out.println(userRepository1.getBeanFactory());
        System.out.println(beanFactory);

        UserRepository userRepository2 = (UserRepository)userRepository1.getBeanFactory().getBean("userRepository2");
        System.out.println(userRepository1 == userRepository2);


        //依赖查找 (错误)
        //System.out.println(beanFactory.getBean(BeanFactory.class));

        ObjectFactory<User> userObjectFactory = userRepository1.getUserObjectFactory();
        User user = userObjectFactory.getObject();
        System.out.println(user);

        ObjectFactory<ApplicationContext> objectFactory = userRepository1.getObjectFactory();
        ApplicationContext applicationContext = objectFactory.getObject();
        System.out.println(applicationContext);
        System.out.println(applicationContext == beanFactory);
    }
}
