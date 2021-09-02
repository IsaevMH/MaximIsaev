package com.epam.tc.hw7.test;

import com.epam.tc.hw7.entity.MetalsColorsFormData;
import com.epam.tc.hw7.page.IndexPage;
import com.epam.tc.hw7.utils.ExpectedResultCreatorUtil;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import java.util.List;

import static com.epam.tc.hw7.page.IndexPage.loginForm;
import static com.epam.tc.hw7.page.MetalsColorsPage.getResult;
import static com.epam.tc.hw7.page.MetalsColorsPage.metalsColorsForm;
import static com.epam.tc.hw7.page.SiteJdi.indexPage;
import static com.epam.tc.hw7.test.DataProviderJson.USER;

public class MetalsColorsPageTest implements TestInit {

    @Test
    public void testIsUserLogin() {
        Assertions.assertThat(IndexPage.loggedUserFullName.getText())
                .as("Full name of logged user doesn't match with expected full name")
                .isEqualTo(USER.getFullName());
    }

    @Test(dataProvider = "metalsColorsTestData", dataProviderClass = DataProviderJson.class, dependsOnMethods = "testIsUserLogin")
    public void testMetalsColorsPage(MetalsColorsFormData metalsColorsFormData) {
        List<String> expectedResult = ExpectedResultCreatorUtil.getExpectedResultList(metalsColorsFormData);

        indexPage.metalsColorsMenuOption.click();
        metalsColorsForm.fill(metalsColorsFormData);
        metalsColorsForm.submit();

        List<String> result = getResult();

        Assertions.assertThat(result)
                .as("Actual list doesn't match with expected result")
                .isNotEqualTo(expectedResult);
    }
}
