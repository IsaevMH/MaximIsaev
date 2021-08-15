package com.epam.tc.hw4.page;

import com.epam.tc.hw4.utils.TextSpliterator;
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
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public void selectWaterAndWindCheckBoxes() {
        checkboxes.get(0).click();
        checkboxes.get(2).click();
    }

    public void selectSelenMetalRadio() {
        radios.get(3).click();
    }

    public void selectYellowColor() {
        dropDownList.click();
        colorsList.get(3).click();
        dropDownList.click();
    }
    
    public List<String> getAllSelectedElements() {
        List<String> resultListOfElements = new ArrayList<>();
        for (WebElement log : logs) {
            resultListOfElements.add(TextSpliterator.split(log.getText()));
        }
        return resultListOfElements;
    }
}
