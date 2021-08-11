package com.epam.tc.hw3.test;

import com.epam.tc.hw3.page.IndexPage;

import java.util.Arrays;
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
    public void isUserLogout() {
        String userName = new IndexPage(driver)
                .openPage()
                .logout()
                .getUserName();
        softAssert.assertEquals(userName, "");
        softAssert.assertAll();
    }

    @Test
    public void isOptionsExistedOnPanelOfTheMainPage() {
        List<WebElement> elementsOfmenu = new IndexPage(driver)
                .openPage()
                .getMenuOptions();
        List<String> expectedResultList = Arrays.asList(
                "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        for (int i = 0; i < elementsOfmenu.size() - 1; i++) {
            softAssert.assertEquals(elementsOfmenu.get(i).getText(), expectedResultList.get(i));
        }
        softAssert.assertAll();
    }

    @Test
    public void isFourImagesDiplayedOnTheIndexPage() {
        List<WebElement> images = new IndexPage(driver)
                .openPage()
                .getListOfPicture();
        for (WebElement image : images) {
            softAssert.assertTrue(image.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Test
    public void isTextDisplayedUnderImage() {

        List<WebElement> texts = new IndexPage(driver)
                .openPage()
                .getListOfText();
        for (WebElement text : texts) {
            softAssert.assertTrue(text.isDisplayed());
        }
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
        List<String> expectedResultList = Arrays.asList(
                "Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        for (int i = 0; i < options.size(); i++) {
            softAssert.assertEquals(options.get(i).getText(), expectedResultList.get(i));
        }
        softAssert.assertTrue(options.size() == 5);
        softAssert.assertAll();
    }
}
