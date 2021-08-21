package com.epam.tc.hw6.driver;

import com.epam.tc.hw3.service.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalDriver {
    public static WebDriver createLocalDriver(Browser browser) {
        WebDriver driver = null;
        switch (browser) {
            case chrome:
                driver = createChromeDriver();
                break;
            case firefox:
                driver = createFirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException(String.format("Uncorrect value of browser type '%s'. " +
                        "Please, select correct type of browser", browser));
        }
        driver.manage().window().maximize();
        return driver;
    }
    public static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
    public static WebDriver createFirefoxDriver() {
        WebDriverManager.chromedriver().setup();
        return new FirefoxDriver();
    }
}
