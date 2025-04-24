Feature: Search and Place the order for Products
  Scenario: Search Experience for product search in both home and Offers page
    Given User is on GreenCart Landing page
    When usr searched with Shortname "Tom" and extracted actual name of product
    And user searched for "Tom" shortname in offers page
    Then Validate product name in offers page matches with Landing Page