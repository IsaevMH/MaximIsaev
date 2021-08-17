package com.epam.tc.hw5.cucumber.exercise2.step;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActionStep extends AbstractStep{

    @When("I click on 'Service' button in Header")
    public void clickOnServiceOption() {
        indexPage.clickOnServiceOption();
    }

    @When("I click on 'User Table' button in Service dropdown")
    public void clickOnUserTableSubOption() {
        indexPage.clickOnUserTableSubOption();
    }
}
