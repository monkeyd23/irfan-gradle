@GuiTest
Feature: Application Login

  Scenario: Home page default login
    Given User is at login page
    When User login into application with me@imransayyed.com and Ichigo23$
    Then User at home page search for iphone XR product
    And User add Apple iPhone XR (128GB) - Coral product from the list to cart
    And Verify product Apple iPhone XR (128GB) - Coral is displayed on cart and subtotal is 1