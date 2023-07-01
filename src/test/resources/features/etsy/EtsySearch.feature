@regression
Feature:Testing the Search Functionality of the Etsy Website
  Scenario: Search Functionality  Happy Path for Etsy Hat
    When User search for 'Hat' for Etsy
    Then  User validate the title 'Hat-Etsy' from Etsy

  Scenario: Search Functionality  Happy Path for Etsy Hat
    When User search for 'Key' for Etsy
    Then  User validate the title 'Key-Etsy' from Key

  Scenario: Search Functionality  Happy Path for Etsy Hat
    When User search for 'Pin' for Etsy
    Then  User validate the title 'Pin-Etsy' from Pin