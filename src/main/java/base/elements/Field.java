package base.elements;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


@Slf4j
public class Field extends Element {

    public void typeText(By locator, String text) {
        log.info("Locator: " + locator + " Send text: " + text);
        waitUntilClickable(locator).clear();
        waitUntilClickable(locator).sendKeys(text);
    }

    public void sendKeys(By locator, Keys text) {
        log.info("Locator: " + locator + " Send keys: " + text);
        waitUntilClickable(locator).sendKeys(text);
    }

    public String getText(By locator) {
        log.info("Locator: " + locator + " Get Text: " + waitUntilClickable(locator).getText());
       return waitUntilClickable(locator).getText();
    }

}
