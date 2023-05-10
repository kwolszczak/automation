package com.kwolszczak.antycaptcha.playwright;

import com.kwolszczak.antycaptcha.playwright.BaseTestPW;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Deprecated
class TestExercisesPw extends BaseTestPW {
    @Test
    public void test_Alert() throws InterruptedException {
        //Arrange
        page.navigate("https://antycaptcha.amberteam.pl/stf/3-8-1?seed=" + seed);
        String alertBtn = "#showAlert";
        String alertInp = "//input[@id='alertText']";

        //Act
        page.onDialog(dialog -> {
            dialog.accept();
            page.fill(alertInp,dialog.message());
            });

        page.click(alertBtn);
        Thread.sleep(200);
        //Assert /then
        assertEquals("OK. Good answer", checkResult(page));
    }

    @Test
    public void test_openUrl() throws InterruptedException {
        //Arrange
        page.navigate("https://antycaptcha.amberteam.pl/stf/3-2-1?seed=" + seed);
        String newSeed = page.locator("//div//code").textContent().split(":")[1].trim();
        String newUrl = "http://antycaptcha.amberteam.pl/stf/3-2-1/solution?seed=" + newSeed;

        //Act
        page.navigate(newUrl);

        //Assert /then
        assertEquals("OK. Good answer", checkResult(page,true));

    }
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



        assertEquals("OK. Good answer", checkResult(page));
    }

    @Test
    public void test_radioButtons() throws InterruptedException {
        //Arrange /given
        page.navigate("https://antycaptcha.amberteam.pl/exercises/exercise4?seed=" + seed);

        String group0_element = "//input[@value='v80']";
        String group1_element = "//input[@value='v21']";
        String group2_element = "//input[@value='v02']";
        String group3_element = "//input[@value='v43']";

        //Act/when
        page.click(group0_element);
        page.click(group1_element);
        page.click(group2_element);
        page.click(group3_element);

        //Assert /then
        assertEquals("OK. Good answer", checkResult(page));
    }

    @Test
    public void test_editbox() throws InterruptedException {
        //Arrange /given
        page.navigate("https://antycaptcha.amberteam.pl/exercises/exercise2?seed=" + seed);
        String inp = "#t14";
        String btn1 = "#btnButton1";

        //Act/when
        page.fill(inp,"Machine apply issue development.");
        page.click(btn1);

        //Assert /then
        assertEquals("OK. Good answer", checkResult(page));
    }
    @Test
    public void test_dropdownList() throws InterruptedException {
        //Arrange /given
        page.navigate("https://antycaptcha.amberteam.pl/exercises/exercise3?seed=" + seed);

        //Act
        page.locator("select#s13").selectOption("Amberlite Firemist");

        //Assert
        assertEquals("OK. Good answer", checkResult(page));
    }
    private static String checkResult(Page page) throws InterruptedException {
        String resultBtn = "//button[@id='solution']";
        String resultOutput = "//pre[@id='trail']";

        page.locator(resultBtn).click();
        Thread.sleep(300);
        return page.locator(resultOutput).textContent() ;

    }

    private static String checkResult(Page page,boolean simple) throws InterruptedException {
        String resultOutput = "//pre[@id='trail']";
        if(!simple){
            String resultBtn = "//button[@id='solution']";
            page.locator(resultBtn).click();
        }
        Thread.sleep(300);
        return page.locator(resultOutput).textContent() ;

    }
}