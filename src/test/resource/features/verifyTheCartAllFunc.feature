@CartFunctionality
Feature: Verify the cart using all possible testing
  Background:
    When user is launching the ecommerceapp
    And logs in successfully

    @OneItemInCart
    Scenario: one item in the cart
      When user is adding one item to the cart
      Then item should be displayed in the cart

      @ThreeItemsInCart
      Scenario: adding three items in the cart
        When user is adding three items in the cart
        Then items should be displayed in the cart

        @VerifyPricesInCart
        Scenario: adding two items verify its prices in cart
          When user is addnd two items in cart
          Then items should be displayed in cart
          And prices in the cart should be the same as listed
          And total price should be correct

          @VerifyDeletingAnItemFromCart
          Scenario: adding two items and remove one
          When user is adding two items in the cart
          Then items should be in the cart
          And prices from cart should be the same as listed
          And verify if total price is correct
          And remove one item from the cart
          And verify that there is only one item in the cart
          And verify the price for the item
          And verify the total price

            @CompletePurchaseAndTapOnCheckBox
            Scenario: user is completing a purchase
              When user adds two items in the cart
              Then verify the items in the cart
              And verify the prices in the cart
              And verify the total price is correct
              And user taps on check box to receive emails
              And user taps on button to visit website to complete purchase
              And user navigate to techtorial website from a mobile browser
              And verify that its on the home page of techtorial website

              @AddingAllItemsInTheCart
              Scenario: user is adding all items in the cart
                When user is adding all products in the cart
                And user prints out TermsOfConditions to console
                Then user should be able to verify all items in the cart