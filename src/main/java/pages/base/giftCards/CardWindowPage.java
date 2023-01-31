package pages.base.giftCards;

import org.openqa.selenium.By;
import pages.base.BasePage;

public class CardWindowPage extends BasePage {
    By name=By.name("name");
    By email=By.name("email");
    By confirmEmail=By.name("confirmEmail");
    By shopNow=By.xpath("//div[text()=\"In m’n winkelmandje\"]");


    public CardWindowPage sendName(String nameValue)
    {
        field.typeText(name,nameValue);
        return this;
    }

    public CardWindowPage sendEmail(String nameValue)
    {
        field.typeText(email,nameValue);
        return this;
    }

    public CardWindowPage sendConfirmEmail(String nameValue)
    {
        field.typeText(confirmEmail,nameValue);
        return this;
    }

    public MyShoppingCartPage shopNow()
    {
        button.click(shopNow);
        return new MyShoppingCartPage();
    }
}
