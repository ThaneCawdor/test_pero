package com.example.demo.core;

import com.codeborne.selenide.WebDriverRunner;
import com.example.demo.configuration.Constants;
import com.example.demo.configuration.DriverConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        DriverConfiguration.setUpDriverConfiguration(Constants.CHROME);
    }

    @AfterAll
    public static void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

}
