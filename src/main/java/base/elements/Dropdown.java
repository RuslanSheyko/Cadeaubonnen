package base.elements;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A handler class for describing actions for items with a dropdown list
 */
@Slf4j
public class Dropdown extends Element {

    /**
     * Select item dropdown list
     *
     * @param locator - element locator by which the drop-down list is found
     * @param value   - a string with an option to be selected in the drop-down list
     */
    public void selectByValue(By locator, String value) {
        Select select = new Select(waitUntilClickable(locator));
        select.selectByValue(value);
    }

    /**
     * Selecting a drop-down list item by index
     *
     * @param locator - element locator by which the drop-down list is found
     * @param index   - the index of the option to be selected in the dropdown list
     */
    public void selectByIndex(By locator, int index) {
        Select select = new Select(waitUntilClickable(locator));
        select.selectByIndex(index);
    }

}
