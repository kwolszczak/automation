package com.kwolszczak.antycaptcha.selenium.pages;

import com.kwolszczak.antycaptcha.selenium.support.PageSupport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CommonPage {
    WebDriver driver;

    @FindBy(xpath = "//td[contains(text(),'Trail set')]")
    WebElement expectedOutcome;

    @FindBy(id = "trail")
    WebElement actualOutcome;

    @FindBy(id = "solution")
    WebElement checkSolutionBtn;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageSupport.initPageSupport(driver);
    }

    public String clickCheckSolution() {
        clickAndWait(checkSolutionBtn);
        return getActualOutcome();
    }

    public String getActualOutcome() {
        return actualOutcome.getText();
    }

    public String getExpectedOutcome(){
        return expectedOutcome.getText().split("Trail set to:")[1].trim();
    }

    /*
     * actualOutcome output doesn't return current value immediately
     * it takes some time after clicking button to get current output.
     *
     * Method prevent flaky tests
     * */
    protected void clickAndWait(WebElement button){
        int initialHashCode = actualOutcome.getText().hashCode();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        button.click();

        wait.until(webDriver -> {
            int currentHashCode = actualOutcome.getText().hashCode();
            return currentHashCode != initialHashCode;
        });

    }
}
