package com.kwolszczak.antycaptcha.selenium;

import com.kwolszczak.antycaptcha.selenium.pages.CommonPage;
import org.testng.asserts.SoftAssert;

public class AssertSupport {
    private static final String GOOD_ANSWER = "OK. Good answer";
    protected static SoftAssert softAssert= new SoftAssert();

    public static void verifyOutcome(CommonPage page){
        String currentOutcome = page.getActualOutcome();
        String expectedOutcome = page.getExpectedOutcome();

        softAssert.assertEquals(currentOutcome, expectedOutcome);
        softAssert.assertAll();
    }

    public static void verifySolution(CommonPage page){
        String currentSolutionAnswer = page.getActualOutcome();

        softAssert.assertEquals(currentSolutionAnswer,GOOD_ANSWER);
        softAssert.assertAll();
    }
}
