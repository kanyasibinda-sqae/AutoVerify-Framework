# Test Automation Framework

## Overview

This project is a **dynamic test automation framework** developed using **Selenium** and **Java**, with **TestNG** as the testing framework. It is designed to be flexible and scalable, making it applicable to a variety of web applications. Additionally, it integrates **Extent Reports** for detailed reporting of test execution.

## Key Features

- **Dynamic Framework**: The framework is not tied to a specific website or application, allowing for easy adaptation to multiple projects.
- **Selenium WebDriver**: Automates web browser interaction across various browsers.
- **TestNG**: Provides parallel test execution, grouping, and reporting features.
- **Extent Reports**: Generates comprehensive test execution reports with detailed logs, screenshots, and execution statuses.

## Technology Stack

- **Java**: Programming language used to develop the framework.
- **Selenium WebDriver**: Tool for browser automation.
- **TestNG**: Test execution framework for running automated tests.
- **Extent Reports**: For rich, interactive test execution reports.

## Setup and Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/kanyasibinda-sqae/AutoVerify-Framework
   ```

2. **Install Dependencies**:
   Ensure that **Java**, **Maven**, and **Selenium** WebDriver are installed and configured properly. Run the following command to install Maven dependencies:
   ```bash
   mvn clean install
   ```

3. **Configure Test Settings**:
   Adjust configurations like browser type and base URLs in the `config.properties` file to suit your testing needs.

## Running Tests

To execute tests, use the following command:

```bash
mvn test
```

Tests will be executed based on the configuration provided, and results will be generated in both the console and the Extent Reports.

## Reporting

After running tests, the generated **Extent Reports** can be found in the `extent-reports/` directory. These reports provide a detailed breakdown of the test execution, including:

- Test statuses (pass, fail, skip)
- Logs and error messages
- Screenshots (if configured)

## Contributing
