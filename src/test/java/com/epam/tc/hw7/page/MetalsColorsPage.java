package com.epam.tc.hw7.page;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MetalsColorsPage extends WebPage {

    @UI("div#summary-block > section.panel-gray > div.info-panel-body")
    public List<WebElement> summaries;
    @UI("div#elements-block > section > div > div >section")
    public List<Checkbox> elements;
    @UI("div#colors")
    public Dropdown colors;
    @UI("div#metals")
    public Dropdown metals;
    @UI("button#submit-button")
    public Button submitButton;
    @UI("div#vegetables")
    public Dropdown vegetables;
    @UI("ul.results")
    List<TextField> result;
}
