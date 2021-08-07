package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DifferentElementsPageTest {
    private static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private static final String login = "Roman";
    private static final String password = "Jdi1234";
    private WebDriver driver;
    SoftAssert softAssert;

    @BeforeTest
    public void setUp() {
        softAssert = new SoftAssert();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);
    }

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

        String result = splitText(logs.get(2).getText());
        softAssert.assertEquals(result, "Wind:true");

        result = splitText(logs.get(3).getText());
        softAssert.assertEquals(result, "Water:true");

        result = splitText(logs.get(1).getText());
        softAssert.assertEquals(result, "metal:Selen");

        result = splitText(logs.get(0).getText());
        softAssert.assertEquals(result, "Colors:Yellow");

        softAssert.assertAll();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    public String splitText(String text) {
        String[] words = text.split("(\\s)");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(words[1]);
        stringBuilder.append(words[5]);
        return stringBuilder.toString();
    }

}
