@regression
Feature: Testing the Order Creation Functionality of SmartBear Website

  Scenario Outline: Creating the WebOrder from SmartBear
    Given User provides 'userName' and 'password' and click Login button
    When User click Order button and select '<productName>' and f provide '<quantity>' for product information
    And User provide '<customerName>','<street>','<city>','<state>','<zipCode>' for address information
    And User provide '<card>','<cardNR>','<expireDate>'
    Then User click Process button and validate 'New order has been successfully added.' and click View order button
    And User validate allInformation '<customerName>','<productName>','<quantity>','06/26/2023','<street>','<city>','<state>','<zipCode>','<card>','<cardNR>','<expireDate>' from table
    #customerName,productName,quantity,date,street,city,state,zipCode,card,cardNR,expireDate
    Examples:
      | customerName | productName | quantity | street        | city         | state | zipCode | card             | cardNR        | expireDate |
      | Liza         | MyMoney     | 4        | Ballantrae Pl | Mundelein    | IL    | 60069   | Visa             | 2345876523498 | 09/24      |
      | Ivan         | FamilyAlbum | 5        | West Street   | Kolomyya     | IL    | 34857   | MasterCard       | 78876688835   | 02/04      |
      | Nata         | ScreenSaver | 6        | LincolnShare  | LincolnShare | IL    | 60069   | American Express | 7665436788    | 09/07      |

    Scenario: Creating the WebOrder from SmartBear with DataTable
      Given User provides 'userName' and 'password' and click Login button
      When User clicks OrderButton and provides the product and quantity for product information
      |product|MyMoney|
      |quantity|4     |
      And User provides customerName, street,city,state,zipCode,for address information
      |customerName|Mariana|
      |street     |Ballantrae|
      |city       |Chicago   |
      |state      |Il        |
      |zipCode    |79905     |
      And User provides card,cardNR,expireDate
      |card|Visa|
      |cardNR|747586869999770|
      |expireDate|21/21/2023 |
      And User clicks process button and validate message
      |New order has been successfully added.|
