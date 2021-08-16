package com.epam.tc.hw5.cucumber.exercise1;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
        features = {"src/test/resources/com.epam.tc.hw5.cucumber.exercise1/indexPageCheckElementsExist.feature"})
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {

}
