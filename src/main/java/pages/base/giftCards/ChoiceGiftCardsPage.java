package pages.base.giftCards;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.DigitalPage;
import pages.base.BasePage;

public class ChoiceGiftCardsPage extends BasePage {

    By selectCart25 = By.xpath("//input[contains(@value,'25,00')]/../label");
    By selectCart50 = By.xpath("//input[contains(@value,'50,00')]/../label");
    By selectCart100 = By.xpath("//input[contains(@value,'100,00')]/../label");
    //
    By digital = By.xpath("//input[@id='digital']/../label");
    By mail = By.xpath("//input[@id='byMail']/../label");
    //
    By cartNumber = By.xpath("//input[@type='number']");
    By finalAmount = By.xpath("//p[contains(text(),'Kosten')]/../p[2]");
    By inMyShopping = By.xpath("//div[text()=\"In m'n winkelmandje\"]");


    public enum CartValue {
        EURO25,
        EURO50,
        EURO100
    }

    public enum CartType {
        DIGITAL,
        MAIL
    }

    public ChoiceGiftCardsPage sendCountOfCart(int cart) {
        field.typeText(cartNumber, String.valueOf(cart));
        field.sendKeys(cartNumber, Keys.ENTER);
        return this;
    }

    public ChoiceGiftCardsPage selectTypeOfCard(CartType cartType) {
        switch (cartType) {
            case MAIL:
                button.click(mail);
            case DIGITAL:
                button.click(digital);
        }
        return this;
    }

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

    public String getAmount() {
        return field.getText(finalAmount);
    }

    public CardWindowPage ToShopping()
    {
        button.click(inMyShopping);
//        window.switchToIframe(frame);
        return new CardWindowPage();
    }



}
