package com.epam.tc.hw6.driver;

import com.epam.tc.hw3.service.Browser;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    private static final String REMOTE_DRIVER = "remote";
    private static final String LOCAL_DRIVER = "local";


   private WebDriverFactory() {}

    public static WebDriver createDriver(final String type, final Browser browserName) {
        WebDriver driver = null;
        if (REMOTE_DRIVER.equalsIgnoreCase(type)){
            return RemoteDriver.createRemoteDriver(browserName);
        }
        else if (LOCAL_DRIVER.equalsIgnoreCase(type)) {
            return LocalDriver.createLocalDriver(browserName);
        }
        else {
            throw new IllegalArgumentException(String.format("Uncorrect value of browser type '%s'. " +
                    "Please, select correct type of browser", type));
        }
    }
}
