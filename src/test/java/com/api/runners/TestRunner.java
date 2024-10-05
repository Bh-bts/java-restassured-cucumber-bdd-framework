package com.api.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Test runner for executing Cucumber tests using TestNG.
 * Configures feature files, step definitions, and report generation.
 */
@CucumberOptions(
        features = {"src/test/resources/features"}, // Path to feature files
        glue = {"com.api.stepdefinitions"},         // Package containing step definitions
        plugin = {"pretty", "html:target/cucumber-report.html"},  // Reporting plugins
        monochrome = true                           // Ensures console output is readable
)

public class TestRunner extends AbstractTestNGCucumberTests {
    // This class executes the tests as per Cucumber configurations
}
