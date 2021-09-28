package com.epam.tc.hw7.section;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entity.MetalsColorsFormData;

public class MetalsColorsForm extends Form<MetalsColorsFormData> {
    @UI("#odds-selector input")
    public static RadioButtons summFirstRow;
    @UI("#even-selector input")
    public static RadioButtons summSecondRow;
    @UI("#elements-checklist input")
    public static Checklist elements;
    @JDropdown(root = "#colors", value = "span.filter-option", list = "li")
    public static Dropdown colors;
    @JDropdown(root = "#metals", value = "span.filter-option", list = "li", expand = ".caret")
    public static Dropdown metals;
    @Css("button#submit-button")
    public static Button submitButton;
    @JDropdown(root = "#vegetables", value = "span.filter-option", list = "li", expand = ".caret")
    public static Dropdown vegetables;

    @Override
    public void fill(MetalsColorsFormData metalsColorsFormData) {
        summFirstRow.select(metalsColorsFormData.getSummary().get(0).toString());
        summSecondRow.select(metalsColorsFormData.getSummary().get(1).toString());
        for (String element : metalsColorsFormData.getElements()) {
            elements.select(element);
        }

        colors.select(metalsColorsFormData.getColor());
        metals.select(metalsColorsFormData.getMetals());

        vegetables.select("Vegetables");
        for (String vegetable : metalsColorsFormData.getVegetables()) {
                vegetables.select(vegetable);
        }
    }

    @Override
    public void submit() {
        submitButton.click();
    }
}
