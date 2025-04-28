Feature: Search and Place the order for Products
#  Scenario: Search Experience for product search in both home and Offers page
#    Given User is on GreenCart Landing page
#    When user searched with Shortname "Tom" and extracted actual name of product
#    And user searched for "Tom" shortname in offers page
#    Then Validate product name in offers page matches with Landing Page

  @SearchProduct
  Scenario Outline: Search Experience for product search in both home and Offers page
    Given User is on GreenCart Landing page
    When user searched with Shortname <Name> and extracted actual name of product
    And user searched for <Name> shortname in offers page
    Then Validate product name in offers page matches with Landing Page

    Examples:
    |Name|
    | Beet   |