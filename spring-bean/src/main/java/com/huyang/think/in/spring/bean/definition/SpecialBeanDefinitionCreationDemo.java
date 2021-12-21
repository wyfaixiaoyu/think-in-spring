package com.huyang.think.in.spring.bean.definition;

import com.huyang.think.in.spring.bean.factory.DefaultUserFactory;
import com.huyang.think.in.spring.bean.factory.UserFactory;
import com.huyang.think.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpecialBeanDefinitionCreationDemo {
    public static void main(String[] args) {
        //serviceLoadDemo(ServiceLoader.load(UserFactory.class));

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-creation-context.xml");
        ServiceLoader<UserFactory> userFactoryServiceLoader = applicationContext.getBean("userFactoryServiceLoader", ServiceLoader.class);

        serviceLoadDemo(userFactoryServiceLoader);


        AutowireCapableBeanFactory capableBeanFactory = applicationContext.getAutowireCapableBeanFactory();

        UserFactory userFactory = capableBeanFactory.createBean(DefaultUserFactory.class);
        System.out.println(userFactory);

        System.out.println("UserFactory 类型的所有Beans:" + applicationContext.getBeansOfType(UserFactory.class));
    }

    public static void serviceLoadDemo(ServiceLoader<UserFactory> serviceLoader) {
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactory userFactory = iterator.next();
            System.out.println("serviceLoader：" + userFactory.createUser());
        }
    }
}
