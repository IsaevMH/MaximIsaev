package com.epam.tc.hw7.entity;

import com.epam.jdi.tools.DataClass;
import com.epam.tc.hw7.service.DataReader;

public class LoginFormData extends DataClass<LoginFormData> {
    String login;
    String password;

    public LoginFormData() {
        this.login = DataReader.getProperty("login");
        this.password = DataReader.getProperty("passwd");
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
