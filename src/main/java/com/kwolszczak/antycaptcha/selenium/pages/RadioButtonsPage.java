package com.kwolszczak.antycaptcha.selenium.pages;

import com.kwolszczak.antycaptcha.selenium.support.PageSupport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class RadioButtonsPage extends CommonPage {

    @FindBy(xpath = "//tbody//td[2]//code")
    List<WebElement> stepsList;

    public RadioButtonsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public RadioButtonsPage executeSteps() {
        int groupNumber = 0;
        WebElement radioBtn;

        for (WebElement buttonName : stepsList) {
                radioBtn = PageSupport.findRadioBtn(buttonName,groupNumber);
                clickAndWait(radioBtn);
                groupNumber++;
        }
        return this;
    }


}
