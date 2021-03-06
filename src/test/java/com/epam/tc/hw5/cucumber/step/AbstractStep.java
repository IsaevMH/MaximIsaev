package com.epam.tc.hw5.cucumber.step;

import com.epam.tc.hw5.page.DifferentElementsPage;
import com.epam.tc.hw5.page.IndexPage;
import com.epam.tc.hw5.page.UserTablePage;
import com.epam.tc.hw5.service.TestContext;
import org.openqa.selenium.WebDriver;

public class AbstractStep {
    protected IndexPage indexPage;
    protected UserTablePage userTablePage;
    protected DifferentElementsPage differentElementsPage;

    protected AbstractStep() {
        WebDriver driver = TestContext.getInstance().getTestObject("web_driver");
        indexPage = new IndexPage(driver);
        userTablePage = new UserTablePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
    }
}
