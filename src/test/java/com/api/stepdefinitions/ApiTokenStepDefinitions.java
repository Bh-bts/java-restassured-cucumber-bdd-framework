package com.api.stepdefinitions;

import com.api.request_payloads.Login;
import com.api.utils.ConfigLoader;
import com.api.utils.ReadJSONFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Step definition class for handling API authentication token-related tests.
 */
public class ApiTokenStepDefinitions {
    private Response response;
    private final Logger logger = LogManager.getLogger(ApiTokenStepDefinitions.class);
    private final ConfigLoader configLoader = new ConfigLoader();

    /**
     * Sets the base URL for the API by fetching it from the configuration file.
     */
    @Given("User provides the API base URL")
    public void user_provides_api_base_url() {
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

        String baseUrl1 = configLoader.getBaseUrl1();
        if (baseUrl1 == null) {
            logger.error("Base URL not found");
        }
        RestAssured.baseURI = baseUrl1;
        logger.info("API Base URL set to: " + baseUrl1);
    }

    /**
     * Sends a POST request to the given endpoint with valid user credentials.
     * The request body is loaded from a JSON file.
     * 
     * @param endpoint The API endpoint to send the POST request.
     */
    @When("User sends a POST request to {string} with valid credentials")
    public void user_sends_a_post_request_to_(String endpoint) {
        String jsonPayload = String.valueOf(ReadJSONFile.readJson("src/test/resources/payload/login.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        Login requestBody;
        try {
            requestBody = objectMapper.readValue(jsonPayload, Login.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to deserialize JSON payload", e);
        }
        response = given().contentType("application/json").body(requestBody).when().post(endpoint);
    }

    /**
     * Validates that a valid authentication token is returned in the response.
     * 
     * @param tokenKey The JSON key to locate the authentication token in the response.
     */
    @Then("User should receive a valid authentication token {string}")
    public void user_should_receive_a_valid_authentication_token(String token) {
        Assert.assertNotNull(response.jsonPath().get(token), "Token not found: " + token);
    }

    /**
     * Validates that the API response status code matches the expected status code.
     * 
     * @param expectedStatusCode The expected HTTP status code.
     */
    @Then("API response status code should be {int}")
    public void api_response_status_code_should_be_(Integer expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode.intValue(), "Unexpected status code");
    }
}