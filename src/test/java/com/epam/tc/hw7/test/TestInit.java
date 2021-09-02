package com.epam.tc.hw7.test;

import com.epam.tc.hw7.page.SiteJdi;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.tc.hw7.page.IndexPage.loginForm;
import static com.epam.tc.hw7.page.SiteJdi.indexPage;
import static com.epam.tc.hw7.test.DataProviderJson.USER;

public interface TestInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp()  {
        initSite(SiteJdi.class);
        openSite(SiteJdi.class);
        loginForm.fill(USER);
    }

    @AfterSuite(alwaysRun = true)
    static void teardown() {
        indexPage.logout();
        killAllSeleniumDrivers();
    }
}
