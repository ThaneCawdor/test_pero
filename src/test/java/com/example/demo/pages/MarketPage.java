package com.example.demo.pages;

import com.codeborne.selenide.SelenideElement;
import com.example.demo.core.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class MarketPage extends BasePage {
    private final SelenideElement checkServices = $x("//div[@data-testid='header' and text()='Все услуги']");

    public SelenideElement getCheckServices() {
        return checkServices;
    }
}
