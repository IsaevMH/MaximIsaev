package com.epam.tc.hw6.driver;

import com.epam.tc.hw3.service.Browser;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.management.openmbean.InvalidOpenTypeException;
import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriver {
    public static WebDriver createRemoteDriver(Browser browser) {
        Capabilities capabilities = null;
        if(browser.name() == "chrome") {
            capabilities = createRemoteChromeCapabilities();
        }
        else if(browser.name() == "firefox") {
            capabilities = createRemoteFirefoxCapabilities();
        }
        else {
            throw new IllegalArgumentException(String.format("Uncorrect value of browser type '%s'. " +
                    "Please, select correct type of browser", browser));
        }
        try {
            return new RemoteWebDriver(new URL("http://192.168.0.103:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new InvalidOpenTypeException("Incorrect selenium grid url");
        }
    }

    private static Capabilities createRemoteFirefoxCapabilities() {
        return new FirefoxOptions();
    }
    private static Capabilities createRemoteChromeCapabilities() {
        return new ChromeOptions();
    }
}
