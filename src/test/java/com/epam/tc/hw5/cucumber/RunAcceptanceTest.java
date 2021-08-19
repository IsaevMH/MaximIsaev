package com.epam.tc.hw5.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
        features = {"src/test/resources/com.epam.tc.hw5.cucumber/exercis1/indexPageCheckElementsExist.feature",
                "src/test/resources/com.epam.tc.hw5.cucumber/exercise2/tablePageCheckUserInformation.feature",
                "src/test/resources/com.epam.tc.hw5.cucumber/exercise3/tablePageCheckStatusWasChanged.feature"})
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {

}
