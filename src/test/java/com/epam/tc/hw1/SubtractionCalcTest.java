package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SubtractionCalcTest {
    private Calculator calculator;

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(groups = {"SumAndSub"}, dataProviderClass = DataProviderTest.class,
            dataProvider = "correct data")
    public void subtractionTest(long firstDigit, long secondDigit) {
        long resultOfSubtraction = 0L;
        resultOfSubtraction = calculator.sub(firstDigit, secondDigit);
        assertThat(resultOfSubtraction)
                .isEqualTo(firstDigit - secondDigit);
    }

    @AfterTest(alwaysRun = true)
    public void closeObject() {
        calculator = null;
    }
}
