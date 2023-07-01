Feature:Testing Etsy Search functionality with Scenario Outline
  Scenario Outline: Testing different product for Search Functionality
    When User search for '<itemName>' for Etsy
    Then  User validate the title '<title>' from Etsy
    Examples:
    |itemName|title|
    |Hat     |Hat-Etsy|
    |Key     |Key-Etsy|
    |Pin     |Pin-Etsy|