package com.epam.tc.hw6.cucumber.step;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AssertionStep extends AbstractStep {

    @Then("Selected elements should be visible in log field on 'Different Elements' page")
    public void allSelectedElementsAreVisibleOnDifferentElementsPage() {
        List<String> expectedResult = Arrays.asList("Colors:Yellow", "metal:Selen", "Wind:true", "Water:true");
        List<String> getAllElement = differentElementsPage.getAllSelectedElements();
        Assertions.assertThat(getAllElement)
                .as("Lists don't match")
                .isEqualTo(expectedResult);
    }

    @Then("'User Table' page should be opened")
    public void userTablePageShouldBeOpenedTest() {
        String expectedResult = "Users";
        String actualResult = userTablePage.getTitleOfThePage();

        Assertions.assertThat(actualResult)
                .as("UserTable page wasn't opened")
                .isEqualTo(expectedResult);
    }
    @Then("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void usersTypeShouldBeDisplayedTest() {
        Assertions.assertThat(userTablePage.getListOfSelectedUserType().size())
                .as("Numbers of users types don't match with expectedResut")
                .isEqualTo(6);
    }
    @Then("6 Usernames should be displayed on Users Table on User Table Page")
    public void userNamesShouldBeDisplayedTest(){
        Assertions.assertThat(userTablePage.getListOfUserName().size())
                .as("Numbers of users names don't match with expectedResut")
                .isEqualTo(6);
    }
    @Then("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void textUnderImagesShouldBeDisplayedTest() {
        Assertions.assertThat(userTablePage.getListOfTextUnderImages().size())
                .as("Numbers of text under images don't match with expectedResut")
                .isEqualTo(6);
    }
    @Then("6 checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedTest() {
        Assertions.assertThat(userTablePage.getListOflistOfCheckboxes().size())
                .as("Numbers of users ID don't match with expectedResut")
                .isEqualTo(6);
    }
    @Then("User table should contain following values:")
    public void userShouldContainIdNameDescription(DataTable dataTable) {
        List<String> usersId = userTablePage.getUsersId();
        List<String> usersName = userTablePage.getListOfUserName();
        List<String> textUnderImages = userTablePage.getListOfTextUnderImages().stream()
                .map(element -> element.contains("Hulk") ?
                        element.replace("\n","") :
                        element.replace("\n"," "))
                .collect(Collectors.toList());
        List<String> dt = dataTable.asList().stream().skip(3).collect(Collectors.toList());
        int j = 0;

        for (int i = 0; i < usersId.size(); i++) {
            for(; j < dt.size(); j++) {
                Assertions.assertThat(usersId.get(i))
                        .as("Id doesn't match with expected id")
                        .isEqualTo(dt.get(j));
                Assertions.assertThat(usersName.get(i))
                        .as("Username doesn't match with expected username")
                        .isEqualTo(dt.get(j+1));
                Assertions.assertThat(textUnderImages.get(i))
                        .as("Text doesn't match with expected text")
                        .isEqualTo(dt.get(j+2));
                j+=3;
                break;
            }
        }
    }
    @Then("droplist should contain values in column Type for user Roman")
    public void dropDownListShouldContainThreeValues(DataTable dataTable) {
        List<String> dt = dataTable.asList().stream().skip(1).collect(Collectors.toList());
        List<String> valueType = userTablePage.getUserTypesForRoman();
        Assertions.assertThat(valueType).as("Types doesn't match with expected types").isEqualTo(dt);
    }

    @Then("1 log row has 'Vip: condition changed to true' text in log section")
    public void isVipConditionChangedToTrue() {
        String sergeyStatus = userTablePage.getLogs().get(0);
        Assertions.assertThat(sergeyStatus)
                .as("Status doesn't match with expexted status")
                .isEqualTo("Vip:true");
    }
}
