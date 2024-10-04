Feature: User Authentication

  Scenario: User logs in and receives a token
    Given User provides the API base URL
    When User sends a POST request to "/login" with valid credentials
    Then User should receive a valid authentication token "accessToken"
    And API response status code should be 200
