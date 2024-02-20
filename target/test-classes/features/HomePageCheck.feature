Feature: Check if home page and elements load correctly

  Background: The user is not logged in

  Scenario: 01 - Donate via home
    Given The worldwide home page is loaded
    Then the press centre button should be clickable