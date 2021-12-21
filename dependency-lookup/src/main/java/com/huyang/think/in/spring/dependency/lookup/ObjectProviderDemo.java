package com.huyang.think.in.spring.dependency.lookup;

import com.huyang.think.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class ObjectProviderDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ObjectProviderDemo.class);

        //启动应用上下文
        applicationContext.refresh();

        lookypByObjectProvider(applicationContext);

        lookupIfAvailable(applicationContext);

        lookupByStreamOps(applicationContext);

        //显示关闭Spring应用上下文
        applicationContext.close();
    }

    private static void lookupByStreamOps(AnnotationConfigApplicationContext applicationContext) {
        applicationContext.getBeanProvider(String.class).stream().forEach(System.out::println);
    }

    private static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> beanProvider = applicationContext.getBeanProvider(User.class);

        User user = beanProvider.getIfAvailable(() -> {
                User user1 = User.createUser();
                user1.setName("hello, dog");
                return user1;
        });

        System.out.println(user);
    }

    @Bean
    @Primary
    public String helloWorld() {
        return "Hello,World";
    }

    @Bean
    public String message() {
        return "Hello,message";
    }

    private static void lookypByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        applicationContext.getBeanFactory();
        System.out.println(beanProvider.getObject());

    }

}
