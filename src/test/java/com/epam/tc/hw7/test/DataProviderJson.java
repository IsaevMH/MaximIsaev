package com.epam.tc.hw7.test;

import com.epam.tc.hw7.entity.LoginFormData;
import com.epam.tc.hw7.entity.MetalsColorsFormData;
import com.epam.tc.hw7.service.DataPropertyFileReader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class DataProviderJson {

    private DataProviderJson() {}

    @DataProvider(name = "metalsColorsTestData")
    public static Object[][] getObject() throws IOException {
        Map<String, MetalsColorsFormData> dataMap = new ObjectMapper()
                .readValue(new File(DataPropertyFileReader.getProperty("json")), new TypeReference<Map<String, MetalsColorsFormData>>() {});
        Object[][] res = convertToArrayOfObjects(dataMap);
        return res;
    }

    public static Object[][] convertToArrayOfObjects(Map<String, MetalsColorsFormData> data) {
        Object[][] resultArray = new Object[data.size()][1];
        int i = 0;
        for (Map.Entry<String, MetalsColorsFormData> dataEntry : data.entrySet()) {
            resultArray[i][0] = dataEntry.getValue();
            i++;
        }
        return resultArray;
    }

    public static LoginFormData USER = new LoginFormData();
}
