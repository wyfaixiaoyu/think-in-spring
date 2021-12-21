package com.huyang.think.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class AutoWiringByTypeDependencySetterInjectionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/autowiring-dependency-setter-injection-context.xml");

        UserHolder userHolder = (UserHolder)beanFactory.getBean("userHolderAutowiringByType");
        System.out.println(userHolder);
    }
}
