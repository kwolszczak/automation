package com.kwolszczak.antycaptcha.selenium.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ThreeButtonsPage {
    WebDriver driver;

    @FindBy(xpath = "//tbody//td[2]//code")
    List<WebElement> stepsList;

    @FindBy(id = "btnButton1")
    WebElement btn1;

    @FindBy(id = "btnButton2")
    WebElement btn2;

    @FindBy(xpath = "//td[contains(text(),'Trail set')]")
    WebElement expectedOutcome;

    @FindBy(id = "trail")
    WebElement actualOutcome;

    @FindBy(id = "solution")
    WebElement checkSolutionBtn;

    public ThreeButtonsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ThreeButtonsPage executeSteps() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        for (WebElement button : stepsList) {
            if (button.getText().equalsIgnoreCase(btn1.getText())) {
                clickAndWait(btn1);
            } else if (button.getText().equalsIgnoreCase(btn2.getText())) {
                clickAndWait(btn2);
            }
        }
        return this;
    }

    public String checkSolution() {
        clickAndWait(checkSolutionBtn);
        return actualOutcomeTXT();
    }

    public String actualOutcomeTXT() {
        String actualOutcomeTXT = actualOutcome.getText();
        return actualOutcomeTXT;
    }
    public String expectedOutcomeTXT(){
        String expectedOutcomeTXT = expectedOutcome.getText().split(":")[1].trim();
        return expectedOutcomeTXT;
    }

    /*
    * output [actualOutcome] doesn't return current value immediately
    * it takes some time after clicking button to get actual output.
    *
    * Method prevent flaky tests
    * */
    public void clickAndWait(WebElement button){
        int initialHashCode = actualOutcome.getText().hashCode();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

       // System.out.println("LOG: initial hashcode: "+initialHashCode+" ...For Button: "+button.getText());

        button.click();
        wait.until(webDriver -> {
            int currentHashCode = actualOutcome.getText().hashCode();
           // System.out.println("LOG:Waiting for change. Current hashcode."+currentHashCode);
            return currentHashCode != initialHashCode;
        });


    }

}
