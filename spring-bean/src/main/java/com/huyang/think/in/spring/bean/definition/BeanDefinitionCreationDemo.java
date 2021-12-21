package com.huyang.think.in.spring.bean.definition;

import com.huyang.think.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {
        //1.通过BeanDefinitionBuilder构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //属性设置
        beanDefinitionBuilder.addPropertyValue("id", 123L)
                .addPropertyValue("name", "胡杨");

        //获取BeanDefinition实例
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        //并非Bean终态，可以自定义修改
        beanDefinition.setLazyInit(true);

        //2.通过AbstractBeanDefinition 以及派生类构建
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        //设置Bean 类型
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id", 124L)
                .add("name", "胡杨");
        genericBeanDefinition.setPropertyValues(propertyValues);
    }
}
