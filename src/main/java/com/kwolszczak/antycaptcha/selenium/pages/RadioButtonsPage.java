package com.kwolszczak.antycaptcha.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Arrays;
import java.util.List;

public class RadioButtonsPage extends CommonPage {

    @FindBy(xpath = "//tbody//td[2]//code")
    List<WebElement> stepsList;

    public RadioButtonsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RadioButtonsPage executeSteps() {
        int groupNumber = 0;
        WebElement radioButton;

        for (WebElement buttonName : stepsList) {
                radioButton = findRadioButton(buttonName,groupNumber);
                clickAndWait(radioButton);
                groupNumber++;
        }
        return this;
    }

    private WebElement findRadioButton(WebElement buttonName, int groupNumber) {
        // ("//div[h5[text()='Group 0:']]//text()[.='Beluga Brown']//preceding-sibling::input[1]")
        String radioButtonName = buttonName.getText();
        By radioBtnSelector=By.xpath("//div[h5[text()='Group "+groupNumber+":']]//text()[.='"+radioButtonName+"']//preceding-sibling::input[1]");

        return driver.findElement(radioBtnSelector);
    }



    /**
     * @deprecated
     * Instead of it use @findRadioButton method
     */
    @Deprecated(since = "1.0")
    public void poligon() throws InterruptedException {

        //kod HTML dla Group0
        String[] innerHTML = driver
                .findElement(By.xpath("(//div[@class='row u-full-width'][1])"))
                .getAttribute("innerHTML")
                .split("\n");

        // tymczasowa wartosc do zaznaczenia. Docelowo pobierana z listy krokow
        String singleStep = "Duck";

        //zaznaczenie checkbox dla powyzszego tekstu. Z kodu html wyciaga input value dla podanego dowolnego stringa
        //i zaznacza
        Arrays.stream(innerHTML)
                .filter(htmlLine -> htmlLine.contains(singleStep))
                .map(htmlLine -> htmlLine.split("value=")[1].split("\"")[1])
                .map(htmlLine -> driver.findElement(By.xpath("//input[@value='"+htmlLine+"']")))
                .forEach(WebElement::click);
        Thread.sleep(5000);
    }

}
