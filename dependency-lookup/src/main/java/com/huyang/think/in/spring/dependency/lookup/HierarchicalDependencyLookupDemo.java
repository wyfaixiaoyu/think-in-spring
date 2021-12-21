package com.huyang.think.in.spring.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class HierarchicalDependencyLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ObjectProviderDemo.class);

        //1.获取HierarchicalBeanFactory <- ConfigurableBeanFactory <- ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        System.out.println("当前 BeanFactory 的 Parent BeanFactory：" + beanFactory.getParentBeanFactory());


        //2.设置 Parent BeanFactory
        HierarchicalBeanFactory parentFactory = createParentFactory();
        beanFactory.setParentBeanFactory(parentFactory);
        System.out.println("当前 BeanFactory 的 Parent BeanFactory：" + beanFactory.getParentBeanFactory());

        displayContainsLocalBean(beanFactory, "user");
        displayContainsLocalBean(parentFactory, "user");

        displayContainsBean(beanFactory, "user");
        displayContainsBean(parentFactory, "user");

        //启动应用上下文
        applicationContext.refresh();

        //显示关闭Spring应用上下文
        applicationContext.close();
    }

    private static void displayContainsBean(HierarchicalBeanFactory beanFactory, String beanName) {
        System.out.printf("当前 BeanFactory[%s] 是否包含bean[name : %s] : %s\n", beanFactory, beanName, containsBean(beanFactory, beanName));
    }

    private static boolean containsBean(HierarchicalBeanFactory beanFactory, String beanName) {
        BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
        if (parentBeanFactory instanceof HierarchicalBeanFactory) {
            HierarchicalBeanFactory parentHierarchicalBeanFactory = (HierarchicalBeanFactory)parentBeanFactory;
            if (parentHierarchicalBeanFactory.containsBean(beanName)) {
                return true;
            }
        }
        return beanFactory.containsLocalBean(beanName);
    }


    private static void displayContainsLocalBean(HierarchicalBeanFactory beanFactory, String beanName) {
        System.out.printf("当前 BeanFactory[%s] 是否包含bean[name : %s] : %s\n", beanFactory, beanName, beanFactory.containsLocalBean(beanName));
    }

    private static HierarchicalBeanFactory createParentFactory() {
        //创建BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        //XML 配置文件ClassPath路径
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        //加载配置
        xmlBeanDefinitionReader.loadBeanDefinitions(location);

        return beanFactory;
    }
}
