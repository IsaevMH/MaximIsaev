package com.epam.tc.hw5.cucumber.exercise3.step;

import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

public class AssertionStep extends AbstractStep{

    @Then("1 log row has 'Vip: condition changed to true' text in log section")
    public void isVipConditionChangedToTrue() {
        String sergeyStatus = userTablePage.getLogs().get(0);
        Assertions.assertThat(sergeyStatus)
                .as("Status doesn't match with expexted status")
                .isEqualTo("Vip:true");
    }
}
