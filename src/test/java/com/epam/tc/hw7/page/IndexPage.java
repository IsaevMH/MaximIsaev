package com.epam.tc.hw7.page;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.*;
import com.epam.tc.hw7.section.LoginForm;

import static com.epam.tc.hw7.test.DataProviderJson.USER;

public class IndexPage extends WebPage {

    @UI("div.profile-photo")
    public static Image userIcon;
    @UI("//a[text() = 'Metals & Colors']")
    public static Link metalsColorsMenuOption;
    @UI(".btn-login")
    public static Button logoutBtn;
    @UI("div.profile-photo span")
    public static Text loggedUserFullName;
    @UI("#login-form")
    public static LoginForm loginForm;

    public static void login() {
        userIcon.click();
        loginForm.fill(USER);
    }

    public static void logout() {
        userIcon.click();
        logoutBtn.click();
    }

}
