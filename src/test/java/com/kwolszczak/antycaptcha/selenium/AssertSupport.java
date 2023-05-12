package com.kwolszczak.antycaptcha.selenium;

import com.kwolszczak.antycaptcha.selenium.pages.CommonPage;
import org.testng.asserts.SoftAssert;

public class AssertSupport {
    private static final String GOOD_ANSWER = "OK. Good answer";
    private static String currentOutcome;
    private static String expectedOutcome;
    private static String currentSolutionAnswer;
    protected static SoftAssert softAssert= new SoftAssert();

    public static void verifyOutcome(CommonPage page){
        currentOutcome = page.getActualOutcome();
        expectedOutcome = page.getExpectedOutcome();
        softAssert.assertEquals(currentOutcome,expectedOutcome);
        softAssert.assertAll();
    }

    public static void verifySolution(CommonPage page){
        currentSolutionAnswer = page.getActualOutcome();
        softAssert.assertEquals(currentSolutionAnswer,GOOD_ANSWER);
        softAssert.assertAll();
    }
}
