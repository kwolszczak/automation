package com.kwolszczak.antycaptcha.selenium;

import com.kwolszczak.antycaptcha.selenium.pages.CommonPage;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;

@Slf4j
public class AssertSupport {
    private static final String GOOD_ANSWER = "OK. Good answer";
    protected static SoftAssert softAssert= new SoftAssert();

    public static void verifyOutcome(CommonPage page){
        log.info(" werify outcome: ");

        String currentOutcome = page.getActualOutcome();
        String expectedOutcome = page.getExpectedOutcome();
        log.info("current out: "+currentOutcome+" expected out: "+expectedOutcome);

        softAssert.assertEquals(currentOutcome, expectedOutcome,"current outcome is different to expected");
       // softAssert.assertAll();
    }

    public static void verifySolution(CommonPage page){
        String currentSolutionAnswer = page.getActualOutcome();

        softAssert.assertEquals(currentSolutionAnswer,GOOD_ANSWER);
        softAssert.assertAll();
    }
}
