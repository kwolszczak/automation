package com.kwolszczak.antycaptcha.selenium.pages;

import com.kwolszczak.antycaptcha.selenium.support.PageSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EditboxPage extends CommonPage {

    @FindBy(xpath = "//tbody/tr[3]//code[1]")
    WebElement button;

    @FindBy(xpath = "//tbody/tr[2]//code[2]")
    WebElement editbox;

    @FindBy(xpath = "//tbody/tr[2]//code[1]")
    WebElement testText;

    public EditboxPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public EditboxPage executeSteps() {
        WebElement searchedBtn= PageSupport.findBtn(button);
        PageSupport.clearAndFill(editbox, testText);
        clickAndWait(searchedBtn);

        return this;
    }

}
