package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    protected static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static final String login = "Roman";
    protected static final String password = "Jdi1234";
    protected WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        softAssert = new SoftAssert();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);
    }

    @AfterClass
    public void closeDriver() {
        driver.close();
    }
}
