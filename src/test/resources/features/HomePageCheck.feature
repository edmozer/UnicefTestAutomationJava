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
      | element_to_click | desired_page                                                         |
      | 3                | https://www.unicef.org/child-protection                              |
      | 5                | https://www.unicef.org/disabilities                                  |
      | 6                | https://www.unicef.org/environment-and-climate-change                |
      | 7                | https://www.unicef.org/coronavirus/covid-19                          |
      | 8                | https://www.unicef.org/early-childhood-development                   |
      | 9                | https://www.unicef.org/education                                     |
      | 20               | https://www.unicef.org/gender-equality                               |
      | 21               | https://www.unicef.org/health                                        |
      | 22               | https://www.unicef.org/emergencies                                   |
      | 23               | https://www.unicef.org/immunization                                  |
      | 24               | https://www.unicef.org/migrant-refugee-internally-displaced-children |
      | 25               | https://www.unicef.org/nutrition                                     |
      | 26               | https://www.unicef.org/social-and-behaviour-change                   |
      | 27               | https://www.unicef.org/social-policy                                 |
      | 28               | https://www.unicef.org/wash                                          |
      | 29               | https://www.unicef.org/partnerships                                  |
      | 30               | https://www.unicef.org/innovation/                                   |
      | 31               | https://www.unicef.org/supply/                                       |
      | 32               | https://www.unicef.org/young-people                                  |
      | 33               | https://www.unicef.org/appeals                                       |
      | 34               | https://www.unicef.org/evaluation/                                   |
      | 35               | https://www.unicef.org/climate-action                                |
      | 36               | https://www.unicef.org/on-my-mind                                    |
      | 37               | https://www.unicef.org/child-health-and-survival                     |
      | 38               | https://www.unicef.org/children-under-attack                         |
      | 39               | https://www.unicef.org/learning-crisis                               |




