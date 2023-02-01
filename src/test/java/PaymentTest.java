import base.listeners.Listener;
import com.github.javafaker.Faker;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.base.BasePage;
import pages.base.Payment.PaymentPage;
import pages.base.giftCards.BuyPage;
import pages.base.giftCards.ChoiceGiftCardsPage;
import pages.base.giftCards.MyShoppingCartPage;

import static base.util.BaseConstants.GENERAL_URL;
import static base.util.BaseConstants.SHOP_URL;


@Listeners({Listener.class})
public class PaymentTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add two product to cart")
    public void addProductToCart() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        BasePage basePage = new BasePage();
        MyShoppingCartPage shoppingCartPage = basePage.openBasePage()
                .selectDigitalGiftCards()
                .selectOneOfCards(1)
                .chooseCart(ChoiceGiftCardsPage.CartValue.EURO50)
                .selectTypeOfCard(ChoiceGiftCardsPage.CartType.DIGITAL)
                .sendCountOfCart(2).ToShopping()
                .sendName(faker.name().firstName())
                .sendEmail(email)
                .sendConfirmEmail(email)
                .shopNow();
        Assert.assertEquals(shoppingCartPage.getFinalAmount(), "€ 200,00");
        Assert.assertEquals(shoppingCartPage.continueShopping().getPageUrl(), GENERAL_URL);
        basePage.openBucket();
        Assert.assertEquals(shoppingCartPage.getFinalAmount(), "€ 200,00");
        Assert.assertEquals(shoppingCartPage.getPageUrl(), SHOP_URL);
    }


    @Test(dependsOnMethods = "addProductToCart")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Proceed to checkout and try to put credit card data.")
    public void addCreditCard() {
        Faker faker = new Faker();
        MyShoppingCartPage shop = new MyShoppingCartPage();
        PaymentPage paymentPage = shop.savePayment().sendFirstName(faker.name().firstName())
                .sendLastName(faker.name().lastName())
                .sendEmail(faker.internet().emailAddress())
                .sendPhoneName(faker.phoneNumber().subscriberNumber(12))
                .continueBuy()
                .selectPayment(BuyPage.Payment.MasterCard)
                .finishPayment()
                .sendName(faker.name().fullName())
                .sendNumber(faker.phoneNumber().subscriberNumber(12))
                .sendCVC(faker.phoneNumber().subscriberNumber(3))
                .selectDate(PaymentPage.Month.February, "2024")
                .continuePayment();
        Assert.assertTrue(paymentPage.CartNotCorrect());
    }
}
