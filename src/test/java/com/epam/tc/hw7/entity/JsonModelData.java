package com.epam.tc.hw7.entity;

import java.util.List;

public class JsonModelData {
    List<Integer> summary;
    List<String> elements;
    String color;
    String metals;
    List<String> vegetables;

    @Override
    public String toString() {
        return summary +
                " " + elements +
                " " + color +
                " " + metals +
                " " + vegetables;
    }
}
