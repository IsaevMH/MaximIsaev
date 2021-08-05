package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MultiplicationCalcTest {

    private Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(groups = {"MultAndDiv"}, dataProviderClass = DataProviderTest.class,
            dataProvider = "correct data")
    public void multiplicationTest(long firstDigit, long secondDigit) {
        long resultOfMultiplication = calculator.mult(firstDigit, secondDigit);
        assertThat(resultOfMultiplication)
                .isEqualTo(firstDigit * secondDigit);
    }

    @AfterClass(alwaysRun = true)
    public void closeObject() {
        calculator = null;
    }
}
