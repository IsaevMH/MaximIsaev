package com.epam.tc.hw7.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.testng.annotations.DataProvider;

public class DataProviderJson {

    private DataProviderJson() {}

    @DataProvider(name = "test-data")
    public static <T> Object[][] getObject(InputStream json, Class<T> tClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        CollectionType collectionType = typeFactory.constructCollectionType(List.class, tClass);
        try {
            return objectMapper.readValue(json, collectionType);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
