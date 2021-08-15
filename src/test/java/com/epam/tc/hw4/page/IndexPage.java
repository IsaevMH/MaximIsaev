package com.epam.tc.hw4.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IndexPage extends AbstractPage {


    @FindBy(className = "dropdown-toggle")
    private List<WebElement> dropDownList;
    @FindBy(id = "name")
    private WebElement loginField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement enterButton;
    @FindBy(xpath = "//div[@class = 'logout']/button/span")
    private WebElement logoutButton;
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
    @FindBy(xpath = "//div//ul/li[@class='dropdown']")
    private WebElement serviceButton;
    @FindBy(xpath = "//ul/li/a[text() ='Different elements']")
    private WebElement differentElementsOption;

    public IndexPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public void login(String login, String password) {
        dropDownList.get(1).click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        enterButton.click();
    }

    public void logout() {
        dropDownList.get(1).click();
        logoutButton.click();
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

    public DifferentElementsPage gotToDifferentElementsPage() {
        serviceButton.click();
        differentElementsOption.click();
        return new DifferentElementsPage(driver);
    }
}
