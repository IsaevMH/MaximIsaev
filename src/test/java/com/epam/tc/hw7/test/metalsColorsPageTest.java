package com.epam.tc.hw7.test;

import com.epam.tc.hw7.page.IndexPage;
import com.epam.tc.hw7.page.MetalsColorsPage;
import com.epam.tc.hw7.service.DataReader;
import com.epam.tc.hw7.service.JsonReader;
import com.epam.tc.hw7.testng.TestNGListener;
import com.google.gson.JsonElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(TestNGListener.class)
public class metalsColorsPageTest implements TestInit {

    @Test()
    public void testMetalsColorsPage() {
        List<List<String>> res = JsonReader.readInfoFromJsonFile();
        IndexPage indexPage = new IndexPage();
        indexPage.open();
        indexPage.userIcon.click();
        indexPage.login.setValue(DataReader.getProperty("login"));
        indexPage.password.setValue(DataReader.getProperty("passwd"));
        indexPage.signInButton.click();
        indexPage.metalsColorsMenuOption.click();

        MetalsColorsPage metalsColorsPage = new MetalsColorsPage();

    }
}
