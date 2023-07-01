Feature: Testing Login functionality for WebOrder website Scenario Outlin
@smoke
Scenario:Happy Path(correct username-correct password)
When User provides 'guest1@microworks.com','Guest1!',click sign in
Then User validate the 'ORDER DETAILS - Weborder'

Scenario Outline:
When User provides '<userName>','<password>',click sign in
Then User validate the message '<message>'
  Examples:
  |userName|password|message|
  |guest1@microworks.com|wrong|Sing is failed|
  |wrong@gmail.com      |Guest1!|Sing is failed|
  |                     |       |Sing is failed|
