package com.epam.tc.hw7.utils;

import java.util.List;

public class StringCreatorUtil {

    public static String create(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(element -> stringBuilder.append(element + ", "));
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }
}
