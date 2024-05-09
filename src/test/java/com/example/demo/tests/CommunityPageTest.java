package com.example.demo.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.example.demo.configuration.Constants;
import com.example.demo.core.BaseTest;
import com.example.demo.pages.CommunityPage;
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

@Feature("тесты на функциональность главной страницы сообщества из неавторизованной зоны")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CommunityPageTest extends BaseTest {

    ProductPage productPage;
    LoginPage loginPage;
    MarketPage marketPage;
    CommunityPage communityPage;

    @BeforeEach
    public void preconditions() {
        Selenide.open(COMMUNITY_PAGE_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        communityPage = new CommunityPage();
        productPage = new ProductPage();
        loginPage = new LoginPage();
        marketPage = new MarketPage();

    }

    @DisplayName("Переход на страницу логина после нажатия на кнопку Подписаться")
    @Test
    public void checkButtonSubscribe() {
        communityPage.subscribe().waitForElementToBePresent(loginPage.getButtonLogin());
        Assertions.assertThat(loginPage.getCurrentUrl()).startsWith(LOGIN_URL);
    }

    @DisplayName("Проверка даты создания сообщества")
    @Test
    public void checkDateCreationCommunity() {
        String date = communityPage.getDateCreateCommunity();
        Assertions.assertThat(date).isEqualTo(Constants.COMMUNITY_CREATION_DATE);
    }

    @DisplayName("Переход на страницу логина после нажатия на Подписчиков")
    @Test
    public void seeSubscribes() {
        communityPage.showSubscribers().waitForElementToBePresent(loginPage.getButtonLogin());
        Assertions.assertThat(loginPage.getCurrentUrl()).startsWith(LOGIN_URL);
    }

    @DisplayName("Просмотр контактов")
    @Test
    public void seeContacts() {
        Assertions.assertThat(communityPage.showContacts()).isTrue();
    }

    @DisplayName("Переход на страницу магазина")
    @Test
    public void showAllServices() {
        communityPage.showAll().waitForElementToBePresent(marketPage.getCheckServices());
        Assertions.assertThat(marketPage.getCurrentUrl()).startsWith(MARKET_PAGE_URL);
    }

    @DisplayName("Посмотреть карточку товара")
    @Test
    public void seeProducts() {
        communityPage.showProduct().waitForElementToBePresent(productPage.getBoxItem());
        Assertions.assertThat(productPage.getCurrentUrl()).startsWith(PRODUCT_PAGE_URL);

    }

    @DisplayName("Поиск по записям сообщества")
    @Test
    public void searchByRecordsCom() {
        String resultSearch = communityPage.searchByRecordsCommunityPosts();
        Assertions.assertThat(resultSearch).isEqualTo(MESSAGE_FOR_VOID_SEARCH);
    }

    @DisplayName("Поиск по всем записям")
    @Test
    public void searchByRecordsAll() {
        String resultSearch = communityPage.searchByRecordsAllEntries();
        Assertions.assertThat(resultSearch).isEqualTo(MESSAGE_FOR_VOID_SEARCH);
    }

    @DisplayName("Проверка кнопки назад")
    @Test
    public void checkButtonBack() {
        communityPage.checkButtonBack().waitForElementToBePresent(communityPage.getButtonSubscribe());
        Assertions.assertThat(communityPage.getCurrentUrl()).isEqualTo(COMMUNITY_PAGE_URL);
    }

    @DisplayName("Проверка сообщения о поиске")
    @Test
    public void checkMessageForVoidSearch() {
        Assertions.assertThat(communityPage.checkMessageForVoidSearch()).isEqualTo(MESSAGE_FOR_VOID_SEARCH_VAR_2);
    }


}
