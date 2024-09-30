package com.api.stepdefinitions;

import com.api.utils.ConfigLoader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class ApiStepDefinitions {
    private RequestSpecification request;
    private Response response;
    private final ConfigLoader configLoader = new ConfigLoader();

    @Given("User set the API base URL")
    public void user_set_the_api_base_url() {
        String baseUrl = configLoader.getBaseUrl();
        if (baseUrl == null) {
            throw new RuntimeException("Base Url not found");
        }
        RestAssured.baseURI = baseUrl;
    }

    @When("User send a GET request to {string}")
    public void user_send_a_request_to(String endpoint) {
        response = given().when().get(endpoint);
    }

    @Then("the API response statue code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        Assert.assertEquals(statusCode.intValue(), response.getStatusCode());
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain(String data) {
        Assert.assertNotNull(response.jsonPath().get(data));
    }
}
