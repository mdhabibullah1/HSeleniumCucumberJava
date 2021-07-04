Feature: Login
  Scenario: Login with valid credentials
    Given I go to this url "http://35.192.231.16/momscradle-admin-webapp/dashboard"
    Given I enter user name and password "bob@jijoty.org" "12345678"
