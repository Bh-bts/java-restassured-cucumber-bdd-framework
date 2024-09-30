package com.api.runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import cucumber.api.testng.CucumberFeatureWrapper;

@CucumberOptions(
        features = "src/test/java/resources/features",
        glue = "com.api.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-report.html"}
)

public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpCucumber() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    @Test
    public void feature(CucumberFeatureWrapper cucumberFeature){
        testNGCucumberRunner.runScenario(cu); runCucumber(cucumberFeature.getCucumberFeature());
    }
}
