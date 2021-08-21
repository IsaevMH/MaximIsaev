package com.epam.tc.hw6.test;

import com.epam.tc.hw6.driver.Driver;
import com.epam.tc.hw6.driver.DriverSingleton;
import com.epam.tc.hw6.service.DataReader;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    protected static final String BASE_URL = DataReader.getProperty("url");
    protected WebDriver driver;

    @BeforeClass
    public void setUp(ITestContext testContext) {
        driver = DriverSingleton.getDriver();
        testContext.setAttribute("driver", driver);
        driver.navigate().to(BASE_URL);
    }

    @AfterClass
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
