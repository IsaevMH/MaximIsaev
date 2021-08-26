package com.epam.tc.hw7.test;

import com.epam.tc.hw7.entity.Data;
import com.epam.tc.hw7.page.IndexPage;
import com.epam.tc.hw7.page.MetalsColorsPage;
import com.epam.tc.hw7.service.DataReader;
import com.epam.tc.hw7.testng.TestNGListener;
import com.epam.tc.hw7.utils.ExpectedResultCreator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.tc.hw7.page.MetalsColorsPage.getResult;
import static com.epam.tc.hw7.page.MetalsColorsPage.metalsColorsForm;
import static com.epam.tc.hw7.page.SiteJdi.indexPage;
import static com.epam.tc.hw7.page.SiteJdi.metalsColorsPage;

@Listeners(TestNGListener.class)
public class metalsColorsPageTest implements TestInit {

    @Test(dataProvider = "test-data", dataProviderClass = DataProviderJson.class)
    public void testMetalsColorsPage(Data data) {
        List<String> expectedResult = ExpectedResultCreator.getExpectedResultList(data);
        indexPage.open();
        indexPage.userIcon.click();
        indexPage.login.setValue(DataReader.getProperty("login"));
        indexPage.password.setValue(DataReader.getProperty("passwd"));
        indexPage.signInButton.click();
        indexPage.metalsColorsMenuOption.click();

        metalsColorsForm.fill(data);
        metalsColorsForm.submit();

        List<String> result = getResult();

        Assertions.assertThat(result)
                .as("Actual list doesn't match with expected result")
                .isNotEqualTo(expectedResult);

        indexPage.logout();
    }
}
