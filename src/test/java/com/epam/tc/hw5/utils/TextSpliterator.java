package com.epam.tc.hw5.utils;

public class TextSpliterator {

    public static String split(String text) {
        String[] words = text.split("(\\s)");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(words[1]);
        stringBuilder.append(words[5]);
        return stringBuilder.toString();
    }
}
