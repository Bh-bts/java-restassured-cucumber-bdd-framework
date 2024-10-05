package com.api.hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Hooks for setting up and tearing down scenarios for API testing.
 */
public class Hooks {

    private static final Logger logger = LogManager.getLogger(Hooks.class);

    /**
     * Logs the start of the test suite.
     */
    @BeforeSuite
    public void beforeScenario() {
        logger.info("Starting scenario");
    }

    /**
     * Logs the end of the test suite.
     */
    @AfterSuite
    public void afterScenario() {
        logger.info("Ending scenario");
    }
}
