package com.epam.tc.hw1.providers;

import org.testng.annotations.DataProvider;

public class DataProviderTest {

    @DataProvider(name = "summation")
    public static Object[][] correctDataForSum() {
        return new Object[][] {
                {6, 2, 8},
                {-4, 2, -2},
                {-8, -4, -12},
                {32, 4, 36},
                {3, 0, 3}
        };
    }

    @DataProvider(name = "subtraction")
    public static Object[][] correctDataForSub() {
        return new Object[][] {
                {1, 5, -4},
                {-7, -4, -3},
                {5, -5, 10},
                {0, 0, 0},
                {10, 4, 6}
        };
    }

    @DataProvider(name = "multiplication")
    public static Object[][] correctDataForMult() {
        return new Object[][] {
                {1, 1, 1},
                {5, 0, 0},
                {9, 2, 18},
                {4, -4, -16},
                {-5, -5, 25}
        };
    }

    @DataProvider(name = "division")
    public static Object[][] correctDataForDiv() {
        return new Object[][] {
                {0, 5, 0},
                {6, 2, 3},
                {10, 3, 3},
                {4, -4, -1},
                {-5, -1, 5}
        };
    }

}
