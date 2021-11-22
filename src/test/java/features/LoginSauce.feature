@LoginFeature
Feature: Login Feature Scenario

  Scenario Outline: Possitive Login Feature
    Given User Opened Swag Lab Application
    When User Enters username "<UserName>"
    And User Enter Password "<password>"
    And Clicks on Login Button
    Then User Should be on the Products Page

    Examples: 
      | UserName      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Negetive Login Feature
    Given User Opened Swag Lab Application
    When User Enters username "<UserName>"
    And User Enter Password "<password>"
    And Clicks on Login Button
    Then User Should Get "<Error>"

    Examples: 
      | UserName      | password | Error                                                                     |
      | standard_user | Test1234 | Epic sadface: Username and password do not match any user in this service |
