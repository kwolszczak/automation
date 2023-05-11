package com.kwolszczak.antycaptcha.selenium;

import com.kwolszczak.antycaptcha.selenium.pages.LandingPage;
import com.kwolszczak.antycaptcha.selenium.pages.ThreeButtonsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;

 class GeneralIntroductoryTests extends BaseTest {
    @Test
    @DisplayName("Three Buttons")
    public void test_threeButtons() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

       ThreeButtonsPage threeButtonsPage = new LandingPage(driver)
               .openExercise1Page()
               .executeSteps();

       String currentOutcome = threeButtonsPage.actualOutcomeTXT();
       String expectedOutcome = threeButtonsPage.expectedOutcomeTXT();
       softAssert.assertEquals(currentOutcome,expectedOutcome);

        String currentSolutionAnswer = threeButtonsPage.checkSolution();
        softAssert.assertEquals(currentSolutionAnswer,"OK. Good answer");

        softAssert.assertAll();
    }
}
