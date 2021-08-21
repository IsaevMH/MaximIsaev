package com.epam.tc.hw6.page;

import com.epam.tc.hw6.utils.TextSpliterator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;
    @FindBy(xpath = "//div[@class='checkbox-row']/label[@class='label-radio']")
    private List<WebElement> radios;
    @FindBy(xpath = "//div/select[@class='uui-form-element']")
    private WebElement dropDownList;
    @FindBy(xpath = "//div/select[@class='uui-form-element']/option")
    private List<WebElement> colorsList;
    @FindBy(xpath = "//div[@class='info-panel-section']/ul/li")
    private List<WebElement> logs;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    @Step("Open 'Different Elements' page")
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    @Step("Select water and wind checkboxes")
    public void selectWaterAndWindCheckBoxes() {
        checkboxes.get(0).click();
        checkboxes.get(2).click();
    }

    @Step("Select the Selen metal radio button")
    public void selectSelenMetalRadio() {
        radios.get(3).click();
    }

    @Step("Select yellow color from drop-down list")

    public void selectYellowColor() {
        dropDownList.click();
        colorsList.get(3).click();
        dropDownList.click();
    }

    @Step("Get all selected elements")
    public List<String> getAllSelectedElements() {
        List<String> resultListOfElements = new ArrayList<>();
        for (WebElement log : logs) {
            resultListOfElements.add(TextSpliterator.split(log.getText()));
        }
        return resultListOfElements;
    }
}
