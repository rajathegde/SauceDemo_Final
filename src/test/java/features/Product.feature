@Product
Feature: Product Add

  Scenario Outline: Product Add to cart
    Given User Opened Swag Lab Application
    When User Enters username "<UserName>"
    And User Enter Password "<password>"
    And Clicks on Login Button
    And user adds a product to the cart "<product>"
    Then User see product is added to the cart

    Examples: 
      | UserName      | password     | product             |
      | standard_user | secret_sauce | Sauce Labs Backpack |
