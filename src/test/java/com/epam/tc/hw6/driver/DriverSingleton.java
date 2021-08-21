package com.epam.tc.hw6.driver;

import com.epam.tc.hw3.service.Browser;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class DriverSingleton {
    private DriverSingleton() {}

    private static WebDriver driver;

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

    public static WebDriver getDriver() {
        String driverType = System.getProperty("driver.type", "local");
        String browserName = System.getProperty("browser.name", "chrome");
        if(Objects.isNull(driver)) {
            driver = WebDriverFactory.createDriver(driverType, Browser.valueOf(browserName));
        }
        return driver;
    }
}
