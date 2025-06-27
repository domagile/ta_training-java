package com.epam.training.olha_diatlova.final_task.tests;

import com.epam.training.olha_diatlova.final_task.framework.model.User;
import com.epam.training.olha_diatlova.final_task.framework.pages.LoginPage;
import com.epam.training.olha_diatlova.final_task.framework.pages.ProductPage;
import com.epam.training.olha_diatlova.final_task.framework.service.UserCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class LoginTests extends BaseTest {

    @DisplayName("UC-1: Error shown when login and password are empty")
    @Test
    void errorDisplayedWhenLoginAndPasswordEmptyTest() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String actualErrorMessage = new LoginPage(driver)
                .openPage()
                .setUsername(testUser.getUsername())
                .setPassword(testUser.getPassword())
                .clearUsername()
                .clearPassword()
                .loginExpectingFailure()
                .getErrorMessage();

        //contains is used because message is "Epic sadface: Username is required"
        assertThat(actualErrorMessage, containsString(LoginPage.ERROR_USERNAME_REQUIRED));
    }

    @DisplayName("UC-2: Error shown when password are empty")
    @Test
    void errorDisplayedWhenPasswordIsEmptyTest() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String actualErrorMessage = new LoginPage(driver)
                .openPage()
                .setUsername(testUser.getUsername())
                .setPassword(testUser.getPassword())
                .clearPassword()
                .loginExpectingFailure()
                .getErrorMessage();

        assertThat(actualErrorMessage, containsString(LoginPage.ERROR_PASSWORD_REQUIRED));
    }

    @DisplayName("UC-3: Log in with valid credentials")
    @Test
    void successfulLoginWithValidCredentialsTest() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String actualLogoText = new LoginPage(driver)
                .openPage()
                .setUsername(testUser.getUsername())
                .setPassword(testUser.getPassword())
                .loginExpectingSuccess()
                .getAppLogoText();

        assertThat(actualLogoText, equalTo(ProductPage.HEADER_LABEL));
    }
}
