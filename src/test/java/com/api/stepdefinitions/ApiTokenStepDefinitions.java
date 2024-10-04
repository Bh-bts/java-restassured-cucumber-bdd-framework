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

public class ApiTokenStepDefinitions {
    private Response response;
    private final Logger logger = LogManager.getLogger(ApiTokenStepDefinitions.class);
    private final ConfigLoader configLoader = new ConfigLoader();

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

    @When("User sends a POST request to {string} with valid credentials")
    public void user_sends_a_post_request_to_(String endpoint) {
        /*Map<String, String> body = new HashMap<>();
        body.put("username", "emilys");
        body.put("password", "emilyspass");
        body.put("expiresInMins", "30");
         */
        String jsonPayload = String.valueOf(ReadJSONFile.readJson("src/test/resources/payload/login.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        Login requestBody;
        try {
            requestBody = objectMapper.readValue(jsonPayload, Login.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        response = given().contentType("application/json").body(requestBody).when().post(endpoint);
    }

    @Then("User should receive a valid authentication token {string}")
    public void user_should_receive_a_valid_authentication_token(String token) {
        Assert.assertNotNull(response.jsonPath().get(token), "Token not found: " + token);
    }

    @Then("API response status code should be {int}")
    public void api_response_status_code_should_be_(Integer statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode.intValue());
    }
}