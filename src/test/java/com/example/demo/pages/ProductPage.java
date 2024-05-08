package com.example.demo.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.example.demo.core.BasePage;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class ProductPage extends BasePage {

    private final SelenideElement buttonToWrite = $x("//span[@class='MarketServiceButton__text']");
    private final SelenideElement buttonSubscribe = $x("//span[@class='vkuiButton__content' and text()='Подписаться']");
    private final SelenideElement buttonSubscribeMethod2 = $x("//div[@class='ItemCardLayout__content']/preceding-sibling::div/div[3]/button");

    private final SelenideElement buttonGoToTheStore = $x("//span[@class='vkuiButton__content' and text()='Перейти в магазин']");

    private final SelenideElement buttonLike = $x("//button[@data-action-name='like']");

    private final SelenideElement buttonShare = $x("//button[@data-action-name='share']");

    private final SelenideElement buttonCopyUrl = $x("//button[@data-action-name='copyUrl']");
    private final SelenideElement buttonFavorite = $x("//button[@data-action-name='favorite']");
    private final SelenideElement buttonWishList = $x("//button[@data-action-name='wishlist']");

    private final SelenideElement buttonMore = $x("//div[@data-testid='actions_dd_new']");
    private final SelenideElement buttonComplain = $x("//li[@class='Dropdown__item']");

    private final SelenideElement unauthorizedActionBox = $x("//div[@class='UnauthActionBox__header']");
    private final SelenideElement reportForm = $x("//div[@class='ReportForm__content']");

    Actions actions = new Actions(WebDriverRunner.getWebDriver());


    public LoginPage clickButtonToWrite() {
        buttonToWrite.click();
        return new LoginPage();
    }

    public LoginPage clickButtonSubscribe() {
        buttonSubscribe.click();
        return new LoginPage();
    }

    public LoginPage clickButtonSubscribeMethod2() {
        buttonSubscribeMethod2.click();
        return new LoginPage();
    }

    public LoginPage clickButtonLike() {
        buttonLike.click();
        return new LoginPage();
    }

    public LoginPage clickButtonCopyUrl() {
        buttonCopyUrl.click();
        return new LoginPage();
    }

    public LoginPage clickButtonFavorite() {
        buttonFavorite.click();
        return new LoginPage();
    }

    public LoginPage clickButtonWishList() {
        buttonWishList.click();
        return new LoginPage();
    }

    public MarketPage clickButtonGoToTheStore() {
        buttonGoToTheStore.click();
        switchTo().window(1);
        return new MarketPage();
    }

    public String checkTextUnauthorizedShare() {
        buttonShare.click();
        return unauthorizedActionBox.getText();

    }

    public String checkErrorMessageComplain() {
        actions.moveToElement(buttonMore).build().perform();
        buttonComplain.click();
        return reportForm.getText();
    }


}
