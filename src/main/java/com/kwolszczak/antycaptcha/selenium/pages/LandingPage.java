package com.kwolszczak.antycaptcha.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'1 - Three buttons')]")
    WebElement threeButtonsBtn;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
      //  driver.get("https://antycaptcha.amberteam.pl");
        PageFactory.initElements(driver, this);
    }

    public ThreeButtonsPage openExercise1Page(){
        threeButtonsBtn.click();
        return new ThreeButtonsPage(driver);
    }

}
