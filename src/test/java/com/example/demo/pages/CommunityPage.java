package com.example.demo.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.example.demo.core.BasePage;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$x;

public class CommunityPage extends BasePage {
    private final SelenideElement buttonSubscribe = $x("//span[@class='FlatButton__content' and text()='Подписаться']");
    private final SelenideElement detailedInformation = $x("//a[@class='groups-redesigned-info-more']");
    private final SelenideElement subscribers = $x("//span[@class='header_label fl_l' and text()='Подписчики']");
    private final SelenideElement contacts = $x("//span[@class='header_label fl_l' and text()='Контакты']");
    private final SelenideElement showAll = $x("//span[@class='FlatButton__content' and text()='Показать все 1']");
    private final SelenideElement product = $x("//a[@data-testid='product_card_picture']");
    private final SelenideElement allEntries = $x("//span[text()='Все записи']");
    private final SelenideElement communityPosts = $x("//span[text()='Записи сообщества']");
    private final SelenideElement search = $x("//span[@class='ui_tab_search_icon']");
    private final SelenideElement inputText = $x("//input[@type='text' and @class='ui_search_field _field']");

    private final SelenideElement dataCreation = $x("//div[starts-with(@class, \"NameHistoryShortCell\")]/following-sibling::div");
    private final SelenideElement boxContacts = $x("//div[@data-testid='box_layout']");
    private final SelenideElement noRows = $x("//div[@class='page_block no_rows']");
    private final SelenideElement buttonBackCommunityPage = $x("//div[@class='ui_ownblock_hint']");

    Actions actions = new Actions(WebDriverRunner.getWebDriver());


    public LoginPage subscribe() {
        buttonSubscribe.click();
        return new LoginPage();
    }

    public String getDateCreateCommunity() {
        detailedInformation.click();
        return dataCreation.getText();
    }

    public LoginPage showSubscribers() {
        subscribers.click();
        return new LoginPage();
    }

    public Boolean showContacts() {
        contacts.click();
        return boxContacts.isDisplayed();
    }

    public MarketPage showAll() {
        showAll.click();
        return new MarketPage();
    }

    public ProductPage showProduct() {
        product.click();
        return new ProductPage();
    }

    public String searchByRecordsCommunityPosts() {
        communityPosts.click();
        search.click();
        inputText.sendKeys("test");
        inputText.pressEnter();
        return noRows.getText();

    }

    public String searchByRecordsAllEntries() {
        search.click();
        inputText.sendKeys("test");
        inputText.pressEnter();
        return noRows.getText();

    }

    public CommunityPage checkButtonBack() {
        actions.doubleClick(allEntries).build().perform();
        buttonBackCommunityPage.click();
        return this;
    }

    public String checkMessageForVoidSearch() {
        actions.doubleClick(allEntries).build().perform();
        return noRows.getText();
    }

    public SelenideElement getButtonSubscribe() {
        return buttonSubscribe;
    }
}
