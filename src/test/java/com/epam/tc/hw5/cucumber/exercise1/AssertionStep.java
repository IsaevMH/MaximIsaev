package com.epam.tc.hw5.cucumber.exercise1;

import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class AssertionStep extends AbstractStep {
    protected AssertionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Then("Selected elements should be visible in log field on 'Different Elements' page")
    public void allSelectedElementsAreVisibleOnDifferentElementsPage() {
        List<String> expectedResult = Arrays.asList("Wind:true", "Water:true","metal:Selen", "Colors:Yellow");
        List<String> getAllElement = differentElementsPage.getAllSelectedElements();
        Assertions.assertThat(getAllElement)
                .as("Lists don't match")
                .isEqualTo(expectedResult);
    }
}
