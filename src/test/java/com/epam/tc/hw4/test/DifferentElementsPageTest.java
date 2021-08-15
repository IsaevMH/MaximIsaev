package com.epam.tc.hw4.test;

import com.epam.tc.hw4.page.DifferentElementsPage;
import com.epam.tc.hw4.page.IndexPage;
import com.epam.tc.hw4.service.DataReader;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class DifferentElementsPageTest extends BaseTest {

    @Test
    @Step
    public void isUserLogin() {
        IndexPage indexPage =  new IndexPage(driver);
        indexPage.openPage();
        indexPage.login(DataReader.getProperty("login"),
                DataReader.getProperty("passwd"));
        softAssert.assertEquals(indexPage.getUserName(), "ROMAN IOVLEV");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "isUserLogin")
    @Step
    public void areWaterAndWindCheckboxesSelected() {
        List<String> expectedResult = Arrays.asList("Wind:true", "Water:true");

        IndexPage indexPage = new IndexPage(driver);
        indexPage.gotToDifferentElementsPage();
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        differentElementsPage.selectWaterAndWindCheckBoxes();

        softAssert.assertEquals(differentElementsPage.getAllSelectedElements(), expectedResult);
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "areWaterAndWindCheckboxesSelected")
    @Step
    public void isSelenMetalRadioSelected() {
        String expectedResult = "metal:Selen";
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        differentElementsPage.selectSelenMetalRadio();
        softAssert.assertEquals(differentElementsPage.getAllSelectedElements().get(0), expectedResult);
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "isSelenMetalRadioSelected")
    @Step
    public void isYellowColorFromDropDownListSelected() {
        String expectedResult = "Colors:Yellow";
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        differentElementsPage.selectYellowColor();
        softAssert.assertEquals(differentElementsPage.getAllSelectedElements().get(0), expectedResult);
        softAssert.assertAll();
    }
}
