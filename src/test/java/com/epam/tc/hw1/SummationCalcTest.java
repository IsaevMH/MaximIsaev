package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SummationCalcTest {
    private Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(groups = {"SumAndSub"}, dataProviderClass = DataProviderTest.class,
        dataProvider = "correct data")
    public void summationTest(long firstDigit, long secondDigit) {
        long resultOfSumming = calculator.sum(firstDigit, secondDigit);
        assertThat(resultOfSumming)
                .isEqualTo(firstDigit + secondDigit);
    }

    @AfterClass(alwaysRun = true)
    public void closeObject() {
        calculator = null;
    }
}
