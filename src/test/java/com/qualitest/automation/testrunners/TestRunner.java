package com.qualitest.automation.testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/AppFeatures" }, 
		glue = { "com.qualitest.automation.stepdefinitions", "com.qualitest.automation.apphooks" }, 
		plugin = {
		"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
		"timeline:test-output-thread/"

}

)

public class TestRunner {

}
