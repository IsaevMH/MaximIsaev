package com.epam.tc.hw4.test;

import com.epam.tc.hw4.driver.Driver;
import com.epam.tc.hw4.service.DataReader;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    protected static final String BASE_URL = DataReader.getProperty("url");
    protected WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeClass
    public void setUp(ITestContext testContext) {
        driver = new Driver().getDriver();
        testContext.setAttribute("driver", driver);
        softAssert = new SoftAssert();
        driver.navigate().to(BASE_URL);
    }

    @AfterClass
    public void stopBrowser() {
        driver.quit();
    }
}
