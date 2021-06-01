package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/features/Balance.feature" }, 
		glue = { "com/stepdefinitions", "com/hooks" },
		plugin = { "pretty", "summary", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = false)

public class TestRunner {

}
