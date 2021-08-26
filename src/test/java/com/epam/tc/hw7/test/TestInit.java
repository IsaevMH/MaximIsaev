package com.epam.tc.hw7.test;

import com.epam.tc.hw7.page.SiteJdi;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;

public interface TestInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp()  {
        initSite(SiteJdi.class);
        openSite(SiteJdi.class);
    }

    @AfterSuite(alwaysRun = true)
    static void teardown() {
        killAllSeleniumDrivers();
    }
}
