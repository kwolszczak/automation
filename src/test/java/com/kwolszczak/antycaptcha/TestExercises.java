package com.kwolszczak.antycaptcha;

import com.kwolszczak.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


class TestExercises extends BaseTest {

    @Test
    @DisplayName("Three Buttons")
    public void test_threeButtons() throws InterruptedException {
        //Arrange /given
        driver.get("https://antycaptcha.amberteam.pl/exercises/exercise1?seed=" + seed);
        WebElement btn1 = driver.findElement(By.id("btnButton1"));
        WebElement btn2 = driver.findElement(By.id("btnButton2"));

        //Act/when
        btn1.click();
        btn2.click();//Thread.sleep(500);
        btn2.click();

        String result = checkSolution(driver);

        //Assert /then
        Assertions.assertEquals("OK. Good answer", result);

    }

    @Test
    @DisplayName("Edit box")
    public void test_editbox() throws InterruptedException {
        //Arrange /given
        driver.get("https://antycaptcha.amberteam.pl/exercises/exercise2?seed=" + seed);
        WebElement inp = driver.findElement(By.id("t14"));
        WebElement btn1 = driver.findElement(By.id("btnButton1"));

        //Act/when
        inp.clear();
        inp.sendKeys("Machine apply issue development.");
        btn1.click();

        String result = checkSolution(driver);

        //Assert /then
        Assertions.assertEquals("OK. Good answer", result);
    }

    @Test
    @DisplayName("Drop down list")
    public void test_dropdownList() throws InterruptedException {
        //Arrange /given
        driver.get("https://antycaptcha.amberteam.pl/exercises/exercise3?seed=" + seed);
        WebElement option = driver.findElement(By.id("s13"));

        //Act/when
        option.click();
        Select select = new Select(option);//select.selectByValue("v8");
        select.selectByVisibleText("Amberlite Firemist");

        String result = checkSolution(driver);

        //Assert /then
        Assertions.assertEquals("OK. Good answer", result);
    }

    @Test
    @DisplayName("Radion buttons")
    public void test_radioButtons() throws InterruptedException {
        //Arrange /given
        driver.get("https://antycaptcha.amberteam.pl/exercises/exercise4?seed=" + seed);
        WebElement group0element = driver.findElement(By.xpath("//input[@value='v80']"));
        WebElement group1element = driver.findElement(By.xpath("//input[@value='v21']"));
        WebElement group2element = driver.findElement(By.xpath("//input[@value='v02']"));
        WebElement group3element = driver.findElement(By.xpath("//input[@value='v43']"));

        //Act/when
        group0element.click();
        group1element.click();
        group2element.click();
        group3element.click();

        String result = checkSolution(driver);

        //Assert /then
        Assertions.assertEquals("OK. Good answer", result);
    }

    @Test
    @Tag("SMOKE")
    @DisplayName("Broken Links")
    public void test_brokenLinks(){
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        allLinks.forEach(e-> System.out.println(e.getText()));


    }

    private static String checkSolution(WebDriver driver) throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.cssSelector("button#solution")).click();
        Thread.sleep(500);
        return driver.findElement(By.id("trail")).getText();
    }
}