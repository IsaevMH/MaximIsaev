package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class IndexPageTest extends BaseTest {

    @Test
    public void isTheTitleOfPageReceived() {
        String expectedResult = "Home Page";

        driver.navigate().to(BASE_URL);
        String pageTitle = driver.getTitle();

        softAssert.assertEquals(pageTitle, expectedResult);

        softAssert.assertAll();
    }

    @Test
    public void isUserLogIn() {
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

        softAssert.assertAll();
    }

    @Test
    public void isOptionsExistedOnPanelOfTheMainPage() {
        String expectedResult;

        expectedResult = "HOME";
        String linkName = driver.findElement(By.xpath("//a[text() = 'Home']")).getText();
        softAssert.assertEquals(linkName, expectedResult);

        expectedResult = "CONTACT FORM";
        linkName = driver.findElement(By.xpath("//a[text() = 'Contact form']")).getText();
        softAssert.assertEquals(linkName, expectedResult);

        expectedResult = "SERVICE";
        linkName = driver.findElement(By.xpath("//li[@class='dropdown']/a")).getText();
        softAssert.assertEquals(linkName, expectedResult);

        expectedResult = "METALS & COLORS";
        linkName = driver.findElement(By.xpath("//a[text() = 'Metals & Colors']")).getText();
        softAssert.assertEquals(linkName, expectedResult);

        softAssert.assertAll();
    }

    @Test
    public void isFourImagesDiplayedOnTheIndexPage() {
        boolean isPractiseImageDisplayed = driver.findElement(By.className("icon-practise")).isDisplayed();
        softAssert.assertTrue(isPractiseImageDisplayed);

        boolean isCustomImageDisplayed = driver.findElement(By.className("icon-custom")).isDisplayed();
        softAssert.assertTrue(isCustomImageDisplayed);

        boolean isMultiImageDisplayed = driver.findElement(By.className("icon-multi")).isDisplayed();
        softAssert.assertTrue(isMultiImageDisplayed);

        boolean isBaseImageDisplayed = driver.findElement(By.className("icon-base")).isDisplayed();
        softAssert.assertTrue(isBaseImageDisplayed);

        softAssert.assertAll();
    }

    @Test
    public void isTextDisplayedUnderImage() {
        String expectedText = "To include good practices\n" + "and ideas from successful\n" + "EPAM project";
        List<WebElement> textsUnderImages = driver.findElements(By.className("benefit-txt"));
        softAssert.assertTrue(textsUnderImages.get(0).isDisplayed());
        softAssert.assertEquals(textsUnderImages.get(0).getText(), expectedText);

        expectedText = "To be flexible and\n" + "customizable";
        softAssert.assertTrue(textsUnderImages.get(1).isDisplayed());
        softAssert.assertEquals(textsUnderImages.get(1).getText(), expectedText);

        expectedText = "To be multiplatform";
        softAssert.assertTrue(textsUnderImages.get(2).isDisplayed());
        softAssert.assertEquals(textsUnderImages.get(2).getText(), expectedText);

        expectedText = "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n"
                + "wish to get more…";
        softAssert.assertTrue(textsUnderImages.get(3).isDisplayed());
        softAssert.assertEquals(textsUnderImages.get(3).getText(), expectedText);

        softAssert.assertAll();
    }

    @Test
    public void isFrameWithButtonExisted() {
        WebElement frame = driver.findElement(By.id("frame"));

        softAssert.assertNotNull(frame);
    }

    @Test
    public void isButtonContainedIntoTheFrame() {
        String expectedResult = "Frame Button";

        driver.switchTo().frame(driver.findElement(By.id("frame")));
        WebElement frameButton = driver.findElement(By.xpath("//input[@id='frame-button']"));
        String actualResult = frameButton.getAttribute("value");
        driver.switchTo().defaultContent();

        softAssert.assertEquals(actualResult, expectedResult);

        softAssert.assertAll();
    }

    @Test
    public void isOptionsOfMenuOnTheLeftSideBarExisted() {
        List<WebElement> menuOptions = driver.findElements(By.xpath("//ul[@class='sidebar-menu left']/li"));

        softAssert.assertTrue(menuOptions.size() == 5);
        softAssert.assertEquals(menuOptions.get(0).getText(), "Home");
        softAssert.assertEquals(menuOptions.get(1).getText(), "Contact form");
        softAssert.assertEquals(menuOptions.get(2).getText(), "Service");
        softAssert.assertEquals(menuOptions.get(3).getText(), "Metals & Colors");
        softAssert.assertEquals(menuOptions.get(4).getText(), "Elements packs");

        softAssert.assertAll();
    }
}
