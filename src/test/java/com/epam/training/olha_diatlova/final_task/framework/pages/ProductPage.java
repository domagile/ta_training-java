package com.epam.training.olha_diatlova.final_task.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    public static final String HEADER_LABEL = "Swag Labs";

    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement appLogo;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getAppLogoText() {
        return appLogo.getText();
    }
}
