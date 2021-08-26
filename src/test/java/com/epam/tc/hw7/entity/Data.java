package com.epam.tc.hw7.entity;

import com.epam.jdi.tools.DataClass;
import com.epam.tc.hw7.utils.StringCreator;

import java.util.List;

public class Data extends DataClass<Data> {
    List<Integer> summary;
    List<String> elements;
    String color;
    String metals;
    List<String> vegetables;

    public List<Integer> getSummary() {
        return summary;
    }

    public void setSummary(List<Integer> summary) {
        this.summary = summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }

//    @Override
//    public String toString() {
//        return "Summary: " + summary.stream().mapToInt(Integer::intValue).sum() +
//                ";Elements: " + StringCreator.create(elements) +
//                ";Color: " + color  +
//                ";Metals: " + metals +
//                ";Vegetables: " + StringCreator.create(vegetables);
//    }
}
