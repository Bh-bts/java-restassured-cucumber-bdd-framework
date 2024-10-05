package com.api.stepdefinitions;

import com.api.utils.ConfigLoader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;

/**
 * This class contains step definitions for executing API tests using RestAssured.
 */
public class ApiStepDefinitions {
    private Response response;
    private final ConfigLoader configLoader = new ConfigLoader();
    private static final Logger logger = LogManager.getLogger(ApiStepDefinitions.class);

    /**
     * Sets the base URL for the API by fetching it from the configuration.
     * Also clears any existing log files.
     */
    @Given("User set the API base URL")
    public void user_set_the_api_base_url() {
        logger.info("Setting API base URL");
        File logFile = new File("logs/LogsGenerated.log");

        if (logFile.exists()) {
            try {
                new FileOutputStream(logFile, false).close(); // Clear the log file
                logger.info("Cleared previous log file.");
            } catch (IOException e) {
                logger.error("Failed to clear log file.", e);
            }
        }

        String baseUrl = configLoader.getBaseUrl();
        if (baseUrl == null) {
            logger.error("Base URL not found in configuration");
        }
        RestAssured.baseURI = baseUrl;
        logger.info("API Base URL set to: " + baseUrl);
    }

    /**
     * Sends a GET request to the given API endpoint.
     * @param endpoint The API endpoint to which the GET request is sent.
     */
    @When("User send a GET request to {string}")
    public void user_send_a_request_to(String endpoint) {
        if (endpoint == null) {
            logger.error("Endpoint not found");
        }
        response = given().when().get(endpoint);
        logger.info("Sent GET request to endpoint: " + endpoint);
    }

    /**
     * Asserts that the API response status code matches the expected status code.
     * @param expectedStatusCode The expected HTTP status code.
     */
    @Then("the API response statue code should be {int}")
    public void the_response_status_code_should_be(Integer expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode.intValue(), "Status code mismatch");
        logger.info("API status code: " + expectedStatusCode);
    }

    /**
     * Asserts that the API response contains the expected data.
     * @param expectedKey The expected key in the JSON response.
     */
    @Then("the response should contain {string}")
    public void the_response_should_contain(String data) {
        Assert.assertNotNull(response.jsonPath().get(data));
        logger.info("API response:" + data);
    }
}
