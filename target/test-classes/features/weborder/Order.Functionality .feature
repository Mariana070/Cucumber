@regression
Feature: Testing weborder Order Functionality
  Background: Food Order same step
    When User provides userName and password and click Sign in
    When User click GroupOrder button and click Next button
    When User provides  InviteNote 'I love cucumber', InviteesList 'cucumber@gmail.com, selenium@gmail.com'

Scenario:Testing WEb Order DetailFunctionality
#  When User provides userName and password and click Sign in
#  When User click GroupOrder button and click Next button
#  When User provides  InviteNote 'I love cucumber', InviteesList 'cucumber@gmail.com, selenium@gmail.com'
  When User select delivery 'My House' and validate address contains '3137  Laguna'
  Then User click GroupOrder button and validate header 'View Group Order' and description contains 'Your group order is now pending'

Scenario: Testing Happy Path for Office  Food order
#  When User provides userName and password and click Sign in
#  And User click GroupOrder button and click Next button
#  And User provides  InviteNote 'I love Selenium', InviteesList 'celenium@gmail.com , cucumber@gmail.com'
  And User select delivery 'Office' and validate address contains '2012 EMPIRE BLVD'
  Then User click GroupOrder button and validate header 'View Group Order' and description contains 'Your group order is now pending'




#1-Login successfully weborder page parameterize username and password in feature file

  #2 click the order box and next button
  #3 send invitees section to "I LOVE SELENIUM"
  #4 send inviteList "email@gmail.com" and "email2@gmail.com"
  #5 choose the delivery option "My House" and validate adress(contains) "3137 Laguna"
  #6 click group order button
  #7 Validate the header "Your group order is now pending"(think about thread.sleep)
  #8 Validate the description contains(Your group order is now pending) from description