package com.epam.training.olha_diatlova.final_task.framework.service;

import com.epam.training.olha_diatlova.final_task.framework.model.User;

public class UserCreator {
    private static final String USER_NAME_KEY = "testdata.user.name";
    private static final String USER_PASSWORD_KEY = "testdata.user.password";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(USER_NAME_KEY), TestDataReader.getTestData(USER_PASSWORD_KEY));
    }

    public static User withEmptyUsername(){
        return new User("", TestDataReader.getTestData(USER_PASSWORD_KEY));
    }

    public static User withEmptyPassword(){
        return new User(TestDataReader.getTestData(USER_NAME_KEY), "");
    }
}
