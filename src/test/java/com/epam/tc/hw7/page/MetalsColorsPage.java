package com.epam.tc.hw7.page;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.tc.hw7.section.MetalsColorsForm;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class MetalsColorsPage extends WebPage {
    @UI("form.form")
    public static MetalsColorsForm metalsColorsForm;

    @UI("ul.results li")
    public static List<UIElement> result;

    public static List<String> getResult() {
        return result.stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }


}

