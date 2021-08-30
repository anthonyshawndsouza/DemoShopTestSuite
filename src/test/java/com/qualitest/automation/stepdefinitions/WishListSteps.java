package com.qualitest.automation.stepdefinitions;

import org.testng.Assert;

import com.qualitest.automation.factory.DriverFactory;
import com.qualitest.automation.pages.CartPage;
import com.qualitest.automation.pages.HomePage;
import com.qualitest.automation.pages.WishListPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishListSteps {

	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private WishListPage wishListPage = new WishListPage(DriverFactory.getDriver());
	private CartPage cartPage = new CartPage(DriverFactory.getDriver());

	@Given("I add four different products to my wish list {string}, {string}, {string}, {string}")
	public void i_add_four_different_products_to_my_wish_list(String product, String product2, String product3,
			String product4) {
		homePage.clickAcceptAll();
		homePage.enterSearchProduct(product);
		homePage.clickSearchBtn();
		homePage.clickAddToWishListLink();
		homePage.enterSearchProduct(product2);
		homePage.clickSearchBtn();
		homePage.clickAddToWishListLink();
		homePage.enterSearchProduct(product3);
		homePage.clickSearchBtn();
		homePage.clickAddToWishListLink();
		homePage.enterSearchProduct(product4);
		homePage.clickSearchBtn();
		homePage.clickAddToWishListLink();
	}

	@When("I view my wish list table")
	public void i_view_my_wish_list_table() {
		homePage.clickWishListLink();

	}

	@When("I find total four selected items in my wishlist")
	public void i_find_total_four_selected_items_in_my_wishlist() {
		Assert.assertEquals(wishListPage.validateItemsAdded(), 4);

	}

	@When("I search for lowest price product")
	public void i_search_for_lowest_price_product() {
		wishListPage.getLowestPricedProduct();

	}

	@When("I am able to add the lowest price item to my cart")
	public void i_am_able_to_add_the_lowest_price_item_to_my_cart() {
		try {
			wishListPage.addToCart();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Then("I am able to verify the item in my cart")
	public void i_am_able_to_verify_the_item_in_my_cart() {
		wishListPage.goToCart();
		Assert.assertTrue(cartPage.validateCartIsNotEmpty());

	}

}
