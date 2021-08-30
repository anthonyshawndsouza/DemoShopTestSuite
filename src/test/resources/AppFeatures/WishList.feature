Feature: WishList page feature

Background: User has added four products to wish list
Given I add four different products to my wish list "Evening trousers", "Modern", "Hard top", "Black pants"

Scenario: Add-to-cart the lowest priced product from wishlist
When I view my wish list table 
And I find total four selected items in my wishlist 
When I search for lowest price product
And I am able to add the lowest price item to my cart
Then I am able to verify the item in my cart

