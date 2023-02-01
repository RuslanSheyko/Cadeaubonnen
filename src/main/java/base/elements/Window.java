package base.elements;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Window extends Element {

    /**
     * Navigating a web page by URL
     *
     * @param url - the address to which the transition is made
     */
    public void navigateTo(String url) {
        log.info("Url: "+url);
        driver.navigate().to(url);
    }

    /**
     * Getting the page address
     *
     * @return page address string
     */
    public String getPageUrl() {
        return driver.getCurrentUrl();
    }


}
