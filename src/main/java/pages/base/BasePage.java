package pages.base;

import base.elements.*;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.DigitalPage;
import pages.base.giftCards.MyShoppingCartPage;

import java.util.List;
import java.util.stream.Collectors;

import static base.util.BaseConstants.APPLICATION_URL;


@Slf4j
public class BasePage {

    protected Window window = new Window();
    protected Button button = new Button();
    protected Field field = new Field();
    protected Dropdown dropdown = new Dropdown();
    protected ElementProperties elementProperties = new ElementProperties();

    By bucket = By.xpath("//a[@href='/winkelmandje/']");
    By acceptAll = By.id("CookieConsentIOAccept");
    By mainMenu = By.xpath("//header//p[text()='Cadeaubonnen']");
    //Vouchers by category
    By digitalCart = By.linkText("Digitale Cadeaubonnen");
    By listMenu = By.xpath("//div[contains(@class,'ReactModal__Content ')]//p");
    By searchField = By.xpath("//input[@placeholder='Waar ben je naar op zoek?']");
    By searchElement = By.xpath("//div[contains(@class,'ReactModal__Content ')]//a");
    By loading = By.className("_31e68eac77a8ab507badcf38cecaff4f-css");
    By searchElementResult = By.xpath(" //div[contains(text(),'resultaat')]");


    @Step("Select digital gift card")
    public DigitalPage selectDigitalGiftCards() {
        button.click(digitalCart);
        return new DigitalPage();
    }

    @Step("Open Bucket")
    public MyShoppingCartPage openBucket() {
        button.click(bucket);
        return new MyShoppingCartPage();
    }

    @Step("Open base page")
    public BasePage openBasePage() {
        window.navigateTo(APPLICATION_URL);
        if (elementProperties.isVisibility(acceptAll))
            button.click(acceptAll);
        return this;
    }

    public String getPageUrl() {
        return window.getPageUrl();
    }

    @Step("Open main menu")
    public BasePage openMainMenu() {
        button.click(mainMenu);
        return this;
    }

    public List<String> listOfMenu() {
        return elementProperties.selectFromList(listMenu).stream().map(WebElement::getText).collect(Collectors.toList());

    }
    @Step("Start search {search}")
    public BasePage searchPage(String search) {
        field.typeText(searchField, search);
        return this;
    }

    @Step("Get result of search")
    public BasePage resultOfSearch(String text)
    {
        field.containsText(searchElementResult,text);
        return this;
    }

    @Step("Get product from search window")
    public String getProductFromSearchWindow(int index) {
        elementProperties.waitUntilInvisible(loading);
        elementProperties.waitUntilVisible(searchElement);
        return elementProperties.selectFromList(searchElement).stream().map(WebElement::getText).toList().get(index);

    }

}
