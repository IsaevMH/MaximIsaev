package com.epam.tc.hw5.cucumber.exercise3.hook;

import com.epam.tc.hw5.driver.Driver;
import com.epam.tc.hw5.service.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class CucumberHook {
    private WebDriver driver;

    @Before
    public void initDriver() {
        driver = new Driver().getDriver();
        TestContext.getInstance().addTestObject("web_driver", driver);
    }

    @After
    public void tearDownDriver() {
        driver.quit();
        TestContext.getInstance().clean();
    }
}
