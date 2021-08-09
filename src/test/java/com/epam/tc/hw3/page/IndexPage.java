package com.epam.tc.hw3.page;

import com.epam.tc.hw3.service.DataReader;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends AbstractPage {

    public static String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    @FindBy(className = "dropdown-toggle")
    private List<WebElement> dropDownList;
    @FindBy(id = "name")
    private WebElement loginField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement enterButton;
    @FindBy(xpath = "//div/div[@class='benefit']/div")
    List<WebElement> listOfPicture;
    @FindBy(xpath = "//div/span[@class='benefit-txt']")
    List<WebElement> listOfTexts;
    @FindBy(xpath = "//div/nav/ul/li")
    List<WebElement> listOfElementsMenu;
    @FindBy(id = "user-name")
    private WebElement userInfo;
    @FindBy(id = "frame")
    private WebElement frame;
    @FindBy(xpath = "//input[@id='frame-button']")
    private WebElement frameButton;
    @FindBy(xpath = "//ul[@class='sidebar-menu left']/li")
    private List<WebElement> leftMenuOptions;

    public IndexPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public IndexPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public IndexPage login() {
        dropDownList.get(1).click();
        loginField.sendKeys(DataReader.getProperty("login"));
        passwordField.sendKeys(DataReader.getProperty("passwd"));
        enterButton.click();
        return this;
    }

    public List<WebElement> getMenuOptions() {
        return listOfElementsMenu;
    }

    public List<WebElement> getListOfPicture() {
        return listOfPicture;
    }

    public List<WebElement> getListOfText() {
        return listOfTexts;
    }

    public String getUserName() {
        return userInfo.getText();
    }

    public WebElement getFrame() {
        return frame;
    }

    public String getFrameButton() {
        driver.switchTo().frame(driver.findElement(By.id("frame")));
        String nameButton = frameButton.getAttribute("value");
        driver.switchTo().defaultContent();
        return nameButton;
    }

    public List<WebElement> getLeftMenuOptions() {
        return leftMenuOptions;
    }
}
