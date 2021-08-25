package com.epam.tc.hw7.page;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJdi {
    @Url("/")
    public static IndexPage indexPage;
    @Url("/metals-colors")
    public static MetalsColorsPage metalsColorsPage;
}
