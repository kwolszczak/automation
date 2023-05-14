package com.kwolszczak.antycaptcha.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage  {
    private WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'1 - Three buttons')]")
    WebElement threeButtonsBtn;

    @FindBy(xpath = "//a[contains(text(),'2 - Editbox')]")
    WebElement editboxBtn;

    @FindBy(xpath = "//a[contains(text(),'3 - Dropdown list')]")
    WebElement dropDownListBtn;

    @FindBy(xpath = "//a[contains(text(),'4 - Radio buttons')]")
    WebElement radioButtonsBtn;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://antycaptcha.amberteam.pl");
        PageFactory.initElements(driver,this);
    }

    public ThreeButtonsPage openThreeButtonsPage(){
        threeButtonsBtn.click();
        return new ThreeButtonsPage(driver);
    }

    public RadioButtonsPage openRadioButtonsPage(){
        radioButtonsBtn.click();
        return new RadioButtonsPage(driver);
    }

    public EditboxPage openEditboxPage(){
        editboxBtn.click();
        return new EditboxPage(driver);
    }

    public DropDownListPage dropDownListPage(){
        dropDownListBtn.click();
        return new DropDownListPage(driver);
    }

}
