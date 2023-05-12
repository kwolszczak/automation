package com.kwolszczak.antycaptcha.selenium;

import com.kwolszczak.antycaptcha.selenium.pages.*;
import org.junit.jupiter.api.*;

class GeneralIntroductoryTests extends BaseTest {

    @Test
    @DisplayName("Exercise 1 -Three Buttons")
    void test_threeButtons() {

        ThreeButtonsPage page = new LandingPage(driver)
               .openThreeButtonsPage()
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
