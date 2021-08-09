package com.epam.tc.hw3.test;

import com.epam.tc.hw3.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected static WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeTest
    public void setUp() {
        driver = DriverSingleton.getDriver();
        softAssert = new SoftAssert();
    }

    @AfterTest
    public void stopBrowser() {
        driver.quit();
        driver = null;
    }
}
