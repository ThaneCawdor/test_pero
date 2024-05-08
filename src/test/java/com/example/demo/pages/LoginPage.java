package com.example.demo.pages;

import com.codeborne.selenide.SelenideElement;
import com.example.demo.core.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private final SelenideElement buttonLogin = $x("//span[@class='FlatButton__content' and text()='Войти']");

    public SelenideElement getButtonLogin() {
        return buttonLogin;
    }
}
