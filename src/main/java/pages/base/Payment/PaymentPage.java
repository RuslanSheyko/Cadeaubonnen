package pages.base.Payment;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.base.BasePage;

public class PaymentPage extends BasePage {

    private final By nameOnCart=By.name("brq_SERVICE_mastercard_CustomerCardName");
    private final By cartNumber=By.name("brmv_brq_SERVICE_mastercard_MastercardCreditcardNumber");
    private final By dateMonth=By.id("brmv_brq_CardExpirationDate_month");
    private final By dateYear=By.id("brmv_brq_CardExpirationDate_year");
    private final By CVC=By.id("brq_SERVICE_mastercard_CVV3");
    private final By continueBtn=By.id("button_continue");

    @Step("Send name cart to field")
    public PaymentPage sendName(String name)
    {
        field.typeText(nameOnCart,name);
        return this;
    }

    @Step("Send number cart to field")
    public PaymentPage sendNumber(String number)
    {
        field.typeText(cartNumber,number);
        return this;
    }

    @Step("Send cvv cart to field")
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
    @Step("Continue payment")
    public PaymentPage continuePayment()
    {
        button.click(continueBtn);
        return this;
    }

    @Step("Select data month {month} and year {year}")
    public PaymentPage selectDate(Month month,String year)
    {
        dropdown.selectByValue(dateMonth,month.getMonth());
        dropdown.selectByValue(dateYear,year);
        return this;
    }


    @Step("Cart not correct")
    public boolean CartNotCorrect()
    {
        return elementProperties.getAttribute(cartNumber,"class").contains("bpe_error_field");
    }
}
