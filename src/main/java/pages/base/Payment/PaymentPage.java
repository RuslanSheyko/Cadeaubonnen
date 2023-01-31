package pages.base.Payment;

import org.openqa.selenium.By;
import pages.base.BasePage;
import pages.base.giftCards.MyShoppingCartPage;

public class PaymentPage extends BasePage {

    public By nameOnCart=By.name("brq_SERVICE_mastercard_CustomerCardName");
    public By cartNumber=By.name("brmv_brq_SERVICE_mastercard_MastercardCreditcardNumber");
    public By dateMonth=By.id("brmv_brq_CardExpirationDate_month");
    public By dateYear=By.id("brmv_brq_CardExpirationDate_year");
    public By CVC=By.id("brq_SERVICE_mastercard_CVV3");
    public By continueBtn=By.id("button_continue");
    public PaymentPage sendName(String name)
    {
        field.typeText(nameOnCart,name);
        return this;
    }

    public PaymentPage sendNumber(String number)
    {
        field.typeText(cartNumber,number);
        return this;
    }

    public PaymentPage sendCVC(String cvv)
    {
        field.typeText(CVC,cvv);
        return this;
    }

    public enum Month
    {
        January("01"),
        February("02");

        Month(String month) {
            this.month= month;
        }

        private String month;

        public String getMonth() {
           return month;
        }
    }
    public PaymentPage continuePayment()
    {
        button.click(continueBtn);
        return this;
    }

    public PaymentPage selectDate(Month month,String year)
    {
        dropdown.selectByValue(dateMonth,month.getMonth());
        dropdown.selectByValue(dateYear,year);
        return this;
    }

    public boolean CartNotCorrect()
    {
        return elementProperties.getAttribute(cartNumber,"class").contains("bpe_error_field");
    }
}
