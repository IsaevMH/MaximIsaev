package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.BaseTest;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class IndexPageTest extends BaseTest {
    @Test
    public void isAllTestsSuccessfulyCompleted() {
        //isTheTitleOfPageReceived
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //isUserLogIn
        List<WebElement> dropDownMenuButton = driver.findElements(By.className("dropdown-toggle"));
        dropDownMenuButton.get(1).click();

        WebElement loginField = driver.findElement(By.id("name"));
        loginField.sendKeys(login);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        WebElement enterButton = driver.findElement(By.id("login-button"));
        enterButton.click();

        WebElement actualName = driver.findElement(By.id("user-name"));
        String expectedName = "ROMAN IOVLEV";

        softAssert.assertEquals(actualName.getText(), expectedName);

        //isOptionsExistedOnPanelOfTheMainPage
        softAssert.assertEquals(driver.findElement(By.xpath("//a[text() = 'Home']")).getText(),
                "HOME");
        softAssert.assertEquals(driver.findElement(By.xpath("//a[text() = 'Contact form']")).getText(),
                "CONTACT FORM");
        softAssert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown']/a")).getText(),
                "SERVICE");
        softAssert.assertEquals(driver.findElement(By.xpath("//a[text() = 'Metals & Colors']")).getText(),
                "METALS & COLORS");

        //isFourImagesDiplayedOnTheIndexPage
        softAssert.assertTrue(driver.findElement(By.className("icon-practise")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.className("icon-custom")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.className("icon-multi")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.className("icon-base")).isDisplayed());

        //isTextDisplayedUnderImage
        String[] expectedTexts = new String[]{ "To include good practices\n" + "and ideas from successful\n"
                + "EPAM project", "To be flexible and\n"
                + "customizable", "To be multiplatform", "Already have good base\n"
                + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"};

        List<WebElement> textsUnderImages = driver.findElements(By.className("benefit-txt"));
        for (int i = 0; i < textsUnderImages.size(); i++) {
            softAssert.assertTrue(textsUnderImages.get(i).isDisplayed());
            softAssert.assertEquals(textsUnderImages.get(i).getText(), expectedTexts[i]);
        }

        //isFrameWithButtonExisted
        softAssert.assertNotNull(driver.findElement(By.id("frame")));

        //isButtonContainedIntoTheFrame
        driver.switchTo().frame(driver.findElement(By.id("frame")));
        WebElement frameButton = driver.findElement(By.xpath("//input[@id='frame-button']"));
        String actualResult = frameButton.getAttribute("value");
        driver.switchTo().defaultContent();
        softAssert.assertEquals(actualResult, "Frame Button");

        //isOptionsOfMenuOnTheLeftSideBarExisted
        List<WebElement> menuOptions = driver.findElements(By.xpath("//ul[@class='sidebar-menu left']/li"));
        List<String> expectedResultList = Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");
        for (int i = 0; i < menuOptions.size(); i++) {
            softAssert.assertEquals(menuOptions.get(i).getText(), expectedResultList.get(i));
        }
        softAssert.assertTrue(menuOptions.size() == 5);
        softAssert.assertAll();
    }
}
