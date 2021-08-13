package com.epam.tc.hw3.test;

import com.epam.tc.hw3.driver.Driver;
import com.epam.tc.hw3.service.DataReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    protected static final String BASE_URL = DataReader.getProperty("url");
    protected WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        driver = new Driver().getDriver();
        softAssert = new SoftAssert();
        driver.navigate().to(BASE_URL);
    }

    @AfterClass
    public void stopBrowser() {
        driver.quit();
    }
}
