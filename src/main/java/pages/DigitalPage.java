package pages;

import base.elements.Element;
import org.openqa.selenium.By;
import pages.base.BasePage;
import pages.base.giftCards.ChoiceGiftCardsPage;

public class DigitalPage extends BasePage {
    Element element= new Element();

    By getAllGiftList= By.xpath("//div/div/div/a[contains(@href,'/cadeaubonnen/')]");

    @Override
    public String getPageUrl()
    {
        return super.getPageUrl();
    }


    public ChoiceGiftCardsPage selectOneOfCards(int number)
    {
        button.click(element.selectFromList(getAllGiftList).get(number));
        return new ChoiceGiftCardsPage();

    }
}
