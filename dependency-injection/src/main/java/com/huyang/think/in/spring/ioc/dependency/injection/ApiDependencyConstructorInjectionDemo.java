package com.huyang.think.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApiDependencyConstructorInjectionDemo {
    public static void main(String[] args) {
        //创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        BeanDefinition userHoulderBeanDefinition = createUserHolderBeanDefinition();

        applicationContext.registerBeanDefinition("userHolder", userHoulderBeanDefinition);


        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        beanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/dependency-setter-injection-context.xml");

        //启动应用上下文
        applicationContext.refresh();

        UserHolder userHolder = (UserHolder)applicationContext.getBean("userHolder");

        System.out.println(userHolder);

        //显示关闭Spring应用上下文
        applicationContext.close();

    }

    private static BeanDefinition createUserHolderBeanDefinition() {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        builder.addConstructorArgReference("superUser");
        return builder.getBeanDefinition();
    }
}
