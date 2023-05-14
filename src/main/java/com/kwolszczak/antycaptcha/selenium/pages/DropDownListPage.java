package com.kwolszczak.antycaptcha.selenium.pages;

import com.kwolszczak.antycaptcha.selenium.support.PageSupport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownListPage extends CommonPage {

    @FindBy(xpath = "//tbody/tr[2]//code[1]")
    WebElement option;

    @FindBy(id = "s13")
    WebElement selectBtn;

    public DropDownListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public DropDownListPage executeSteps() {
        Select select = new Select(selectBtn);
        select.selectByVisibleText(option.getText());

        return this;
    }

}
