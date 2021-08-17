package com.epam.tc.hw5.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public UserTablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to("url");
    }

    public List<String> getListOfSelectedUserType() {
        return listOfSelectedUserType.stream()
                .map(userType -> userType.getText())
                .collect(Collectors.toList());
    }

    public List<String> getListOfUserName() {
        return listOfUserName.stream()
                .map(userName -> userName.getText())
                .collect(Collectors.toList());
    }

    public List<String> getListOfTextUnderImages() {
        return listOfTextUnderImages.stream()
                .map(text -> text.getText())
                .collect(Collectors.toList());
    }

    public List<String> getListOflistOfCheckboxes() {
        return listOfCheckboxes.stream()
                .map(status -> status.getText())
                .collect(Collectors.toList());
    }

    public List<String> getUsersId() {
        return usersId.stream()
                .map(id -> id.getText())
                .collect(Collectors.toList());
    }

    public String getTitleOfThePage() {
        return titleOfThePage.getText();
    }

    public List<String> getUserTypesForRoman() {
        List<String> types =  usersTypesForRoman.stream()
                .map(webElement -> webElement.getText())
                .map(webElement -> webElement.replace("\n", ""))
                .flatMap(webelement -> Arrays.stream(webelement.split(" ")))
                .filter(element -> !element.isEmpty())
                .collect(Collectors.toList());
        return types;
    }
}
