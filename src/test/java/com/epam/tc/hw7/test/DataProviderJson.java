package com.epam.tc.hw7.test;

import com.epam.tc.hw7.entity.Data;
import com.epam.tc.hw7.service.DataReader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class DataProviderJson {

    private DataProviderJson() {}

    @DataProvider(name = "test-data")
    public static Object[][] getObject() throws IOException {
        Map<String, Data> dataMap = new ObjectMapper()
                .readValue(new File(DataReader.getProperty("json")), new TypeReference<Map<String, Data>>() {});
        Object[][] res = convertToArrayOfObjects(dataMap);
        return res;
    }

    public static Object[][] convertToArrayOfObjects(Map<String, Data> data) {
        Object[][] resultArray = new Object[data.size()][1];
        int i = -1;
        for (Map.Entry<String, Data> dataEntry : data.entrySet()) {
            resultArray[++i][0] = dataEntry.getValue();
        }
        return resultArray;
    }
}
