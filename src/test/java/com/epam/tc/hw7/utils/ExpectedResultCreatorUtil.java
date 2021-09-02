package com.epam.tc.hw7.utils;

import com.epam.tc.hw7.entity.MetalsColorsFormData;

import java.util.ArrayList;
import java.util.List;

public class ExpectedResultCreatorUtil {
    public static List<String> getExpectedResultList(MetalsColorsFormData metalsColorsFormData) {
        return new ArrayList<>() {
            {
                add(String.format("Summary: %d", metalsColorsFormData.getSummary().stream().mapToInt(Integer::intValue).sum()));
                add(String.format("Elements: %s", StringCreatorUtil.create(metalsColorsFormData.getElements())));
                add((String.format("Color: %s", metalsColorsFormData.getColor())));
                add((String.format("Metals: %s", metalsColorsFormData.getMetals())));
                add((String.format("Vegetables: %s", StringCreatorUtil.create(metalsColorsFormData.getVegetables()))));
            }
        };
    }
}
