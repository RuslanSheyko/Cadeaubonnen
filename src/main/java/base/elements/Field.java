package base.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Handler class for describing actions for text field elements
 */
public class Field extends Element {

    public void typeText(By locator, String text) {
        waitUntilClickable(locator).clear();
        waitUntilClickable(locator).sendKeys(text);
    }

    public void sendKeys(By locator, Keys text) {
        waitUntilClickable(locator).sendKeys(text);
    }

    public String getText(By locator) {
       return waitUntilClickable(locator).getText();
    }

}
