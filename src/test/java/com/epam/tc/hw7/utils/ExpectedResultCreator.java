package com.epam.tc.hw7.utils;

import com.epam.tc.hw7.entity.Data;
import java.util.ArrayList;
import java.util.List;

public class ExpectedResultCreator {
    public static List<String> getExpectedResultList(Data data) {
        return new ArrayList<>() {
            {
                add(String.format("Summary: %d", data.getSummary().stream().mapToInt(Integer::intValue).sum()));
                add(String.format("Elements: %s", StringCreator.create(data.getElements())));
                add((String.format("Color: %s",data.getColor())));
                add((String.format("Metals: %s",data.getMetals())));
                add((String.format("Vegetables: %s",StringCreator.create(data.getVegetables()))));
            }
        };
    }
}
