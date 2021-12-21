package com.huyang.think.in.spring.ioc.dependency.injection;

import com.huyang.think.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

public class AnnotationDependencyMethodInjectionDemo {
    private UserHolder userHolder1;

    private UserHolder userHolder2;

    private UserHolder userHolder3;

    @Autowired
    public void init1(UserHolder u1) {
        this.userHolder1 = u1;
    }

    @Resource
    public void init2(UserHolder u2) {
        this.userHolder2 = u2;
    }

    @Bean
    public Integer init3(UserHolder u3) {
        this.userHolder3 = u3;
        return Integer.valueOf(0);
    }

    public static void main(String[] args) {
        //创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册 Configuration Class(配置类)
        applicationContext.register(AnnotationDependencyMethodInjectionDemo.class);

        //启动应用上下文
        applicationContext.refresh();

        AnnotationDependencyMethodInjectionDemo annotationDependencyFieldInjectionDemo = applicationContext.getBean(AnnotationDependencyMethodInjectionDemo.class);

        System.out.println(annotationDependencyFieldInjectionDemo.userHolder1);
        System.out.println(annotationDependencyFieldInjectionDemo.userHolder2);
        System.out.println(annotationDependencyFieldInjectionDemo.userHolder3);
        System.out.println(annotationDependencyFieldInjectionDemo.userHolder1 == annotationDependencyFieldInjectionDemo.userHolder2);

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
