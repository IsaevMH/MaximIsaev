package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw1.providers.DataProviderTest;
import org.testng.annotations.Test;

public class SummationCalcTest extends BaseTest {

    @Test(groups = {"SumAndSub"}, dataProviderClass = DataProviderTest.class,
        dataProvider = "summation")
    public void summationTest(long firstDigit, long secondDigit, long expectedResult) {
        long resultOfSumming = calculator.sum(firstDigit, secondDigit);
        assertThat(resultOfSumming)
                .isEqualTo(expectedResult);
    }
}
