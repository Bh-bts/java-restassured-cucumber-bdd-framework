# Java Rest Assured BDD Framework

----

Ready-to-use API Test Automation Architecture using Java, Rest Assured, and BDD.

# Run Test using GitHub Actions

## Test Execution

To execute tests using GitHub Actions, follow these steps:

1. Go to the "Actions" tab of your complete-java-restassured-bdd-framework repository.
2. Click on "Workflow" from the side menu.
3. Click on Run workflow dropdown button.
4. Select the branch you want to execute (e.g., "master").
5. Click on the "Run workflow" button.

# Run Test Locally

## Installation

1. Install java 8 jdk : I use java 11: https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html ( need free account )
2. Download Maven: https://maven.apache.org/install.html
3. clone complete-java-restassured-bdd-framework repository
4. Run this command in project folder: ```mvn clean compile```

## Running Test

This command run the test in parallel mode: ```mvn test -Dtest="testcases.**"```

## Test Report

After the tests, You can generate a report using: ```mvn surefire-report:report-only```

then ```mvn site -DgenerateReports=false```

After, go to `target/site/surefire-report.html` and you can see the report

# Languages and Frameworks

The project uses the following:

- Java 11 - Programming language used for writing the automation scripts
- REST Assured – Library for testing RESTful APIs in Java.
- Jackson – JSON parser for serialization and deserialization of request and response bodies.
- BDD (Behavior Driven Development) – Cucumber-style BDD framework to write test scenarios in a readable format.
- Maven – Build and dependency management tool.
- GitHub Actions – CI/CD pipeline for running automated tests in the cloud.

# Project Structure

---

The project is structured as follows:

```
complete-java-restassured-bdd-framework/
├── .github/
│   └── workflows/
│       └── api-restassured.yml          # GitHub Actions workflow for CI
├── src/
│   └── test/
│       └── java/
│           └── com/
│               └── api/
│                   ├── hooks/
│                   │   └── Hooks.java                     # Cucumber hooks (before/after steps)
│                   ├── request_payloads/
│                   │   └── Login.java                     # Java class representing login request payload
│                   ├── runners/
│                   │   └── TestRunner.java                # Cucumber test runner class
│                   ├── stepdefinitions/
│                   │   ├── ApiStepDefinitions.java        # Step defs for general API tests
│                   │   └── ApiTokenStepDefinitions.java   # Step defs for token-based API tests
│                   └── utils/
│                       ├── ConfigLoader.java              # Loads configuration properties
│                       └── ReadJSONFile.java              # Reads JSON files for payloads
├── resources/
│   ├── features/
│   │   ├── apiTests.feature           # Feature file for general API scenarios
│   │   └── apiTokenTests.feature      # Feature file for token scenarios
│   ├── payload/
│   │   └── login.json                 # JSON payload for login
│   ├── config.properties              # Configuration settings
│   └── log4j2.xml                     # Logging configuration
├── .gitignore                         # Files/folders to ignore in Git

```