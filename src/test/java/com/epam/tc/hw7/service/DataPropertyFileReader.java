package com.epam.tc.hw7.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataPropertyFileReader {
    protected static Properties properties;

    static {
        try (FileInputStream fileInputStream =
                    new FileInputStream("src/test/resources/configurations/conf.properties")) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
