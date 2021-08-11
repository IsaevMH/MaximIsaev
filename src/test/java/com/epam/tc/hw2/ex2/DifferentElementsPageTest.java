package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.BaseTest;
import com.epam.tc.hw2.TextSpliterator;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DifferentElementsPageTest extends BaseTest {
    @Test
    public void isAllTestsSuccessfulyCompleted() {
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

        softAssert.assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        //isOptionsChecked
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
        List<String> expectedResultList = Arrays.asList("Colors:Yellow", "metal:Selen", "Wind:true", "Water:true");

        for (int i = 0; i < logs.size(); i++) {
            softAssert.assertEquals(TextSpliterator.split(logs.get(i).getText()), expectedResultList.get(i));
        }

        softAssert.assertAll();
    }
}
