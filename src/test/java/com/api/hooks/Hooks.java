package com.api.hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Hooks {

    private static final Logger logger = LogManager.getLogger(Hooks.class);

    @BeforeSuite
    public void beforeScenario() {
        logger.info("Starting scenario");
    }

    @AfterSuite
    public void afterScenario() {
        logger.info("Ending scenario");
    }
}
