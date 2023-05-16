package com.kwolszczak.antycaptcha.cucumber;

import com.kwolszczak.antycaptcha.selenium.AssertSupport;
import com.kwolszczak.antycaptcha.selenium.BaseTest;
import com.kwolszczak.antycaptcha.selenium.pages.LandingPage;
import com.kwolszczak.antycaptcha.selenium.pages.ThreeButtonsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StepDefinitionImpl extends BaseTest {

    public LandingPage page;
    public ThreeButtonsPage threeButtonsPage;

    @Given("I landed on main page")
    public void I_landed_on_main_page(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("headless");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("^landing page is opened for user (.+)$")
    public void landing_page_is_opened_for_user(String name){
        page = new LandingPage(driver);
        System.out.println(name);

    }

    @When("I open three button page")
    public void i_opened_three_button_page(){
        threeButtonsPage = page.openThreeButtonsPage();
    }

    @When("execute all steps")
    public void execute_all_steps(){
        threeButtonsPage.executeSteps();

    }

    @When("check solution")
    public void check_solution(){
        threeButtonsPage.clickCheckSolution();

    }
    @Then("^(.+) message is displayed on the page$")
    public void ok_messge_is_displayed_on_the_page(String ok){
        AssertSupport.verifySolution(threeButtonsPage);
        driver.quit();

    }
}
