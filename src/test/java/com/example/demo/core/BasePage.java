package com.example.demo.core;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

public class BasePage {

    public void openPage(String url) {
        Selenide.open(url);
    }

    public String getTitle() {
        return Selenide.title();
    }

    public String getCurrentUrl() {
        return WebDriverRunner.url();
    }


    public void waitForElementToBeVisible(SelenideElement element) {
        element.shouldBe(Condition.visible);
    }

    public void waitForElementToBePresent(SelenideElement element) {
        element.shouldBe(Condition.exist);
    }

    public void click(SelenideElement element) {
        element.click();
    }

    public void setText(SelenideElement element, String text) {
        element.setValue(text);
    }

    public String getText(SelenideElement element) {
        return element.getText();
    }
}
