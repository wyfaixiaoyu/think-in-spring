package com.huyang.think.in.spring.ioc.overview.domain;

public class User {
    private Long id;
    private String name;
    private Dog dog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }

    public static User createUser() {
        User user = new User();
        user.setId(8989L);
        user.setName("createUser");
        return user;
    }
}
