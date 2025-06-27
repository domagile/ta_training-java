package com.epam.training.olha_diatlova.final_task.framework.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class LoginPage extends BasePage {
    public static final String URL = "https://www.saucedemo.com/";

    public static final String ERROR_USERNAME_REQUIRED = "Username is required";
    public static final String ERROR_PASSWORD_REQUIRED = "Password is required";


    private final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(xpath = "//input[@class = 'input_error form_input' and @id = 'user-name']")
    private WebElement usernameField;

    //@FindBy(id = "password")
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    //@FindBy(id = "login-button")
    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage() {
        driver.get(URL);
        logger.info("Login page opened");
        return this;
    }

    public LoginPage setUsername(String username) {
        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public ProductPage loginExpectingSuccess() {
        loginButton.click();
        logger.info("Login successful, navigating to ProductPage");
        return new ProductPage(driver);
    }

    public LoginPage loginExpectingFailure() {
        loginButton.click();
        logger.info("Login failed, staying on LoginPage");
        return this;
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public LoginPage clearUsername() {
        usernameField.click();
        usernameField.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        waitUntilValueEmpty(usernameField);
        return this;
    }

    public LoginPage clearPassword() {
        passwordField.click();
        passwordField.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        waitUntilValueEmpty(passwordField);
        return this;
    }

    private void waitUntilValueEmpty(WebElement field) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(driver -> field.getAttribute("value").isEmpty());
    }
}
