package com.epam.tc.hw7.test;

import com.epam.tc.hw7.page.SiteJdi;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;

public interface TestInit {
    @BeforeClass(alwaysRun = true)
    static void setUp() {
        openSite(SiteJdi.class);

    }

    @AfterClass
    static void teardown() {
        killAllSeleniumDrivers();
    }
}
