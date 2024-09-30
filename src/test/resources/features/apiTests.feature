Feature: API Testing with Rest Assured and BDD
  Scenario: Get all users
    Given User set the API base URL
    When User send a GET request to "/users"
    Then the API response statue code should be 200
    And the response should contain "data"

  Scenario: Get a single user
    Given User set the API base URL
    When User send a GET request to "/users/2"
    Then the API response statue code should be 200
    And the response should contain "data.id"
