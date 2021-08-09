package com.epam.tc.hw3.page;

import com.epam.tc.hw3.utils.TextSpliterator;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage extends AbstractPage {

    private static String BASE_URL = "https://jdi-testing.github.io/jdi-light/different-elements.html";

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
    public DifferentElementsPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public DifferentElementsPage selectWaterAndWindCheckBoxes() {
        checkboxes.get(0).click();
        checkboxes.get(2).click();
        return this;
    }

    public DifferentElementsPage selectSelenMetalRadio() {
        radios.get(3).click();
        return this;
    }

    public DifferentElementsPage selectYellowColor() {
        dropDownList.click();
        colorsList.get(3).click();
        dropDownList.click();
        return this;
    }
    
    public List<String> getAllSelectedElements() {
        List<String> resultListOfElements = new ArrayList<>();
        for (WebElement log : logs) {
            resultListOfElements.add(TextSpliterator.split(log.getText()));
        }
        return resultListOfElements;
    }
}
