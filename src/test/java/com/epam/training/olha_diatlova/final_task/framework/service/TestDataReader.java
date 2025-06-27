package com.epam.training.olha_diatlova.final_task.framework.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment", "qa"));

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
