package com.epam.tc.hw5.cucumber.exercise3.step;

import com.epam.tc.hw5.service.DataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GivenStep extends AbstractStep {
    @Given("I open JDI GitHub site")
    public void openJdiPage() {
        indexPage.openPage();
    }

    @Given("I login as user 'Roman Iovlev'")
    public void login() {
        indexPage.login(DataReader.getProperty("login"),
                DataReader.getProperty("passwd"));
    }

    @Given("I click on 'Service' button in Header")
    public void clickOnServiceOption() {
        indexPage.clickOnServiceOption();
    }

    @Given("I click on 'User Table' button in Service dropdown")
    public void clickOnUserTableSubOption() {
        indexPage.clickOnUserTableSubOption();
    }
}
