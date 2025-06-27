# Saucedemo Test Automation Project

## Launch URL
[Swag Labs](https://www.saucedemo.com/)

## Description:
This repository contains automated UI tests for the Sauce Demo application. The test execution is implemented with multithreading to improve performance.

## Use Cases Covered
- **UC-1: Empty Credentials** — attempt to log in with both username and password fields empty; verify the displayed error message.
- **UC-2: Missing Password** — attempt to log in with only the username provided; verify the appropriate error message.
- **UC-3: Successful Login** — log in with valid credentials and verify redirection to the main page.

## Technologies & Tools

- **Java 17** The primary programming language for writing test scripts.
- **Maven** For build and dependency management
- **JUnit 5** The testing framework for structuring and running unit tests.
- **Selenium WebDriver** Used for web browser automation and executing test scenarios, specifically in Google Chrome.
- **WebDriverManager** WebDriverManager automates the management of WebDriver binaries so you don't need to manually download or configure them.
- **Page Object Model**: Implemented with `@FindBy` annotations for efficient web element localization.
- **Hamcrest** Library for writing expressive and readable assertions in Java tests.
- **LOG4J**: For logging


## Setup & Running Tests
1. Clone the repository  
```bash
   git clone https://github.com/domagile/ta_training-java.git
   ```

2. Run tests  
  
    *Run tests in Chrome:*

   ```bash
   mvn clean test 
   ```
     
    *Run tests in Firefox:*
   ```bash
   mvn clean test -Dbrowser=firefox
   ```

   *Run tests in Edge:*
   ```bash
   mvn clean test -Dbrowser=edge
   ```
   
Test data can be taken from different files. Add "environment" property to define it:

   ```bash
   mvn clean test -Denvironment=qa 
   ```


3. To generate a report using one of the following command:  
- Report will be generated into temp folder and opened in browser.
   ```bash
   mvn allure:serve
   ```
or Report will be generated tо directory: target/site/allure-maven/index.html

   ```bash
   mvn allure:report
   ```

## Allure Integration for Test Reports and Screenshots

Allure was used to generate test reports and attach screenshots for failed tests.

### Report Generation

To install Allure, the step-by-step guide from the [official documentation](https://allurereport.org/docs/junit5/) was used.

To generate the report without installing Allure CLI, the step-by-step guide from the [Allure Maven GitHub page](https://github.com/allure-framework/allure-maven) was used.

### Screenshot Attachments

Screenshots for failed tests were configured according to the guide from the [official Allure documentation](https://allurereport.org/docs/guides/junit5-selenium-screenshots/).



## Project Structure Highlights ##
- **DriverSingleton** – centralizes WebDriver initialization and cleanup using the Singleton pattern. Supports thread-safe parallel execution.
- **Page Object Model** – implemented with @FindBy annotations for maintainable UI mapping.
- **BaseTest** – provides common setup/teardown for tests.
- **Maven Surefire Plugin** - tests are executed in parallel.
