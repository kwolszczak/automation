package com.kwolszczak.antycaptcha.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/kwolszczak/antycaptcha/cucumber",
        glue = "com.kwolszczak.antycaptcha.cucumber",
        monochrome = true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
