package br.com.edu.unit_tests.builders;

import java.lang.String;

import br.com.edu.unit_tests.rent.entity.User;


public class UserBuilder {

    private User user;

    private UserBuilder() {
    }

    public static UserBuilder oneUser() {
        UserBuilder builder = new UserBuilder();
        withDefault(builder);
        return builder;
    }

    public static void withDefault(UserBuilder builder) {
        builder.user = new User();
        User user = builder.user;
        user.setNome("");
    }

    public UserBuilder withName(String param) {
        user.setNome(param);
        return this;
    }

    public User now() {
        return user;
    }
}
