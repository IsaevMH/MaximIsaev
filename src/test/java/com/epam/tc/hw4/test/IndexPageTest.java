package com.epam.tc.hw4.test;

import com.epam.tc.hw4.page.IndexPage;
import com.epam.tc.hw4.service.DataReader;
import com.epam.tc.hw4.utils.ScreenshotListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Epic(value = "'Index' page test")
@Listeners(value = ScreenshotListener.class)
public class IndexPageTest extends BaseTest {

    @Test
    @Description("Test checks that user is logged in")
    @Feature(value = "Auth test")
    @Story(value = "User login test")
    public void isUserLogin() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.openPage();
        indexPage.login(DataReader.getProperty("login"), DataReader.getProperty("passwd"));
        Assertions.assertThat(indexPage.getUserName())
                .as("User doesnt' exist")
                .isEqualTo("ROMAN IOVLEV");
    }

    @Test
    @Description("Test checks that menu options are existed on the top panel")
    @Feature(value = "Exist/Display item test")
    @Story(value = "Options menu test")
    public void isOptionsExistedOnPanelOfTheMainPage() {
        IndexPage indexPage = new IndexPage(driver);
        List<String> elementsOfmenu = indexPage.getMenuOptions().stream()
                .map(element -> element.getText())
                .filter(element -> !element.isEmpty())
                .collect(Collectors.toList());
        List<String> expectedResultList = Arrays.asList(
                "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        Assertions.assertThat(elementsOfmenu)
                .as("Lists of menu elements don't match")
                .isEqualTo(expectedResultList);
    }

    @Test
    @Description("Test checks that menu options are existed on the left panel")
    @Feature(value = "Exist/Display item test")
    @Story(value = "Options menu test")
    public void isOptionsOfMenuOnTheLeftSideBarExisted() {
        IndexPage indexPage = new IndexPage(driver);
        List<String> options = indexPage.getLeftMenuOptions().stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
        List<String> expectedResultList = Arrays.asList(
                "Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        Assertions.assertThat(options.size())
                .as("Number of menu options less than 5")
                .isEqualTo(expectedResultList.size());
        Assertions.assertThat(options)
                .as("Menu options don't match")
                .isEqualTo(expectedResultList);
    }

    @Test
    @Description("Test checks that four images are existed on the 'Index' page")
    @Feature(value = "Exist/Display item test")
    @Story(value = "Field with text and image test")
    public void isFourImagesDiplayedOnTheIndexPage() {
        IndexPage indexPage = new IndexPage(driver);
        boolean areAllPicturesDisplayed = indexPage.getListOfPicture().stream()
                        .allMatch(webElement -> webElement.isDisplayed() == true);
        Assertions.assertThat(areAllPicturesDisplayed)
                .as("Picture aren't displayed")
                .isTrue();
    }

    @Test
    @Description("Test checks that four texts under images are displayed on the 'Index' page")
    @Feature(value = "Exist/Display item test")
    @Story(value = "Field with text and image test")
    public void isTextDisplayedUnderImage() {
        IndexPage indexPage = new IndexPage(driver);
        boolean areTextsDisplayed = indexPage.getListOfText().stream()
                .allMatch(webElement -> webElement.isDisplayed() == true);
        Assertions.assertThat(areTextsDisplayed)
                .as("Texts aren't displayed")
                .isTrue();
    }

    @Test
    @Description("Test checks that frame with button is existed on the 'Index' page")
    @Feature(value = "Exist/Display item test")
    @Story(value = "Frame and his items test")
    public void isFrameWithButtonExisted() {
        IndexPage indexPage = new IndexPage(driver);
        Assertions.assertThat(indexPage.getFrame())
                .as("Frame doesn't exist")
                .isNotNull();
    }

    @Test
    @Description("Test checks that button is contained into the frame")
    @Feature(value = "Exist/Display item test")
    @Story(value = "Frame and his items test")
    public void isButtonContainedIntoTheFrame() {
        IndexPage indexPage = new IndexPage(driver);
        Assertions.assertThat(indexPage.getFrameButton())
                .as("Frame button doesn't exist")
                .isEqualTo("Frame Button");
    }
}
