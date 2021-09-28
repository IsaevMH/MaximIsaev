package com.epam.tc.hw7.test;

import com.epam.tc.hw7.page.SiteJdi;
import org.testng.annotations.*;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.tc.hw7.page.IndexPage.*;

public interface TestInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp()  {
        openSite(SiteJdi.class);
        userShouldBeLoggedIn();
    }

    @AfterSuite(alwaysRun = true)
    static void teardown() {
        killAllSeleniumDrivers();
    }
}
