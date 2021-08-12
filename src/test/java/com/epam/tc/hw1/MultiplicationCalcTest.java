package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw1.providers.DataProviderTest;
import org.testng.annotations.Test;

public class MultiplicationCalcTest extends BaseTest {

    @Test(groups = {"MultAndDiv"}, dataProviderClass = DataProviderTest.class,
            dataProvider = "multiplication")
    public void multiplicationTest(long firstDigit, long secondDigit, long expectedResult) {
        long resultOfMultiplication = calculator.mult(firstDigit, secondDigit);
        assertThat(resultOfMultiplication).as("Multiplication was wrong")
                .isEqualTo(expectedResult);
    }
}
