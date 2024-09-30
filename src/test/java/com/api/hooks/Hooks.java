package com.api.hooks;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Hooks {

    public Logger logger = LogManager.getLogManager().getLogger(String.valueOf(Hooks.class));

    @BeforeSuite
    public void beforeScenario() {
        logger.info("Starting scenario");
    }

    @AfterSuite
    public void afterScenario() {
        logger.info("Ending scenario");
    }
}
