package com.huyang.think.in.spring.bean.definition;

import com.huyang.think.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;


@Import(AnnotationBeanDefinitionDemo.Config.class) //通过@Import来进行导入
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册 Configuration Class(配置类)
        //注解的三个方式
        //1.通过 @Bean方式定义
        //2.通过@Component 方式
        //3.通过@Import来进行导入
        applicationContext.register(Config.class);


        //Java API的方式
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 1234L)
                .addPropertyValue("name", "james");
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        //1.命名方式
        applicationContext.registerBeanDefinition("james", beanDefinition);
        //2.非命名方式
        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, applicationContext);

        //启动应用上下文
        applicationContext.refresh();


        //按照类型依赖查找
        System.out.println("Config 类型的所有Beans:" + applicationContext.getBeansOfType(Config.class));
        System.out.println("User 类型的所有Beans:" + applicationContext.getBeansOfType(User.class));

        //显示关闭Spring应用上下文
        applicationContext.close();

    }



    @Component //定义当前类作为 Spring Bean（组件）
    public static class Config{
        @Bean(name = {"user1", "user2"})
        public User user() {
            User user = new User();
            user.setId(123L);
            user.setName("胡杨");
            return user;
        }
    }
}
