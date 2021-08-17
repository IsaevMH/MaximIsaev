package com.epam.tc.hw5.page;

import com.epam.tc.hw5.utils.TextSpliterator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserTablePage extends AbstractPage {

    @FindBy(xpath = "//tbody/tr/td/select/option[@selected]")
    private List<WebElement> listOfSelectedUserType;

    @FindBy(xpath = "//tbody/tr[1]/td[2]/select")
    private List<WebElement> usersTypesForRoman;

    @FindBy(xpath = "//tbody/tr/td/a")
    private List<WebElement> listOfUserName;

    @FindBy(xpath = "//tbody/tr/td/div/span")
    private List<WebElement> listOfTextUnderImages;

    @FindBy(xpath = "//tbody/tr/td/div/input")
    private List<WebElement> listOfCheckboxes;

    @FindBy(className = "support-title")
    private WebElement titleOfThePage;

    @FindBy(xpath = "//tbody/tr/td[1]")
    private List<WebElement> usersId;

    @FindBy(xpath = "//tbody/tr/td/div/label")
    private List<WebElement> listOfStatus;

    @FindBy(xpath = "//section/div/div/ul/li")
    private List<WebElement> logs;

    public UserTablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to("url");
    }

    @Step("Get list of selected users types")
    public List<String> getListOfSelectedUserType() {
        return listOfSelectedUserType.stream()
                .map(userType -> userType.getText())
                .collect(Collectors.toList());
    }

    @Step("Get list of users names")
    public List<String> getListOfUserName() {
        return listOfUserName.stream()
                .map(userName -> userName.getText())
                .collect(Collectors.toList());
    }

    @Step("Get list of texts under images")
    public List<String> getListOfTextUnderImages() {
        return listOfTextUnderImages.stream()
                .map(text -> text.getText())
                .collect(Collectors.toList());
    }

    @Step("Get list of status checkboxes")
    public List<String> getListOflistOfCheckboxes() {
        return listOfCheckboxes.stream()
                .map(status -> status.getText())
                .collect(Collectors.toList());
    }

    @Step("Get list of users id")
    public List<String> getUsersId() {
        return usersId.stream()
                .map(id -> id.getText())
                .collect(Collectors.toList());
    }

    @Step("Get title of the page")
    public String getTitleOfThePage() {
        return titleOfThePage.getText();
    }

    @Step("Get users types for Roman")
    public List<String> getUserTypesForRoman() {
        List<String> types =  usersTypesForRoman.stream()
                .map(webElement -> webElement.getText())
                .map(webElement -> webElement.replace("\n", ""))
                .flatMap(webelement -> Arrays.stream(webelement.split(" ")))
                .filter(element -> !element.isEmpty())
                .collect(Collectors.toList());
        return types;
    }

    @Step("Click on vip checkbox for Sergey")
    public void clickOnVipCheckBoxForSergey() {
        listOfStatus.get(1).click();
    }

    @Step("Get all logs from log field")
    public List<String> getLogs() {
        List<String> resultListOfElements = new ArrayList<>();
        for (WebElement log : logs) {
            resultListOfElements.add(TextSpliterator.split(log.getText()));
        }
        return resultListOfElements;
    }
}
