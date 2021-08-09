package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.BaseTest;
import com.epam.tc.hw2.TextSpliterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DifferentElementsPageTest extends BaseTest {

    @Test
    public void isTheTitleOfPageReceived() {
        String expectedResult = "Home Page";

        driver.navigate().to(BASE_URL);
        String pageTitle = driver.getTitle();

        softAssert.assertEquals(pageTitle, expectedResult);

        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "isTheTitleOfPageReceived")
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

    @Test(dependsOnMethods = "isUserLogIn")
    public void isOptionsChecked() {
        WebElement serviceButton = driver.findElement(By.xpath("//div//ul/li[@class='dropdown']"));
        serviceButton.click();

        WebElement differentElementsOption = driver.findElement(By.xpath("//ul/li/a[text() ='Different elements']"));
        differentElementsOption.click();

        List<WebElement> checkboxes = driver.findElements(By.className("label-checkbox"));
        checkboxes.get(0).click();
        checkboxes.get(2).click();

        List<WebElement> radios = driver.findElements(
                By.xpath("//div[@class='checkbox-row']/label[@class='label-radio']"));
        radios.get(3).click();

        WebElement dropDownList = driver.findElement(By.xpath("//div/select[@class='uui-form-element']"));
        dropDownList.click();
        List<WebElement> options = driver.findElements(By.xpath("//div/select[@class='uui-form-element']/option"));
        options.get(3).click();
        dropDownList.click();

        List<WebElement> logs = driver.findElements(By.xpath("//div[@class='info-panel-section']/ul/li"));

        String result = TextSpliterator.split(logs.get(2).getText());
        softAssert.assertEquals(result, "Wind:true");

        result = TextSpliterator.split(logs.get(3).getText());
        softAssert.assertEquals(result, "Water:true");

        result = TextSpliterator.split(logs.get(1).getText());
        softAssert.assertEquals(result, "metal:Selen");

        result = TextSpliterator.split(logs.get(0).getText());
        softAssert.assertEquals(result, "Colors:Yellow");

        softAssert.assertAll();
    }
}
