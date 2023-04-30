package com.kwolszczak.antycaptcha_pw;

import com.kwolszczak.BaseTestPW;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitUntilState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Paths;

class TestExercisesPw extends BaseTestPW {
    @Test
    public void test_threeButtons() throws InterruptedException {
        page.navigate("https://antycaptcha.amberteam.pl/exercises/exercise1?seed=" + seed);

        String btn1 =  "//button[@id='btnButton1']";
        String btn2 =  "//button[@id='btnButton2']";
        String resultOutput = "//pre[@id='trail']";

        page.locator(btn1).click();
        Thread.sleep(100);
             System.out.println( "step 1 "+page.locator(resultOutput).textContent());

        page.locator(btn2).click();
        Thread.sleep(100);
             System.out.println( "step 2:"+page.locator(resultOutput).textContent());

        page.locator(btn2).click();
        Thread.sleep(100);
            System.out.println( "step 3: "+page.locator(resultOutput).textContent());



        Assertions.assertEquals("OK. Good answer", checkResult(page));
    }

    @Test
    public void test_dropdownList() throws InterruptedException {
        //Arrange /given
        page.navigate("https://antycaptcha.amberteam.pl/exercises/exercise3?seed=" + seed);

        //Act
        page.locator("select#s13").selectOption("Amberlite Firemist");

        //Assert
        Assertions.assertEquals("OK. Good answer", checkResult(page));
    }
    private static String checkResult(Page page) throws InterruptedException {
        String resultBtn = "//button[@id='solution']";
        String resultOutput = "//pre[@id='trail']";

        page.locator(resultBtn).click();
        Thread.sleep(200);
        return page.locator(resultOutput).textContent() ;

    }
}