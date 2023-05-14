package com.kwolszczak.antycaptcha.selenium.support;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import java.util.Arrays;

public class PageSupport {
    public static WebDriver driver;

    public static void initPageSupport(WebDriver driver){
        PageSupport.driver = driver;
    }

    public static void clearAndFill(WebElement editbox, WebElement testText){
        driver.findElement(By.name(editbox.getText().toLowerCase())).clear();
        driver.findElement(By.name(editbox.getText().toLowerCase())).sendKeys(testText.getText());
    }

    public static WebElement findBtn(WebElement button){
        String  buttonName= button.getText();
        WebElement searchedBtn=driver.findElement(By.xpath("//button[contains(text(),'"+buttonName+"')]"));

        return searchedBtn;
    }

    public static WebElement findRadioBtn(WebElement buttonName, int groupNumber) {
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
    public static void poligon(WebDriver driver)  {
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
    }

    public static void poligon_js(WebElement element){
         driver = ((RemoteWebElement ) element).getWrappedDriver();
        //all nodes -input/text/ br ... //($x("(//div[@class='row u-full-width'][1]//input[1]/following-sibling::node())"))
        //($x("(//div[@class='row u-full-width'][1]//input[1]/following-sibling::text())"))
        JavascriptExecutor js = (JavascriptExecutor) driver;
         element = driver.findElement(By.xpath("(//div[@class='row u-full-width'][1]//input[1]/following-sibling::input[1])"));

        String elementText = (String) js.executeScript("return arguments[0].nextSibling.nodeValue;", element);
        System.out.println("node value for text element: "+elementText);

    }

}
