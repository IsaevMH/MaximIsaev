package com.epam.tc.hw3.test;

import com.epam.tc.hw3.page.IndexPage;

import java.util.Arrays;
import java.util.List;

import com.epam.tc.hw3.service.DataReader;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IndexPageTest extends BaseTest {

    @Test
    public void isUserLogin() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.openPage();
        indexPage.login(DataReader.getProperty("login"), DataReader.getProperty("passwd"));
        softAssert.assertEquals(indexPage.getUserName(), "ROMAN IOVLEV");
        softAssert.assertAll();
    }

    @Test
    public void isOptionsExistedOnPanelOfTheMainPage() {
        IndexPage indexPage = new IndexPage(driver);
        List<WebElement> elementsOfmenu = indexPage.getMenuOptions();
        List<String> expectedResultList = Arrays.asList(
                "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        for (int i = 0; i < elementsOfmenu.size() - 1; i++) {
            softAssert.assertEquals(elementsOfmenu.get(i).getText(), expectedResultList.get(i));
        }
        softAssert.assertAll();
    }

    @Test
    public void isFourImagesDiplayedOnTheIndexPage() {
        IndexPage indexPage = new IndexPage(driver);
        List<WebElement> images = indexPage.getListOfPicture();
        for (WebElement image : images) {
            softAssert.assertTrue(image.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Test
    public void isTextDisplayedUnderImage() {
        IndexPage indexPage = new IndexPage(driver);
        List<WebElement> texts = indexPage.getListOfText();
        for (WebElement text : texts) {
            softAssert.assertTrue(text.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Test
    public void isFrameWithButtonExisted() {
        IndexPage indexPage = new IndexPage(driver);
        softAssert.assertNotNull(indexPage.getFrame());
        softAssert.assertAll();
    }

    @Test
    public void isButtonContainedIntoTheFrame() {
        IndexPage indexPage = new IndexPage(driver);
        softAssert.assertEquals(indexPage.getFrameButton(), "Frame Button");
        softAssert.assertAll();
    }

    @Test
    public void isOptionsOfMenuOnTheLeftSideBarExisted() {
        IndexPage indexPage = new IndexPage(driver);
        List<WebElement> options = indexPage.getLeftMenuOptions();
        List<String> expectedResultList = Arrays.asList(
                "Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        for (int i = 0; i < options.size(); i++) {
            softAssert.assertEquals(options.get(i).getText(), expectedResultList.get(i));
        }
        softAssert.assertTrue(options.size() == 5);
        softAssert.assertAll();
    }
}
