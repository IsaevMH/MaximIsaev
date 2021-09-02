package com.epam.tc.hw7.test;

import com.epam.tc.hw7.entity.MetalsColorsFormData;
import com.epam.tc.hw7.utils.ExpectedResultCreatorUtil;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import java.util.List;
import static com.epam.tc.hw7.page.MetalsColorsPage.getResult;
import static com.epam.tc.hw7.page.MetalsColorsPage.metalsColorsForm;
import static com.epam.tc.hw7.page.SiteJdi.indexPage;

public class MetalsColorsPageTest implements TestInit {

    @Test(dataProvider = "metalsColorsTestData", dataProviderClass = DataProviderJson.class)
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
