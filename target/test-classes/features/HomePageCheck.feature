Feature: Check if home page and elements load correctly

  Background: The user is not logged in

  Scenario: 01 - Press Centre Button is clickable
    Given The worldwide home page is loaded
    Then the press centre button should be clickable

  Scenario: 02 - Donate Button is clickable
    Given The worldwide home page is loaded
    Then the donate button should be clickable

  Scenario: 03 - All areas link is working
    Given The worldwide home page is loaded
    When the user goes into the what we do section
    Then the all areas link should be working fine

  Scenario: 04 - Adolescents link is working
    Given The worldwide home page is loaded
    When the user goes into the what we do section
    Then the adolescents link should be working fine

  Scenario Outline: 05 - Checks if other links on What we do Section are working
    Given The worldwide home page is loaded
    When the user goes into the what we do section
    Then all the other links should lead to the "<element_to_click>" and "<desired_page>"

    Examples:
      | element_to_click | desired_page                                          |
      | 3                | https://www.unicef.org/child-protection               |
      | 5                | https://www.unicef.org/disabilities                   |
      | 6                | https://www.unicef.org/environment-and-climate-change |
      | 7                | https://www.unicef.org/coronavirus/covid-19           |
