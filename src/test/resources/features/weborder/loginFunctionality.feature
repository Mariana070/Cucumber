@regression
Feature: Testing Login functionality for WebOrder website
  @smoke
  Scenario:Happy Path(correct username-correct password)
    When User provides 'guest1@microworks.com','Guest1!',click sign in
    Then User validate the 'ORDER DETAILS - Weborder'

    Scenario: Negative scenario (correct username- wrong password)
      When User provides 'guest1@microworks.com','wrong',click sign in
      Then User validate the message 'Sign in Failed'

      Scenario:Negative scenario (wrong username- correct password)
      When User provides 'wrong@gmail.com','Guest1!',click sign in
      Then User validate the message 'Sign in Failed'
@smoke
  Scenario:Negative scenario (empty username- empty password)
  When User provides ' ',' ',click sign in
  Then User validate the message 'Sign in Failed'
