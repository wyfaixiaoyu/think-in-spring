package com.huyang.think.in.spring.bean.factory;

import com.huyang.think.in.spring.ioc.overview.domain.User;

public class SpecialUserFactory implements UserFactory{
    public User createUser() {
        User user = User.createUser();
        user.setId(2345L);
        return user;
    }
}
