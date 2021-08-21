package com.epam.tc.hw6.page;

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
    @FindBy(xpath = "//ul/li/ul/li/a[text()='User Table ']")
    private WebElement userTable;

    public IndexPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    @Step("Open 'Index' page")
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    @Step("Fill login and password fields")
    public void login(String login, String password) {
        dropDownList.get(1).click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        enterButton.click();
    }

    @Step("Click logout")
    public void logout() {
        dropDownList.get(1).click();
        logoutButton.click();
    }

    @Step("Get menu options")
    public List<WebElement> getMenuOptions() {
        return listOfElementsMenu;
    }

    @Step("Get list of pictures")
    public List<WebElement> getListOfPicture() {
        return listOfPicture;
    }

    @Step("Get list of texts")
    public List<WebElement> getListOfText() {
        return listOfTexts;
    }

    @Step("Get user name")
    public String getUserName() {
        return userInfo.getText();
    }

    @Step("Get frame")
    public WebElement getFrame() {
        return frame;
    }

    @Step("Get the frame button")
    public String getFrameButton() {
        driver.switchTo().frame(driver.findElement(By.id("frame")));
        String nameButton = frameButton.getAttribute("value");
        driver.switchTo().defaultContent();
        return nameButton;
    }

    @Step("Get left menu options")
    public List<WebElement> getLeftMenuOptions() {
        return leftMenuOptions;
    }

    @Step("Move to the 'Different Elements' page")
    public DifferentElementsPage gotToDifferentElementsPage() {
        serviceButton.click();
        differentElementsOption.click();
        return new DifferentElementsPage(driver);
    }

    @Step("Click on the 'Service' option")
    public void clickOnServiceOption() {
        serviceButton.click();
    }

    @Step("Click on the 'User Table' suboption")
    public void clickOnUserTableSubOption() {
        userTable.click();
    }


}
