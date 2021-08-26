package com.epam.tc.hw7.page;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import org.openqa.selenium.WebElement;

public class IndexPage extends WebPage {

    @UI("div.profile-photo")
    public static WebElement userIcon;
    @UI("input#name")
    public static TextField login;
    @UI("input#password")
    public static TextField password;
    @UI("button#login-button")
    public static WebElement signInButton;
    @UI("//ul/li/a[text() = 'Metals & Colors']")
    public static WebElement metalsColorsMenuOption;
    @UI(".btn-login")
    public static Button logoutBtn;

    public static void logout() {
        userIcon.click();
        logoutBtn.click();
    }

}
