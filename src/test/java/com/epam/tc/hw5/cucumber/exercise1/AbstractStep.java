package com.epam.tc.hw5.cucumber.exercise1;

import com.epam.tc.hw5.page.DifferentElementsPage;
import com.epam.tc.hw5.page.IndexPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AbstractStep {

    protected IndexPage indexPage;
    protected DifferentElementsPage differentElementsPage;

    protected AbstractStep(WebDriver webDriver) {
        indexPage = new IndexPage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
    }
}
