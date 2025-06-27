package com.epam.training.olha_diatlova.final_task.framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class DriverSingleton {
    private static final Logger logger = LoggerFactory.getLogger(DriverSingleton.class);
    private static Map<String, WebDriver> driverMap = new HashMap<>();

    public static WebDriver getDriver(String browser, String testName) {
        if (driverMap.get(testName) == null) {
            WebDriver driver;
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    logger.info("Chrome driver was created");
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    logger.info("Firefox driver was created");
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    logger.info("Edge driver was created");
                    break;
                default:
                    throw new IllegalArgumentException("Unknown browser: " + browser);
            }
            driverMap.put(testName, driver);
            logger.info("Driver cached for test: " + testName);
        }
        return driverMap.get(testName);
    }

    public static void closeDriver(String testName){
        logger.info("Close driver for test: " + testName);
        driverMap.get(testName).quit();
        driverMap.put(testName, null);
    }

}
