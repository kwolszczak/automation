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
    WebElement btn1 ;

    @FindBy(id ="btnButton2" )
    WebElement btn2;

    @FindBy(xpath="//td[contains(text(),'Trail set')]" )
    WebElement expectedOutcome;

    @FindBy(id="trail" )
    WebElement actualOutcome;

    @FindBy(id="solution" )
    WebElement checkSolutionBtn;

    public ThreeButtonsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public ThreeButtonsPage executeSteps(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        for (WebElement button: stepsList) {
            if (button.getText().equalsIgnoreCase("B1")) {
                wait.until(ExpectedConditions.elementToBeClickable(btn1));
                btn1.click();
            } else if (button.getText().equalsIgnoreCase("B2")) {
                wait.until(ExpectedConditions.elementToBeClickable(btn2));
                btn2.click();
            }

        }
        return this;
    }

    public boolean checkSolution() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        int initialHashCode = actualOutcome.getText().hashCode();

        checkSolutionBtn.click();

         wait.until( webDriver -> {
             int currentHashCode = actualOutcome.getText().hashCode();
             return currentHashCode != initialHashCode;
         });

        return actualOutcome.getText().equalsIgnoreCase("OK. Good answer");
    }

    public boolean isActualOutcomeEqualExpectedOutcome(){
        String expectedOutcomeTXT =expectedOutcome.getText().split(":")[1].trim();
        String actualOutcomeTXT = actualOutcome.getText();

        return expectedOutcomeTXT.equalsIgnoreCase(actualOutcomeTXT);
    }

}
