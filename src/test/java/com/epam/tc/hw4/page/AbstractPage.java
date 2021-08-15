package com.epam.tc.hw4.page;

import com.epam.tc.hw4.service.DataReader;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected static String BASE_URL = DataReader.getProperty("url");

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public abstract void openPage();
}
