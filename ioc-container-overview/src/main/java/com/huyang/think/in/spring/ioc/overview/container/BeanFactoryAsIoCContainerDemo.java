package com.huyang.think.in.spring.ioc.overview.container;

import com.huyang.think.in.spring.ioc.overview.dependency.lookup.DependencyLookupDemo;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class BeanFactoryAsIoCContainerDemo {
    public static void main(String[] args) {
        //创建BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //XML 配置文件ClassPath路径
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        //加载配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        int beanDefinitionsCount = xmlBeanDefinitionReader.loadBeanDefinitions(location);
        System.out.println(beanDefinitionsCount);

        DependencyLookupDemo.getCollectionByType(beanFactory);
    }
}
