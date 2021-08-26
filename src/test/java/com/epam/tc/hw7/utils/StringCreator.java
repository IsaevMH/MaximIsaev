package com.epam.tc.hw7.utils;

import java.util.List;

public class StringCreator {

    public static String create(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(element -> stringBuilder.append(element + ", "));
        return stringBuilder.toString().substring(0, stringBuilder.length() - 2);
    }
}
