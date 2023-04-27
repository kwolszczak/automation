package com.kwolszczak.antycaptcha;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class TestExercises {
    private WebDriver driver;
    private final String seed = "73e29e99-2542-48a1-bffe-fa7f64470be1";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://antycaptcha.amberteam.pl");
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }

    @Test
    public void test_threeButtons() throws InterruptedException {
        //Arrange /given
        driver.get("https://antycaptcha.amberteam.pl/exercises/exercise1?seed="+seed);

        //Act/when
        driver.findElement(By.id("btnButton1")).click();
        driver.findElement(By.id("btnButton2")).click();
            Thread.sleep(500);
        driver.findElement(By.id("btnButton2")).click();

        String result = checkSolution(driver);

        //Assert /then
        Assertions.assertEquals("OK. Good answer",result);

    }
    @Test
    public void test_editbox() throws InterruptedException {
        //Arrange /given
        driver.get("https://antycaptcha.amberteam.pl/exercises/exercise2?seed="+seed);

        //Act/when
        driver.findElement(By.id("t14")).clear();
        driver.findElement(By.id("t14")).sendKeys("Machine apply issue development.");
        driver.findElement(By.id("btnButton1")).click();

        String result = checkSolution(driver);

        //Assert /then
        Assertions.assertEquals("OK. Good answer",result);
    }

    @Test
    public void test_dropdownList() throws InterruptedException {
        //Arrange /given
        driver.get("https://antycaptcha.amberteam.pl/exercises/exercise3?seed="+seed);

        //Act/when
        WebElement  option = driver.findElement(By.id("s13"));
        option.click();

        Select select = new Select(option);
        //select.selectByValue("v8");
        select.selectByVisibleText("Amberlite Firemist");

        String result = checkSolution(driver);

        //Assert /then
        Assertions.assertEquals("OK. Good answer",result);
    }
    @Test
    public void test_radioButtons() throws InterruptedException {
        //Arrange /given
        driver.get("https://antycaptcha.amberteam.pl/exercises/exercise4?seed="+seed);
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
        Assertions.assertEquals("OK. Good answer",result);
    }

    private static String checkSolution(WebDriver driver) throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.cssSelector("button#solution")).click();
        Thread.sleep(500);
        return  driver.findElement(By.id("trail")).getText();
    }
}