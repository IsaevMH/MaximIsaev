package com.epam.tc.hw3.test;

import com.epam.tc.hw3.page.IndexPage;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IndexPageTest extends BaseTest {

    @Test
    public void isUserLogin() {
        String userName = new IndexPage(driver)
                .openPage()
                .login()
                .getUserName();
        softAssert.assertEquals(userName, "ROMAN IOVLEV");
        softAssert.assertAll();
    }

    @Test
    public void isOptionsExistedOnPanelOfTheMainPage() {
        List<WebElement> elementsOfmenu = new IndexPage(driver)
                .openPage()
                .getMenuOptions();
        softAssert.assertEquals(elementsOfmenu.get(0).getText(), "HOME");
        softAssert.assertEquals(elementsOfmenu.get(1).getText(), "CONTACT FORM");
        softAssert.assertEquals(elementsOfmenu.get(2).getText(), "SERVICE");
        softAssert.assertEquals(elementsOfmenu.get(3).getText(), "METALS & COLORS");
        softAssert.assertAll();
    }

    @Test
    public void isFourImagesDiplayedOnTheIndexPage() {
        List<WebElement> images = new IndexPage(driver)
                .openPage()
                .getListOfPicture();
        softAssert.assertTrue(images.get(0).isDisplayed());
        softAssert.assertTrue(images.get(1).isDisplayed());
        softAssert.assertTrue(images.get(2).isDisplayed());
        softAssert.assertTrue(images.get(3).isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void isTextDisplayedUnderImage() {

        List<WebElement> texts = new IndexPage(driver)
                .openPage()
                .getListOfText();

        softAssert.assertTrue(texts.get(0).isDisplayed());
        softAssert.assertTrue(texts.get(1).isDisplayed());
        softAssert.assertTrue(texts.get(2).isDisplayed());
        softAssert.assertTrue(texts.get(3).isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void isFrameWithButtonExisted() {
        WebElement frame = new IndexPage(driver)
                .openPage()
                .getFrame();
        softAssert.assertNotNull(frame);
        softAssert.assertAll();
    }

    @Test
    public void isButtonContainedIntoTheFrame() {
        String button = new IndexPage(driver)
                .openPage()
                .getFrameButton();
        softAssert.assertEquals(button, "Frame Button");
        softAssert.assertAll();
    }

    @Test
    public void isOptionsOfMenuOnTheLeftSideBarExisted() {
        List<WebElement> options = new IndexPage(driver)
                .openPage()
                .getLeftMenuOptions();

        softAssert.assertTrue(options.size() == 5);
        softAssert.assertEquals(options.get(0).getText(), "Home");
        softAssert.assertEquals(options.get(1).getText(), "Contact form");
        softAssert.assertEquals(options.get(2).getText(), "Service");
        softAssert.assertEquals(options.get(3).getText(), "Metals & Colors");
        softAssert.assertEquals(options.get(4).getText(), "Elements packs");

        softAssert.assertAll();
    }
}
