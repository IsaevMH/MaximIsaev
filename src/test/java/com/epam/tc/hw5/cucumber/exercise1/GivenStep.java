package com.epam.tc.hw5.cucumber.exercise1;

import com.epam.tc.hw5.service.DataReader;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class GivenStep extends AbstractStep {
    protected GivenStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Given("I open 'Index' page")
    public void openIndexPage() {
        indexPage.openPage();
    }

    @Given("I login as user 'Roman Iovlev'")
    public void login() {
        indexPage.login(DataReader.getProperty("login"),
                DataReader.getProperty("passwd"));
    }

    @Given("I open the 'Different Elements' suboption in 'Service' option from the menu panel on the top")
    public void moveToDifferentElementsPage() {
        indexPage.gotToDifferentElementsPage();
    }
}
