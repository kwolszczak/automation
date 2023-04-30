package com.kwolszczak.antycaptcha_pw;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitUntilState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

class TestExercisesPw {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void test_threeButtons() throws InterruptedException {
        String seed = "73e29e99-2542-48a1-bffe-fa7f64470be1";

        Playwright server = Playwright.create();
        Browser browser = server.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://antycaptcha.amberteam.pl/exercises/exercise1?seed=" + seed);

        String btn1 =  "//button[@id='btnButton1']";
        String btn2 =  "//button[@id='btnButton2']";
        String resultBtn = "//button[@id='solution']";
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

        page.locator(resultBtn).click();
        Thread.sleep(200);
            System.out.println("result:"+page.locator(resultOutput).textContent() );

        Assertions.assertEquals("OK. Good answer",page.locator(resultOutput).textContent() );

        context.close();
        server.close();
    }
}