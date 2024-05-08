package com.example.demo.configuration;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import static com.example.demo.configuration.Constants.CHROME;
import static com.example.demo.configuration.Constants.FIREFOX;

public class DriverConfiguration {

    public static void setUpDriverConfiguration(String driverType) {
        Configuration.browserSize = Constants.BROWSER_SIZE;
        Configuration.headless = Constants.HEADLESS_MODE;
        Configuration.timeout = Constants.TIMEOUT;
        Configuration.downloadsFolder = Constants.DOWNLOAD_FOLDER;

        switch (driverType) {
            case CHROME -> {
                Configuration.browser = Constants.CHROME_DRIVER;
                Configuration.browserCapabilities = new ChromeOptions()
                        .addArguments(Constants.ENABLE_AUTOMATION)
                        .addArguments(Constants.REMOTE_ALLOW_ORIGINS)
                        .addArguments(Constants.NO_SANDBOX)
                        .addArguments(Constants.DISABLE_DEV_SHM_USAGE)
                        .addArguments(Constants.DISABLE_NOTIFICATIONS)
                        .addArguments(Constants.DISABLE_GPU)
                        .addArguments(Constants.DISABLE_WEB_SECURITY)
                        .addArguments(Constants.IGNORE_CERTIFICATE_ERRORS)
                        .addArguments(Constants.SILENT)
                        .addArguments(Constants.INCOGNITO_MODE_ON)
                        .setAcceptInsecureCerts(true);
            }
            case FIREFOX -> {
                Configuration.browser = Constants.FIREFOX_DRIVER;
                Configuration.browserCapabilities = new FirefoxOptions()
                        .addArguments(Constants.ENABLE_AUTOMATION)
                        .addArguments(Constants.NO_SANDBOX)
                        .addArguments(Constants.DISABLE_DEV_SHM_USAGE)
                        .addArguments(Constants.DISABLE_NOTIFICATIONS)
                        .addArguments(Constants.DISABLE_GPU)
                        .addArguments(Constants.DISABLE_WEB_SECURITY)
                        .addArguments(Constants.IGNORE_CERTIFICATE_ERRORS)
                        .addArguments(Constants.SILENT);
            }

            default -> throw new IllegalArgumentException("DriverType [" + driverType + "] is not supported.");
        }
    }

}
