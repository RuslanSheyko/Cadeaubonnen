package pages.base.giftCards;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import pages.base.BasePage;

public class CardWindowPage extends BasePage {

    private final By name=By.name("name");
    private final By email=By.name("email");
    private final By confirmEmail=By.name("confirmEmail");
    private final By shopNow=By.xpath("//div[text()=\"In m’n winkelmandje\"]");

    @Step("Send name to card {nameValue}")
    public CardWindowPage sendName(String nameValue)
    {
        field.typeText(name,nameValue);
        return this;
    }

    @Step("Send email{nameValue}")
    public CardWindowPage sendEmail(String nameValue)
    {
        field.typeText(email,nameValue);
        return this;
    }

    @Step("Send confirm email{nameValue}")
    public CardWindowPage sendConfirmEmail(String nameValue)
    {
        field.typeText(confirmEmail,nameValue);
        return this;
    }

    @Step("Accept shop now")
    public MyShoppingCartPage shopNow()
    {
        button.click(shopNow);
        return new MyShoppingCartPage();
    }
}
