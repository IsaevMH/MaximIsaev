package com.epam.tc.hw5.cucumber.exercise1.step;

import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class AssertionStep extends AbstractStep {

    @Then("Selected elements should be visible in log field on 'Different Elements' page")
    public void allSelectedElementsAreVisibleOnDifferentElementsPage() {
        List<String> expectedResult = Arrays.asList("Colors:Yellow", "metal:Selen", "Wind:true", "Water:true");
        List<String> getAllElement = differentElementsPage.getAllSelectedElements();
        Assertions.assertThat(getAllElement)
                .as("Lists don't match")
                .isEqualTo(expectedResult);
    }
}
