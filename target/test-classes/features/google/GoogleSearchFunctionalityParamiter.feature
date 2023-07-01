@regression
Feature: Testing the Google Search Functionality Parameters
  Background: navigate to the website same step
    Given User navigates to the 'https://www.google.com/'
  #general description
  Scenario:Happy Path(positive)Testing for Search Parameters
    #test case

    When User searches for 'CodeFish'
    Then User validates first page returns more than 10 links

  Scenario: Happy Path (positive) Testing Result for Search Parameters
    When User searches for 'Kyrgez Food in USA'
    Then User validate the result is less than 300000000
@smoke
  Scenario: Turkish baklava Validating it loads less than one sec Parameters
    When User searches for 'Turkish baklava'
    Then User validate it loads less than 1.0 sec

