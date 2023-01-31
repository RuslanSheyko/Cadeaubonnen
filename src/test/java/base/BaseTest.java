package base;

import base.listeners.Listener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.base.BasePage;

import static base.util.BaseConstants.MainMenu;
import static base.util.BaseConstants.SEARCH_PRODUCT;

@Listeners({Listener.class})
public class BaseTest {


    @Test
    public void verifyBaseElement() {
        BasePage basePage = new BasePage();
        basePage.openBasePage().openMainMenu();
        Assert.assertEquals(basePage.listOfMenu(), MainMenu);
    }

    @Test
    public void verifySearch() {
        BasePage basePage = new BasePage();
        basePage.openBasePage().searchPage("Deca")
                .resultOfSearch("1 resultaat");
        Assert.assertEquals(basePage.getProductFromSearchWindow(0), SEARCH_PRODUCT);
    }
}
