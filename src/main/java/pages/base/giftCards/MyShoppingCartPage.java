package pages.base.giftCards;

import org.openqa.selenium.By;
import pages.base.BasePage;

public class MyShoppingCartPage extends BasePage {
    By continueShopping=By.xpath("//div[text()=\"Verder winkelen\"]");
    By finalAmount=By.xpath("//p[text()=\"Totaal incl. btw\"]/../p[2]");

    By firstNameFld= By.name("firstName");
    By lastNameFld= By.name("lastName");
    By emailFld= By.name("profileEmail");
    By phoneNumberFld= By.name("phoneNumber");
    By continueBtn= By.xpath("//div[text()='Ga verder']");
    By safePayment= By.xpath("//div[text()='Veilig afrekenen']");

    public MyShoppingCartPage savePayment()
    {
        button.click(safePayment);
        return new MyShoppingCartPage();
    }


    public BasePage continueShopping()
    {
        button.click(continueShopping);
        return new BasePage();
    }

    public String getFinalAmount()
    {
        return field.getText(finalAmount);
    }

    public MyShoppingCartPage sendFirstName(String firstName)
    {
        field.typeText(firstNameFld,firstName);
        return this;
    }

    public MyShoppingCartPage sendLastName(String lastName)
    {
        field.typeText(lastNameFld,lastName);
        return this;
    }

    public MyShoppingCartPage sendEmail(String email)
    {
        field.typeText(emailFld,email);
        return this;
    }

    public MyShoppingCartPage sendPhoneName(String phone)
    {
        field.typeText(phoneNumberFld,phone);
        return this;
    }

    public BuyPage continueBuy()
    {
        button.click(continueBtn);
        return new BuyPage();
    }

}
