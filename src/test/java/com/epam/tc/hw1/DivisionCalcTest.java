package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DivisionCalcTest {

    private Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(groups = {"MultAndDiv"}, dataProviderClass = DataProviderTest.class,
            dataProvider = "correct data")
    public void divisionTest(long firstDigit, long secondDigit) {
        long resultOfDivision = calculator.div(firstDigit, secondDigit);
        assertThat(resultOfDivision)
                .isEqualTo(firstDigit / secondDigit);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        calculator = null;
    }
}
