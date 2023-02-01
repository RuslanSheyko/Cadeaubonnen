package pages;

import base.elements.Element;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import pages.base.BasePage;
import pages.base.giftCards.ChoiceGiftCardsPage;

@Slf4j
public class DigitalPage extends BasePage {
    Element element= new Element();
    private final By getAllGiftList= By.xpath("//div/div/div/a[contains(@href,'/cadeaubonnen/')]");

    @Override
    public String getPageUrl()
    {
        return super.getPageUrl();
    }

    @Step("Select one of carts {number}")
    public ChoiceGiftCardsPage selectOneOfCards(int number)
    {
        button.click(element.selectFromList(getAllGiftList).get(number));
        return new ChoiceGiftCardsPage();

    }
}
