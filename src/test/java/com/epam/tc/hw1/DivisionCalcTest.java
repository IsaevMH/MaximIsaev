package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw1.providers.DataProviderTest;
import org.testng.annotations.Test;

public class DivisionCalcTest extends BaseTest {

    @Test(groups = {"MultAndDiv"}, dataProviderClass = DataProviderTest.class,
            dataProvider = "division")
    public void divisionTest(long firstDigit, long secondDigit, long expectedResult) {
        long resultOfDivision = calculator.div(firstDigit, secondDigit);
        assertThat(resultOfDivision)
                .isEqualTo(expectedResult);
    }

}
