package pages.base.giftCards;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.base.BasePage;

public class ChoiceGiftCardsPage extends BasePage {

    private final By selectCart25 = By.xpath("//input[contains(@value,'25,00')]/../label");
    private final By selectCart50 = By.xpath("//input[contains(@value,'50,00')]/../label");
    private final By selectCart100 = By.xpath("//input[contains(@value,'100,00')]/../label");
    private final By digital = By.xpath("//input[@id='digital']/../label");
    private final By mail = By.xpath("//input[@id='byMail']/../label");
    private final By cartNumber = By.xpath("//input[@type='number']");
    private final By finalAmount = By.xpath("//p[contains(text(),'Kosten')]/../p[2]");
    private final By inMyShopping = By.xpath("//div[text()=\"In m'n winkelmandje\"]");

    public enum CartValue {
        EURO25,
        EURO50,
        EURO100
    }

    public enum CartType {
        DIGITAL,
        MAIL
    }

    @Step("Send count of cart {cart}")
    public ChoiceGiftCardsPage sendCountOfCart(int cart) {
        field.typeText(cartNumber, String.valueOf(cart));
        field.sendKeys(cartNumber, Keys.ENTER);
        return this;
    }

    @Step("Select type of Card cart {cartType}")
    public ChoiceGiftCardsPage selectTypeOfCard(CartType cartType) {
        switch (cartType) {
            case MAIL:
                button.click(mail);
            case DIGITAL:
                button.click(digital);
        }
        return this;
    }

    @Step("Choose cart {value}")
    public ChoiceGiftCardsPage chooseCart(CartValue value) {
        switch (value) {
            case EURO25:
                button.click(selectCart25);
            case EURO50:
                button.click(selectCart50);
            case EURO100:
                button.click(selectCart100);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + value);
        }
        return this;
    }

    @Step("Send to shopping")
    public CardWindowPage ToShopping()
    {
        button.click(inMyShopping);
        return new CardWindowPage();
    }



}
