package base.elements;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static base.util.BaseConstants.TIME_OUT;

/**
 * Handler class for methods associated with properties of web elements
 */
@Slf4j
public class ElementProperties extends Element {

    public String getAttribute(By locator, String attribute) {
        log.info("Locator: "+locator+" Attribute: "+attribute);
        return waitUntilVisible(locator).getAttribute(attribute);
    }

}
