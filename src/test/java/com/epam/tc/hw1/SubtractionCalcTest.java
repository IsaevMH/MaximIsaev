package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw1.providers.DataProviderTest;
import org.testng.annotations.Test;

public class SubtractionCalcTest extends BaseTest {

    @Test(groups = {"SumAndSub"}, dataProviderClass = DataProviderTest.class,
            dataProvider = "subtraction")
    public void subtractionTest(long firstDigit, long secondDigit, long expectedResult) {
        long resultOfSubtraction = calculator.sub(firstDigit, secondDigit);
        assertThat(resultOfSubtraction)
                .isEqualTo(expectedResult);
    }
}
