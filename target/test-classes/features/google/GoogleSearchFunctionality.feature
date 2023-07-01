@regression
Feature: Testing the Google Search Functionality
  #general description
  Scenario:Happy Path(positive)Testing for Search
    #test case
    Given User navigates to the google
    When User searches for CodeFish
    Then User validates first page returns more than ten links
@smoke
    Scenario: Happy Path (positive) Testing Result for Search
      Given User navigates to the google
      When User searches for Kyrgez Food in USA
      Then User validate the result is less than three hundred million

      Scenario: Turkish baklava Validating it loads less than one sec
        Given User navigates to the google
        When User searches for Turkish baklava
        Then User validate it loads less than one sec
