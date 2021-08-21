package com.epam.tc.hw6.cucumber.step;

import io.cucumber.java.en.When;

public class ActionStep extends AbstractStep {

    @When("I select water, wind elements")
    public void selectWaterAndWindCheckboxes() {
        differentElementsPage.selectWaterAndWindCheckBoxes();
    }
    @When("I select selen metal")
    public void selectSelenMetalRadioButton() {
        differentElementsPage.selectSelenMetalRadio();
    }
    @When("I select yellow color from drop-down list")
    public void selectYellowColorFromDropDownList() {
        differentElementsPage.selectYellowColor();
    }


    @When("I click on 'Service' button in Header")
    public void clickOnServiceOption() {
        indexPage.clickOnServiceOption();
    }
    @When("I click on 'User Table' button in Service dropdown")
    public void clickOnUserTableSubOption() {
        indexPage.clickOnUserTableSubOption();
    }

    @When("I select 'vip' checkbox for 'Sergey Ivan'")
    public void clickOnCheckboxStatus() {
        userTablePage.clickOnVipCheckBoxForSergey();
    }

}
