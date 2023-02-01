package base.elements;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

@Slf4j
public class Dropdown extends Element {

    public void selectByValue(By locator, String value) {
        log.info("Locator: "+locator+" Value: "+value);
        Select select = new Select(waitUntilClickable(locator));
        select.selectByValue(value);
    }

}
