package com.qualitest.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	
	private WebDriver driver;
	
	// 1. By Locators: Object Repo
	private By cartTable = By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']");
	private By productNameInCart = By.xpath("//td[@class='product-name']/a");
	
	// 2. Constructor:
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// 3. page actions:
	public boolean validateCartIsNotEmpty() {
		System.out.println("Lowest product is: " + driver.findElement(productNameInCart).getText() );
		return driver.findElement(cartTable).isDisplayed();
	} 

}
