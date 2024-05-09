package com.example.demo.core;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

public class BasePage {


    public String getCurrentUrl() {
        return WebDriverRunner.url();
    }


    public void waitForElementToBePresent(SelenideElement element) {
        element.shouldBe(Condition.exist);
    }

}
