package com.epam.tc.hw7.page;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import org.openqa.selenium.WebElement;

public class IndexPage extends WebPage {

    @UI("div.profile-photo")
    public WebElement userIcon;
    @UI("input#name")
    public static TextField login;
    @UI("input#password")
    public static TextField password;
    @UI("button#login-button")
    public WebElement signInButton;
    @UI("//ul/li/a[text() = 'Metals & Colors']")
    public WebElement metalsColorsMenuOption;
}
