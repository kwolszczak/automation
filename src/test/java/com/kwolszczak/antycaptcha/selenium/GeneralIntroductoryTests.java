package com.kwolszczak.antycaptcha.selenium;

import com.kwolszczak.antycaptcha.selenium.pages.LandingPage;
import com.kwolszczak.antycaptcha.selenium.pages.ThreeButtonsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;

public class GeneralIntroductoryTests extends BaseTest {
    @Test
    @DisplayName("Three Buttons")
    public void test_threeButtons() throws InterruptedException {

       ThreeButtonsPage threeButtonsPage = new LandingPage(driver)
               .openExercise1Page()
               .executeSteps();

       boolean isActualOutcomeEqualExpectedOutcome = threeButtonsPage.isActualOutcomeEqualExpectedOutcome();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isActualOutcomeEqualExpectedOutcome);

        Thread.sleep(10_000);

     /*   //Arrange /given
        driver.get("https://antycaptcha.amberteam.pl/exercises/exercise1?seed=" + seed);
        WebElement btn1 = driver.findElement(By.id("btnButton1"));
        WebElement btn2 = driver.findElement(By.id("btnButton2"));
        String result;

        //Act/when
        btn1.click();
        Thread.sleep(100);
        btn2.click();
        Thread.sleep(100);
        btn2.click();
        Thread.sleep(100);
        result = checkSolution(driver);

        //Assert /then
        Assertions.assertEquals("OK. Good answer", result);*/
    }
}
