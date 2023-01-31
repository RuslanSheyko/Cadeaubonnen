package pages.base.giftCards;

import org.openqa.selenium.By;
import pages.base.BasePage;
import pages.base.Payment.PaymentPage;

public class BuyPage extends BasePage {

    By masterCard = By.xpath("//p[text()='MasterCard']/../..");
    By visa = By.xpath("//p[text()='Visa']/../..");
    By iDeal = By.xpath("//p[text()='iDeal']/../..");

    public By finishPayment = By.xpath("//div[text()='Betaling afronden']");

    public enum Payment {
        MasterCard,
        iDeal,
        Visa
    }

    public BuyPage selectPayment(Payment payment) {
        switch (payment) {
            case Visa: {
                button.click(visa);
                return this;
            }
            case MasterCard: {
                button.click(masterCard);
                return this;
            }
            case iDeal: {
                button.click(iDeal);
                return this;
            }
            default:
                throw new IllegalStateException("Unexpected value: ");
        }
    }

    public PaymentPage finishPayment() {
        button.click(finishPayment);
        return new PaymentPage();
    }
}
