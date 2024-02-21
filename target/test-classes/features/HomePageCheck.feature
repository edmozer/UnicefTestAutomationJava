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
    Then when "<element>" is clicked it should lead to "<desired_page>"

    Examples:
      | element | desired_page                                                         |
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



  Scenario: 06
    Given The worldwide home page is loaded
    When the user goes into the research and reports section


  Scenario Outline: 06 - Checks if links on Research and Reports section are working fine
    Given The worldwide home page is loaded
    When the user goes into the research and reports section
    Then when "<element>" is clicked it should lead to "<desired_page>"

    Examples:
      | element | desired_page                                                         |
      | 40                | https://www.unicef.org/reports/state-of-worlds-children                              |
    | 41                | https://www.unicef.org/reports/unicef-annual-report-2022                             |
    | 42                | https://www.unicef.org/reports/humanitarian-action-children-2022-overview            |
    | 43                | https://www.unicef.org/reports                                                       |
    | 46                | https://www.unicef.org/globalinsight/                                                |
    | 47                | https://www.unicef-irc.org/                                                          |
    | 48                | https://www.unicef.org/child-rights-convention                                            |
    | 49                | https://www.unicef.org/emergencies/core-commitments-children                              |
    | 50                | https://www.unicef.org/sustainable-development-goals                                      | 


