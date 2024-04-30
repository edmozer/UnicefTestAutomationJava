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
      | 3       | https://www.unicef.org/child-protection                              |
      | 5       | https://www.unicef.org/disabilities                                  |
      | 6       | https://www.unicef.org/environment-and-climate-change                |
      | 7       | https://www.unicef.org/coronavirus/covid-19                          |
      | 8       | https://www.unicef.org/early-childhood-development                   |
      | 9       | https://www.unicef.org/education                                     |
      | 20      | https://www.unicef.org/gender-equality                               |
      | 21      | https://www.unicef.org/health                                        |
      | 22      | https://www.unicef.org/emergencies                                   |
      | 23      | https://www.unicef.org/immunization                                  |
      | 24      | https://www.unicef.org/migrant-refugee-internally-displaced-children |
      | 25      | https://www.unicef.org/nutrition                                     |
      | 26      | https://www.unicef.org/social-and-behaviour-change                   |
      | 27      | https://www.unicef.org/social-policy                                 |
      | 28      | https://www.unicef.org/wash                                          |
      | 29      | https://www.unicef.org/partnerships                                  |
      | 30      | https://www.unicef.org/innovation/                                   |
      | 31      | https://www.unicef.org/supply/                                       |
      | 32      | https://www.unicef.org/young-people                                  |
      | 33      | https://www.unicef.org/appeals                                       |
      | 34      | https://www.unicef.org/evaluation/                                   |
      | 35      | https://www.unicef.org/climate-action                                |
      | 36      | https://www.unicef.org/on-my-mind                                    |
      | 37      | https://www.unicef.org/child-health-and-survival                     |
      | 38      | https://www.unicef.org/children-under-attack                         |
      | 39      | https://www.unicef.org/learning-crisis                               |


  Scenario Outline: 06 - Checks if links on Research and Reports section are working fine
    Given The worldwide home page is loaded
    When the user goes into the research and reports section
    Then when "<element>" is clicked it should lead to "<desired_page>"

    Examples:
      | element | desired_page                                                              |
      | 41      | https://www.unicef.org/reports/state-of-worlds-children                   |
      | 42      | https://www.unicef.org/reports/unicef-annual-report-2022                  |
      | 43      | https://www.unicef.org/reports/humanitarian-action-children-2024-overview |
      | 44      | https://www.unicef.org/reports                                            |
      | 47      | https://www.unicef.org/child-rights-convention                                       |
      | 48      | https://www.unicef.org/emergencies/core-commitments-children                                         |
      | 49      | https://www.unicef.org/sustainable-development-goals                    |

  Scenario Outline: 07 - Checks if links on Stories section are working fine
    Given The worldwide home page is loaded
    When the user goes into stories section
    Then when "<element>" is clicked it should lead to "<desired_page>"

    Examples:
      | element | desired_page                                                                  |
      | 51      | https://www.unicef.org/stories#facts                                          |
      | 52      | https://www.unicef.org/stories#photo                                          |
      | 54      | https://www.unicef.org/emergencies/delivering-support-afghanistans-children   |
      | 55      | https://www.unicef.org/emergencies/crisis-central-african-republic            |
      | 57      | https://www.unicef.org/emergencies/children-gaza-need-lifesaving-support      |
      | 58      | https://www.unicef.org/emergencies/crisis-haiti                               |



  Scenario Outline: 08 - Checks if links on About Unicef section are working fine
    Given The worldwide home page is loaded
    When the user goes into About Unicef section
    Then when "<element>" is clicked it should lead to "<desired_page>"

    Examples:
      | element | desired_page                                                      |
      | 66      | https://www.unicef.org/about-unicef                               |
      | 67      | https://www.unicef.org/history                                    |
      | 68      | https://www.unicef.org/results                                    |
      | 69      | https://www.unicef.org/reports/unicef-strategic-plan-2022-2025    |
      | 70      | https://www.unicef.org/transparency                               |
      | 71      | https://www.unicef.org/auditandinvestigation/                     |
      | 72      | https://www.unicef.org/careers/                                   |
      | 73      | https://www.unicef.org/media/experts                              |
      | 74      | https://www.unicef.org/executiveboard/                            |
      | 75      | https://www.unicef.org/goodwill-ambassadors                       |
      | 76      | https://www.unicef.org/where-we-work                              |
      | 77      | https://www.unicef.org/where-we-work#east-asia-and-the-pacific    |
      | 78      | https://www.unicef.org/where-we-work#eastern-and-southern-africa  |
      | 79      | https://www.unicef.org/where-we-work#europe-and-central-asia      |
      | 80      | https://www.unicef.org/where-we-work#latin-america-and-caribbean  |
      | 81      | https://www.unicef.org/where-we-work#middle-east-and-north-africa |
      | 82      | https://www.unicef.org/where-we-work#south-asia                   |
      | 83      | https://www.unicef.org/where-we-work#west-and-central-africa      |



  Scenario Outline: 09 - Checks if links on Take Action section are working fine
    Given The worldwide home page is loaded
    When the user goes into Take Action section
    Then when "<element>" is clicked it should lead to "<desired_page>"

    Examples:
      | element | desired_page                                                      |
      | 86      | https://www.unicef.org/careers/                              |
    | 87      | https://www.unicef.org/partnerships                          |
    | 89      | https://www.unicef.org/careers/volunteers-unicef             |
    | 90      | https://www.unicef.org/world-childrens-day                   |
    | 91      | https://www.unicef.org/climate-action                        |
    | 92      | https://www.unicef.org/on-my-mind                            |
    | 93      | https://www.unicef.org/learning-crisis                       |
    | 94      | https://www.unicef.org/child-health-and-survival             |

  Scenario: 10 - Click search button and execute search
    Given The worldwide home page is loaded
    When the search button is clicked and data is inserted
    Then the search should show results

  Scenario: 11 - Main image is displayed
    Given The worldwide home page is loaded
    Then the main image should be loaded and displayed
    And read more button should be clickable

  Scenario Outline: 12 - Checks if links in middle page section are working fine
    Given The worldwide home page is loaded
    Then when "<element>" is clicked in the middle of page it should lead to "<desired_page>"

    Examples:
      | element | desired_page                                                                                                            |
      | 1       | https://www.unicef.org/press-releases/statement-principals-inter-agency-standing-committee-civilians-gaza-extreme-peril |
      | 2       | https://www.unicef.org/emergencies/war-ukraine-pose-immediate-threat-children                                           |
      | 3       | https://www.unicef.org/emergencies/emergency-response-sudan                                                             |
      | 4       | https://www.unicef.org/press-releases/unicef-and-wfp-demand-action-protect-children-and-unfettered-humanitarian-access  |
      | 5       | https://www.voicesofyouth.org/                                                                                          |
      | 6       | https://www.unicef.org/stories/picturing-future-amid-climate-crisis                                                     |
      | 7       | https://www.unicef.org/stories/how-flexible-funding-saving-lives                                                        |
      | 8       | https://www.unicef.org/parenting/how-talk-your-children-about-conflict-and-war                                          |

  Scenario Outline: 13 - Checks if links in (Unicef's work) middle page section(2) are working fine
    Given The worldwide home page is loaded
    Then when "<element>" is clicked in the second half of middle of page it should lead to "<desired_page>"

    Examples:
      | element | desired_page                                   |
      | 2       | https://www.unicef.org/what-we-do#protection   |
      | 3       | https://www.unicef.org/what-we-do#survival     |
      | 4       | https://www.unicef.org/what-we-do#education    |
      | 5       | https://www.unicef.org/what-we-do#emergencies  |
      | 6       | https://www.unicef.org/what-we-do#socialpolicy |
      | 7       | https://www.unicef.org/what-we-do#gender       |
      | 8       | https://www.unicef.org/what-we-do#innovation   |
      | 9       | https://www.unicef.org/what-we-do#supply       |
      | 10      | https://www.unicef.org/what-we-do#research     |


  Scenario Outline: 14 - Checks if links in bottom of page section are working fine
    Given The worldwide home page is loaded
    Then when "<element>" is clicked in the bottom of page it should lead to "<desired_page>"

    Examples:
      | element | desired_page                                         |
      | 5       | https://www.unicef.org/results                       |
      | 6       | https://www.unicef.org/parenting/                    |
      | 7       | https://www.voicesofyouth.org/                       |
      | 8       | https://www.unicef.org/sustainable-development-goals |


  Scenario: 15 - Bottom image is displayed
    Given The worldwide home page is loaded
    Then the main image should be loaded and displayed
    And join unicef button should be clickable



