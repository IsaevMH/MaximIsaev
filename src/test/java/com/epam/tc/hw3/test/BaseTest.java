package com.epam.tc.hw3.test;

import com.epam.tc.hw3.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    protected static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        driver = DriverSingleton.getDriver();
        softAssert = new SoftAssert();
        driver.navigate().to(BASE_URL);
    }

    @AfterClass
    public void stopBrowser() {
        driver = null;
    }
}
