package com.kwolszczak.antycaptcha.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
    protected final String seed = "73e29e99-2542-48a1-bffe-fa7f64470be1";
    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
