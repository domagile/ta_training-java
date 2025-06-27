package com.epam.training.olha_diatlova.final_task.tests;

import com.epam.training.olha_diatlova.final_task.framework.driver.DriverSingleton;

import com.epam.training.olha_diatlova.final_task.framework.screenshots.AutoScreenshotExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    @RegisterExtension
    AutoScreenshotExtension screenshotManager = new AutoScreenshotExtension(
            context -> DriverSingleton.getDriver(System.getProperty("browser", "chrome"), context.getDisplayName()));

    @BeforeEach
    void setUp(TestInfo testInfo) {
        String browser = System.getProperty("browser", "chrome");
        driver = DriverSingleton.getDriver(browser, testInfo.getDisplayName());

        driver.manage().window().maximize();
    }

    @AfterEach
    public void stopBrowser(TestInfo testInfo){
        DriverSingleton.closeDriver(testInfo.getDisplayName());
    }
}
