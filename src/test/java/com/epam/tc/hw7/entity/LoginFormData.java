package com.epam.tc.hw7.entity;

import com.epam.jdi.tools.DataClass;
import com.epam.tc.hw7.service.DataReader;

public class LoginFormData extends DataClass<LoginFormData> {
    String login;
    String password;
    String fullName;

    public LoginFormData() {
        this.login = DataReader.getProperty("login");
        this.password = DataReader.getProperty("passwd");
        fullName = "ROMAN IOVLEV";
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

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
