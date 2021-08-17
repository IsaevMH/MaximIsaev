package com.epam.tc.hw5.cucumber.exercise3.step;

import io.cucumber.java.en.When;

public class ActionStep extends AbstractStep {

    @When("I select 'vip' checkbox for 'Sergey Ivan'")
    public void clickOnCheckboxStatus() {
        userTablePage.clickOnVipCheckBoxForSergey();
    }
}
