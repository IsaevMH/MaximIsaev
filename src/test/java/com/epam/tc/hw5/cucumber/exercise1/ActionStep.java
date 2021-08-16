package com.epam.tc.hw5.cucumber.exercise1;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {
    protected ActionStep(WebDriver webDriver) { super(webDriver); }

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
}
