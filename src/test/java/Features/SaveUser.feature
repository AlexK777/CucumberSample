Feature: SaveUserFeature
  This feature adds data to the User Form and clicks the Save button.

  Scenario: Saves a user.
    Given I navigate to the User Form page
    And I enter data into the required fields
    |title | Initial | FirstName | MiddleName |
    |Mr.   | PPP     | Peter     | Piper     |
    And I click the Save button
    Then The user is saved