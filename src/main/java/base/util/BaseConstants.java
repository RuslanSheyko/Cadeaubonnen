package base.util;

import java.util.Arrays;
import java.util.List;

/**
 * A class that stores basic constants available throughout the project
 */
public class BaseConstants {
    /**
     * Driver name for option selection during initialization
     */
    public static final String DRIVER_NAME = new PropertiesReader().browserProperties().getProperty("browser.driver");
    public static final boolean useWebdriverManager = Boolean.parseBoolean(new PropertiesReader().browserProperties().getProperty("webdriverManager"));


    public static final List<String> MainMenu = Arrays.asList("Alle Cadeaubonnen", "Digitale Cadeaubonnen", "Keuze Cadeaukaarten",
            "Belevenissen", "Giftcards van het Jaar", "Beauty & Wellness",
            "Eten & Drinken", "Mode & Accessoires", "Gaming",
            "Baby's & Kinderen", "Lezen", "Cultuur, Films & Uitjes",
            "Online shoppen", "Overnachten", "Sportief",
            "Wonen & Tuin");
    public static final String SEARCH_PRODUCT = "Decathlon Cadeaubon";
    /**
     * App URL
     */
    public static final String APPLICATION_URL = new PropertiesReader().application().getProperty("application.url");
    public static final String GENERAL_URL = new PropertiesReader().application().getProperty("application.url") + "cadeaubonnen/";
    public static final String SHOP_URL = new PropertiesReader().application().getProperty("application.url") + "winkelmandje/";

    /**
     * DELAY - the time of polling the state of an element when checking its condition when searching
     * TIME_OUT - time after which the element is considered not found if the conditions are not met
     * LOADER_TIME_WAIT_FOR_DOWNLOAD - waiting time for building a file for downloading on the back and downloading it
     * EXIST - time to search for the presence of an element
     */
    public static final long DELAY = Long.parseLong(new PropertiesReader().get("element.delay"));
    public static final long TIME_OUT = Long.parseLong(new PropertiesReader().get("element.time_out"));
    public static final long LOADER_TIME_WAIT_FOR_DOWNLOAD = Long.parseLong(new PropertiesReader().get("loader.time.wait.download"));
    public static final long EXIST = Long.parseLong(new PropertiesReader().get("element.exist"));

    /**
     * FULL_RIGHTS_USERNAME - username with all rights to login to the application
     * FULL_RIGHTS_PASSWORD - user password with all rights to login to the application
     */
    public static final String FULL_RIGHTS_USERNAME = new PropertiesReader().application().getProperty("login.test.email");
    public static final String FULL_RIGHTS_PASSWORD = new PropertiesReader().application().getProperty("login.test.password");

    /**
     * Block with different passwords and usernames
     */
    public static final String NO_RIGHTS_USERNAME = new PropertiesReader().application().getProperty("no.rights.user.email");
    public static final String NO_RIGHTS_PASSWORD = new PropertiesReader().application().getProperty("no.rights.user.password");

    public static final String MANAGER_USERNAME = new PropertiesReader().application().getProperty("manager.user.email");
    public static final String MANAGER_PASSWORD = new PropertiesReader().application().getProperty("manager.user.password");
}
