package pages.base.giftCards;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.base.BasePage;
import pages.base.Payment.PaymentPage;

public class BuyPage extends BasePage {

    private final By masterCard = By.xpath("//p[text()='MasterCard']/../..");
    private final By visa = By.xpath("//p[text()='Visa']/../..");
    private final By iDeal = By.xpath("//p[text()='iDeal']/../..");

    public By finishPayment = By.xpath("//div[text()='Betaling afronden']");

    public enum Payment {
        MasterCard,
        iDeal,
        Visa
    }

    @Step("Select on of payment method {payment}")
    public BuyPage selectPayment(Payment payment) {
        switch (payment) {
            case Visa -> {
                button.click(visa);
                return this;
            }
            case MasterCard -> {
                button.click(masterCard);
                return this;
            }
            case iDeal -> {
                button.click(iDeal);
                return this;
            }
            default -> throw new IllegalStateException("Unexpected value: ");
        }
    }

    @Step("Finish payment")
    public PaymentPage finishPayment() {
        button.click(finishPayment);
        return new PaymentPage();
    }
}
