package com.huyang.think.in.spring.bean.factory;

import com.huyang.think.in.spring.ioc.overview.domain.User;

public interface UserFactory {
    default User createUser() {
        return User.createUser();
    }
}
