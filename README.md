
🛠 ReqResAPITesting_RestAssured

Automated testing of the ReqRes API using Rest Assured and generated reports with Allure Report.


📄 About

This project focuses on automated testing of the ReqRes API, using Rest Assured for API requests and assertions. It includes a variety of tests for user and resource-related functionality, covering scenarios like listing users, handling single user requests, creating, updating, deleting users, and validating registration and login responses. Detailed reports are generated using Allure Report for test analysis.

🔧 Test Scenarios

Users:

List Users 

Get Single User

Single User Not Found

Resources:

List Resources

Get Single Resource

Single Resource Not Found

User Management:

Create User

Update User (PUT and PATCH)

Delete User

Authentication:

Register (Successful & Unsuccessful)

Login (Successful & Unsuccessful)

Delayed Response

✅ Results Overview

Total Requests: 13 test scenarios

Endpoints Covered: User, Resource, Authentication

Reporting: Detailed reports generated using Allure

🚀 Running the Tests

Clone the Repository:

git clone https://github.com/salwa1012/ReqResAPITesting_RestAssured.git

Install Dependencies (Assuming Maven is used):

mvn clean install

Run Tests:

mvn test

Generate Allure Report:

allure serve target/allure-results

📊 Test Reports

Test execution reports are generated with Allure and provide a detailed breakdown of passed, failed, and skipped tests, as well as insights into test durations and responses.
