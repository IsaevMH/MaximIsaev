package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class DataProviderTest {

    @DataProvider(name = "correct data")
    public static Object[][] correctData() {
        return new Object[][] {
                {6, 2},
                {-4, 2},
                {-8, -4}
        };
    }
}
