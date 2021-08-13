package com.epam.tc.hw3.page;

import com.epam.tc.hw3.service.DataReader;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected static String BASE_URL = DataReader.getProperty("url");

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void openPage();
}
