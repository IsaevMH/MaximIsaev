package com.epam.tc.hw3.test;

import com.epam.tc.hw3.page.DifferentElementsPage;
import com.epam.tc.hw3.page.IndexPage;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;


public class DifferentElementsPageTest extends BaseTest {

    @Test
    public void isUserLogin() {
        String userName = new IndexPage(driver)
                .openPage()
                .login()
                .getUserName();
        softAssert.assertEquals(userName, "ROMAN IOVLEV");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "isUserLogin")
    public void areWaterAndWindCheckboxesSelected() {
        List<String> expectedResult = Arrays.asList("Wind:true", "Water:true");

        List<String> checkedWindAndWaterCheckBoxesResult = new IndexPage(driver)
                .openPage()
                .gotToDifferentElementsPage()
                .selectWaterAndWindCheckBoxes()
                .getAllSelectedElements();
        softAssert.assertEquals(checkedWindAndWaterCheckBoxesResult, expectedResult);
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "areWaterAndWindCheckboxesSelected")
    public void isSelenMetalRadioSelected() {
        String expectedResult = "metal:Selen";
        String metalActualResult = new DifferentElementsPage(driver)
                .selectSelenMetalRadio()
                .getAllSelectedElements()
                .get(0);
        softAssert.assertEquals(metalActualResult, expectedResult);
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "isSelenMetalRadioSelected")
    public void isYellowColorFromDropDownListSelected() {
        String expectedResult = "Colors:Yellow";
        String colorActualResult = new DifferentElementsPage(driver)
                .selectYellowColor()
                .getAllSelectedElements()
                .get(0);
        softAssert.assertEquals(colorActualResult, expectedResult);
        softAssert.assertAll();
    }
}
