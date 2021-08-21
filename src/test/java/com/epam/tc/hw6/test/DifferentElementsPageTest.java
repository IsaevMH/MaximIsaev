package com.epam.tc.hw6.test;

import com.epam.tc.hw6.page.DifferentElementsPage;
import com.epam.tc.hw6.page.IndexPage;
import com.epam.tc.hw6.service.DataReader;
import com.epam.tc.hw6.utils.ScreenshotListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Epic(value = "The 'Different Elements' page test")
@Listeners(value = ScreenshotListener.class)
public class DifferentElementsPageTest extends BaseTest {

    @Test
    @Description("Test checks that user is logged in")
    @Feature(value = "Auth test")
    @Story(value = "User login test")
    public void isUserLogin() {
        IndexPage indexPage =  new IndexPage(driver);

        indexPage.openPage();
        indexPage.login(DataReader.getProperty("login"),
                DataReader.getProperty("passwd"));

        Assertions.assertThat(indexPage.getUserName())
                .as("User doesn't exist")
                .isEqualTo("ROMAN IOVLEV");
    }

    @Test(dependsOnMethods = "isUserLogin")
    @Description("Test checks that water and wind checkboxes are selected")
    @Feature(value = "Select element test")
    @Story(value = "Checkbox test")
    public void areWaterAndWindCheckboxesSelected() {
        List<String> expectedResult = Arrays.asList("Wind:true", "Water:true");

        IndexPage indexPage = new IndexPage(driver);
        indexPage.gotToDifferentElementsPage();
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        differentElementsPage.selectWaterAndWindCheckBoxes();

        Assertions.assertThat(differentElementsPage.getAllSelectedElements())
                .as("List of elements don't match with expected result")
                .isEqualTo(expectedResult);
    }

    @Test(dependsOnMethods = "isUserLogin")
    @Description("Test checks that selen metal radio button is selected")
    @Feature(value = "Select element test")
    @Story(value = "Radio button test")
    public void isSelenMetalRadioSelected() {
        String expectedResult = "metal:Selen";
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);

        differentElementsPage.selectSelenMetalRadio();

        Assertions.assertThat(differentElementsPage.getAllSelectedElements().get(0))
                .as("Element doesn't match with expected result")
                .isEqualTo(expectedResult);
    }

    @Test(dependsOnMethods = "isUserLogin")
    @Description("Test checks that yellow color is selected from drop-down list")
    @Feature(value = "Select element test")
    @Story(value = "Drop-down list test")
    public void isYellowColorFromDropDownListSelected() {
        String expectedResult = "Colors:Yellow";
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);

        differentElementsPage.selectYellowColor();

        Assertions.assertThat(differentElementsPage.getAllSelectedElements().get(0))
                .as("Selected element doesn't match with expected result")
                .isEqualTo(expectedResult);
    }
}
