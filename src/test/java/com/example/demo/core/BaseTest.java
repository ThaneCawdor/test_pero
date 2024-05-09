package com.example.demo.core;

import com.codeborne.selenide.WebDriverRunner;
import com.example.demo.configuration.Constants;
import com.example.demo.configuration.DriverConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeAll
    public static void setUp() {
        log.info("Setting up driver configuration...");
        DriverConfiguration.setUpDriverConfiguration(Constants.CHROME);
    }

    @AfterAll
    public static void tearDown() {
        log.info("Tearing down driver session...");
        WebDriverRunner.closeWebDriver();
    }


}


