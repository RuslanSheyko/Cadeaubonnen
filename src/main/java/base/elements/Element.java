package base.elements;

import base.driver.InitialDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static base.util.BaseConstants.*;

@Slf4j
public class Element {
    protected WebDriver driver = InitialDriver.getInstance().getDriver();

    private WebDriverWait waitElement() {
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT);
        wait.pollingEvery(Duration.ofMillis(DELAY));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(InterruptedException.class);
        wait.ignoring(UnknownError.class);
        return wait;
    }

    public WebElement getWebElement(ExpectedCondition<WebElement> webElementExpectedCondition) {

        return waitElement().until(webElementExpectedCondition);
    }
    public boolean getWebStateOfElement(ExpectedCondition<Boolean> stateElementExpectedCondition) {
        return waitElement().until(stateElementExpectedCondition);
    }
    public WebElement waitUntilClickable(By locator) {
        return getWebElement(ExpectedConditions.elementToBeClickable(locator));
    }
    public boolean containsText(By locator,String text) {
        log.info("Locator: "+locator+ " Text: "+text);
        return waitElement().until(ExpectedConditions.textToBePresentInElementLocated(locator,text));
    }
    public boolean waitUntilInvisible(By locator) {
        log.info("Locator: "+locator);
        return waitElement().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public WebElement waitUntilClickable(WebElement element) {
        log.info("Locator: "+element);
        return getWebElement(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitUntilVisible(WebElement element) {
        return getWebElement(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilVisible(By locator) {
        log.info("Locator: "+locator);
        return getWebElement(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilExist(By locator) {
        return getWebElement(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean isVisibility(By locator) {
        try {
            log.info("Element visible: "+locator);
            return new WebDriverWait(driver, EXIST).until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public WebElement getWebElementWithoutWaitAndCondition(By locator) {
        new WebDriverWait(driver, EXIST).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return driver.findElement(locator);
    }

    public List<WebElement> selectFromList(By locator) {
        waitUntilVisible(locator);
        return driver.findElements(locator);
    }
}
