import base.listeners.Listener;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.base.BasePage;

import static base.util.BaseConstants.MainMenu;
import static base.util.BaseConstants.SEARCH_PRODUCT;


@Listeners({Listener.class})
public class BaseTest  {

    @Test
    @Story("Check that mega-menu is opening.")
    public void verifyBaseElement() {
        BasePage basePage = new BasePage();
        basePage.openBasePage()
                .openMainMenu();
        Assert.assertEquals(basePage.listOfMenu(), MainMenu);
    }

    @Test
    @Story("Check that Autocomplete is working")
    public void verifySearch() {
        BasePage basePage = new BasePage();
        basePage.openBasePage()
                .searchPage("Deca")
                .resultOfSearch("1 resultaat");
        Assert.assertEquals(basePage.getProductFromSearchWindow(0), SEARCH_PRODUCT);
    }
}
