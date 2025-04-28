Feature: Place the order for Products

  @PlaceOrder
  Scenario Outline: Search Experience for product search in both home and Offers page
    Given User is on GreenCart Landing page
    When user searched with Shortname <Name> and extracted actual name of product
    And  Added <Quantity> items of the selected product to cart
    Then User proceeds to Checkout and Validate the <Name> items in checkout page
    And verify user has ability to enter promo code and place the order

    Examples:
      | Name | Quantity |
      | Tom  | 3        |
      | Car | 4         |
      | Beet | 2        |

