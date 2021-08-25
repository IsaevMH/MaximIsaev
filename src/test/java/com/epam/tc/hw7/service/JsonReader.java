package com.epam.tc.hw7.service;

import com.epam.tc.hw7.test.DataProviderJson;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JsonReader {

    public static List<List<String>> readInfoFromJsonFile() {
        String pathToJsonFile = DataReader.getProperty("json");
        ObjectMapper objectMapper = new ObjectMapper();
        List<DataProviderJson> dataProviderJsonList = null;
//        try {
//            dataProviderJsonList = objectMapper.readValue(new File(pathToJsonFile), new TypeReference<List<DataProviderJson>>() {});
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return convertToListString(dataProviderJsonList);
    }

    private static List<List<String>> convertToListString(List<DataProviderJson> dataProviderJsonList) {
        List<List<String>> result =  dataProviderJsonList.stream()
                .map(element -> Arrays.stream(element.toString().split(" ")).collect(Collectors.toList()))
                .collect(Collectors.toList());
        return result;
    }
}
