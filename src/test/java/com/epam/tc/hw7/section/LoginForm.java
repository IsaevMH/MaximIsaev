package com.epam.tc.hw7.section;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.tc.hw7.entity.LoginFormData;

public class LoginForm extends Form<LoginFormData> {

    @UI("input#name")
    public static TextField login;
    @UI("input#password")
    public static TextField password;
    @UI("button#login-button")
    public static Button signInButton;

    @Override
    public void fill(LoginFormData loginFormData) {
        login.setValue(loginFormData.getLogin());
        password.setValue(loginFormData.getPassword());
    }
}
