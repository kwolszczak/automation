package com.kwolszczak.antycaptcha.selenium;

import com.kwolszczak.antycaptcha.selenium.pages.*;
import org.junit.jupiter.api.*;

class GeneralIntroductoryTests extends BaseTest {

    @Test
    @DisplayName("Exercise 1 - Three Buttons")
    void test_threeButtons() {

        ThreeButtonsPage page = new LandingPage(driver)
               .openThreeButtonsPage()
               .executeSteps();

        AssertSupport.verifyOutcome(page);

        page.clickCheckSolution();
        AssertSupport.verifySolution(page);
    }

    @Test
    @DisplayName("Exercise 2 - Editbox")
    void test_editbox()  {

        EditboxPage page =new LandingPage(driver)
                .openEditboxPage()
                .executeSteps();

        AssertSupport.verifyOutcome(page);

        page.clickCheckSolution();
        AssertSupport.verifySolution(page);
    }

    @Test
    @DisplayName("Exercise 3 - Dropdown List")
    void test_dropDownList() throws InterruptedException {

        DropDownListPage page =new LandingPage(driver)
                .dropDownListPage()
                .executeSteps();

        AssertSupport.verifyOutcome(page);

        page.clickCheckSolution();
        AssertSupport.verifySolution(page);
    }

    @Test
    @DisplayName("Exercise 4 - Radio Buttons")
    void test_radioButtons()  {

        RadioButtonsPage page =new LandingPage(driver)
                .openRadioButtonsPage()
                .executeSteps();

        AssertSupport.verifyOutcome(page);

        page.clickCheckSolution();
        AssertSupport.verifySolution(page);
    }
}
