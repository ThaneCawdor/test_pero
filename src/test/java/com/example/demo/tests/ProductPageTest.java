package com.example.demo.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.example.demo.core.BaseTest;
import com.example.demo.pages.LoginPage;
import com.example.demo.pages.MarketPage;
import com.example.demo.pages.ProductPage;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.example.demo.configuration.Constants.*;

@Feature("тесты на функциональность карточки товара из неавторизованной зоны")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductPageTest extends BaseTest {

    ProductPage productPage;
    LoginPage loginPage;
    MarketPage marketPage;

    @BeforeEach
    public void preconditions() {
        Selenide.open(PRODUCT_PAGE_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        productPage = new ProductPage();
        loginPage = new LoginPage();
        marketPage = new MarketPage();

    }

    @DisplayName("Переход на страницу логина после нажатия кнопки Написать")
    @Test
    public void checkButtonToWrite() {
        productPage.clickButtonToWrite().waitForElementToBePresent(loginPage.getButtonLogin());
        Assertions.assertThat(loginPage.getCurrentUrl()).startsWith(LOGIN_URL);

    }

    @DisplayName("Переход на страницу логина после нажатия кнопки Подписаться")
    @Test
    public void checkButtonSubscribe() {
        productPage.clickButtonSubscribe().waitForElementToBePresent(loginPage.getButtonLogin());
        Assertions.assertThat(loginPage.getCurrentUrl()).startsWith(LOGIN_URL);
    }

    @DisplayName("Переход на страницу логина после нажатия на знак +")
    @Test
    public void checkButtonSubscribeMethod2() {
        productPage.clickButtonSubscribeMethod2().waitForElementToBePresent(loginPage.getButtonLogin());
        Assertions.assertThat(loginPage.getCurrentUrl()).startsWith(LOGIN_URL);
    }

    @DisplayName("Переход на страницу магазина после нажатия кнопки Перейти в магазин")
    @Test
    public void checkButtonGoToTheStore() {

        productPage.clickButtonGoToTheStore().waitForElementToBePresent(marketPage.getCheckServices());
        Assertions.assertThat(marketPage.getCurrentUrl()).startsWith(MARKET_PAGE_URL);

    }

    @DisplayName("Переход на страницу логина после нажатия кнопки нравится")
    @Test
    public void checkButtonLike() {
        productPage.clickButtonLike().waitForElementToBePresent(loginPage.getButtonLogin());
        Assertions.assertThat(loginPage.getCurrentUrl()).startsWith(LOGIN_URL);
    }

    @DisplayName("Переход на страницу логина после нажатия кнопки скопировать ссылку")
    @Test
    public void checkButtonCopyUrl() {
        productPage.clickButtonCopyUrl().waitForElementToBePresent(loginPage.getButtonLogin());
        Assertions.assertThat(loginPage.getCurrentUrl()).startsWith(LOGIN_URL);
    }

    @DisplayName("Переход на страницу логина после нажатия кнопки в закладки")
    @Test
    public void checkButtonFavorite() {
        productPage.clickButtonFavorite().waitForElementToBePresent(loginPage.getButtonLogin());
        Assertions.assertThat(loginPage.getCurrentUrl()).startsWith(LOGIN_URL);
    }

    @DisplayName("Переход на страницу логина после нажатия кнопки в желания")
    @Test
    public void checkButtonWishList() {
        productPage.clickButtonWishList().waitForElementToBePresent(loginPage.getButtonLogin());
        Assertions.assertThat(loginPage.getCurrentUrl()).startsWith(LOGIN_URL);
    }

    @DisplayName("Проверка сообщения после нажатия кнопки поделиться")
    @Test
    public void checkButtonShare() {
        String text = productPage.checkTextUnauthorizedShare();
        Assertions.assertThat(text).isEqualTo(MESSAGE_FOR_BUTTON_SHARE);
    }

    @DisplayName("Проверка сообщения после нажатия на подать жалобу")
    @Test
    public void checkComplain() {
        String text = productPage.checkErrorMessageComplain();
        Assertions.assertThat(text).isEqualTo(ERROR_MESSAGE_FOR_COMPLAIN);
    }
}
