package com.kwolszczak.antycaptcha;

import com.kwolszczak.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
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
    @Disabled("problem with certs on local machine- MAC")
    public void test_brokenLinks() throws IOException {
      /*  javax.net.ssl.SSLHandshakeException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
       FAQ:? https://bartlomiejchmielewski.pl/pkix-path-building-failed/*/

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        allLinks.forEach(e-> System.out.println(e.getText()));
        for (WebElement w :
                allLinks) {
            checkLink(w);
        }
    }

    private static List<WebElement> checkLink(WebElement we) throws IOException {
        List<WebElement> brokenLinks = new ArrayList<>();
        String link =we.getAttribute("href");

        //System.out.println(link);
        //String templink2 ="https://antycaptcha.amberteam.pl/stf/3-2-1?seed=4c6258aa-76ec-4686-b7d8-dba455be7fe4";
        HttpURLConnection connection = (HttpURLConnection) new URL(link).openConnection();

            connection.connect();
            int responseCode = connection.getResponseCode();
            if(responseCode >400){
                System.out.println("Broken link: "+we.getText()+" code: "+responseCode);
                brokenLinks.add(we);
            }

        return brokenLinks;
    }

    private static String checkSolution(WebDriver driver) throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.cssSelector("button#solution")).click();
        Thread.sleep(500);
        return driver.findElement(By.id("trail")).getText();
    }
}