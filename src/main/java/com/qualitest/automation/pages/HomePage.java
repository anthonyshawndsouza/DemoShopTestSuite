package com.qualitest.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;

	// 1. By Locators: Object Repo
	private By acceptAll = By.xpath("//a[text()='Accept all']");
	private By searchTxtBox = By.xpath("//input[@placeholder='Search products...']");
	private By searchBtn = By.xpath("//button[@class='header-search-button']");
	private By addToWishListLink = By.xpath("//span[text()='Add to wishlist']");
	private By wishListLink = By.xpath("//i[@class='lar la-heart']");

	// 2. Constructor of the page class:
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions:
	public void clickAcceptAll() {
		driver.findElement(acceptAll).click();
	}

	public void enterSearchProduct(String product) {
		driver.findElement(searchTxtBox).sendKeys(product);
	}

	public void clickSearchBtn() {
		driver.findElement(searchBtn).click();
	}

	
	public void clickAddToWishListLink() {
		try {
			driver.findElement(addToWishListLink).click();
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			driver.findElement(addToWishListLink).click();
		}
		
	}
	
	public WishListPage clickWishListLink() {
		driver.findElement(wishListLink).click();
		return new WishListPage(driver);
	}

}
