package com.kwolszczak.antycaptcha.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ThreeButtonsPage extends CommonPage {

    @FindBy(xpath = "//tbody//td[2]//code")
    List<WebElement> stepsList;

    @FindBy(id = "btnButton1")
    WebElement btn1;

    @FindBy(id = "btnButton2")
    WebElement btn2;

    public ThreeButtonsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ThreeButtonsPage executeSteps() {
        for (WebElement button : stepsList) {
            if (button.getText().equalsIgnoreCase(btn1.getText())) {
                clickAndWait(btn1);
            } else if (button.getText().equalsIgnoreCase(btn2.getText())) {
                clickAndWait(btn2);
            }
        }
        return this;
    }
}
