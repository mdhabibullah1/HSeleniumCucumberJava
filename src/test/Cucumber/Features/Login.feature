Feature: Login
  Scenario: Login with valid credentials
    Given I go to this url "http://35.192.231.16/momscradle-admin-webapp/dashboard"
    Given I enter user name and password "bob@jijoty.org" "12345678"
    When I click on Shopping Service
    And I click on Support Group
    And I click on Sessions
    And I click on Add New
    And I Select Support Group Name
    And I Enter Start Time
    And I Enter End Time
    And I Enter Maximum Size
    And I Select Location
    And I select Location Details
    And I Select Survey
    And I click on Save Button
