package com.api.hooks;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class Hooks {

    //public Logger logger = LogManager.getLogManager().getLogger(String.valueOf(Hooks.class));
    //public Logger logger = (Logger) LoggerFactory.getLogger(Hooks.class);
   // public Logger logger = Logger.getLogger(String.valueOf(Hooks.class));
    public Logger logger = Logger.getLogger("devpinoyLogger");


    @BeforeSuite
    public void beforeScenario() {
       // PropertyConfigurator.configure("src/test/resources/log4j2.properties");
        logger.info("Starting scenario");
    }

    @AfterSuite
    public void afterScenario() {
        logger.info("Ending scenario");
    }
}
