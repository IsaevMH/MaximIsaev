package com.epam.tc.hw6.service;

public enum Browser {
    chrome("chrome"), firefox("firefox");
    String type;
    Browser(String browser) {
        type = browser;
    }
}
