@regression
Feature: Testing the Saucedemo Order Functionality

  Scenario:Adding an item to cart and checking out successfully
    Given  User provides userName and password and click Login
    When User chooses 'Sauce Labs Backpack' and click Add to Cart button
    And Click Cart sign on the top right
    And Click checkout button
    And fill in all the box 'firstname','lastname','zipCode'  and click continue button
    Then Validate the 'Sauce Labs Backpack', item total, and tax amount should be % eight of the product and validate total amount is matching with tax+item total
    And Click Finish Button and validate "Thank you for your order!"

  Scenario Outline:Adding an item to cart and checking out successfully
    Given  User provides userName and password and click Login
    When User chooses '<productName>' and click Add to Cart button
    And Click Cart sign on the top right
    And Click checkout button
    And fill in all the box '<firstName>','<lastName>','<zipCode>'  and click continue button
    Then Validate the '<productName>', item total, and tax amount should be % eight of the product and validate total amount is matching with tax+item total
    And Click Finish Button and validate "<message>"
    Examples:
      | productName                       | firstName | lastName | zipCode | message                   |
      | Sauce Labs Backpack               | Mariana   | Kuzmyn   | 60069   | Thank you for your order! |
      | Sauce Labs Bolt T-Shirt           | Ivan      | Kozak    | 60078   | Thank you for your order! |
      | Sauce Labs Onesie                 | Vasyl     | Melnyk   | 399857   |Thank you for your order! |
      | Sauce Labs Bike Light             | Oleh      | Tomych   | 9798797 | Thank you for your order! |
      | Sauce Labs Fleece Jacket          | Inna      | Kohan    | 878689  | Thank you for your order! |
      | Test.allTheThings() T-Shirt (Red) | Miha      | Tomych   | 8786675 | Thank you for your order! |

  Scenario:Adding an item to cart and checking out successfully
    Given  User provides userName and password and click Login
    When User chooses productName and click Add to Cart button
    |productName|Sauce Labs Backpack|
    And Click Cart sign on the top right
    And Click checkout button
    And fill in all the box firstname,lastname,zipCode  and click continue button
    |firstname|Mariana|
    |lastname |Kuzmyn |
    |zipCode  |60090  |
    Then Validate the productName, item total, and tax amount should be % eight of the product and validate total amount is matching with tax+item total
    |ProductName|Sauce Labs Backpack|
    And Click Finish Button and validate message
    |message|Thank you for your order!|