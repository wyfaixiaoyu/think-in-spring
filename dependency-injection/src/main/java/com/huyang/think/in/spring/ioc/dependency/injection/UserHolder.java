package com.huyang.think.in.spring.ioc.dependency.injection;

import com.huyang.think.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanNameAware;

public class UserHolder implements BeanNameAware {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserHolder() {

    }

    public UserHolder(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }

    @Override
    public void setBeanName(String name) {
        System.out.println(name);
    }
}
