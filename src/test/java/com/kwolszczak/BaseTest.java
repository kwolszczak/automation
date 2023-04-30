package com.kwolszczak;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected final String seed = "73e29e99-2542-48a1-bffe-fa7f64470be1";

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

}
