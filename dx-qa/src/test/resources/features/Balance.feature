Feature: Total Balance Feature

  Background: 
    Given user is on balance page

  Scenario: Right count of values appear on the screen
    Then count of values should be 5

  Scenario: Values on the screen are greater than Zero
    Then values should be greater than 0

  Scenario: Total balance is correct based on the values listed on the screen
    Then total balance should be 1000000

  Scenario: Values are formatted as currencies
    Then values should contain dollar "$" sign

  Scenario: Total balance matches the sum of the values
    Then total balance should match sum of all values
