package com.epam.tc.hw5.cucumber.exercise2.step;

import com.epam.tc.hw5.service.DataReader;
import io.cucumber.java.en.Given;

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


}
