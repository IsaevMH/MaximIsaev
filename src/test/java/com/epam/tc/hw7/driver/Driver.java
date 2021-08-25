package com.epam.tc.hw7.driver;

import com.epam.tc.hw6.service.Browser;
import com.epam.tc.hw6.service.DataReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private WebDriver driver;

    public WebDriver getDriver() {
        switch (Browser.valueOf(DataReader.getProperty("browser"))) {
            case chrome:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case firefox:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }
}
