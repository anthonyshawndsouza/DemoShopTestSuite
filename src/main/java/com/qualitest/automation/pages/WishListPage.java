package com.qualitest.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class WishListPage {

	private WebDriver driver;

	// 1. By Locators: Object Repo
	private String leastPricedElementXPath = "";
	private By addtoCartLnk = By.xpath("//i[@class='la la-shopping-bag']");
	private By itemsSelectedCount = By.xpath("//tbody[@class='wishlist-items-wrapper']/descendant::tr");

	// 2. Constructor:
	public WishListPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions:

	public int validateItemsAdded() {
		return driver.findElements(itemsSelectedCount).size();

	}
	
	
	/**
	 * This method is used to identify the lowest priced item in the wishlist
	 * @return it returns void
	 */
	public void getLowestPricedProduct() {
		String preXpath = "//*[@id=\"yith-wcwl-row-";
		String postXpath = "\"]/td[4]/ins/span/bdi";
		String postXpath1 = "\"]/td[4]/span[1]/bdi";
		String postXpath2 = "\"]/td[4]/span/bdi";
		String temp = "";
		double temp1 = 1000.00;
		for (int i = 1; i <= 27; i++) {
			String actXpath = preXpath + i + postXpath;

			try {

				if (driver.findElement(By.xpath(actXpath)).isDisplayed()) {
					temp = driver.findElement(By.xpath(actXpath)).getText().replace("£", "");
					if (Double.parseDouble(temp) <= temp1) {
						temp1 = Double.parseDouble(temp);
						leastPricedElementXPath = actXpath;
					}
				}

			} catch (NoSuchElementException e) {

			}

		}
		for (int i = 1; i <= 27; i++) {
			String actXpath = preXpath + i + postXpath1;

			try {

				if (driver.findElement(By.xpath(actXpath)).isDisplayed()) {
					temp = driver.findElement(By.xpath(actXpath)).getText().replace("£", "");
					if (Double.parseDouble(temp) <= temp1) {
						temp1 = Double.parseDouble(temp);
						leastPricedElementXPath = actXpath;
					}
				}

			} catch (NoSuchElementException e) {

			}

		}
		for (int i = 1; i <= 27; i++) {
			String actXpath = preXpath + i + postXpath2;

			try {

				if (driver.findElement(By.xpath(actXpath)).isDisplayed()) {
					temp = driver.findElement(By.xpath(actXpath)).getText().replace("£", "");
					if (Double.parseDouble(temp) <= temp1) {
						temp1 = Double.parseDouble(temp);
						leastPricedElementXPath = actXpath;
					}
				}

			} catch (NoSuchElementException e) {

			}

		}
		if (!leastPricedElementXPath.equals("")) {
			System.out.println(leastPricedElementXPath + " -- This is the least priced element");
		}
	}

	public void addToCart() throws InterruptedException {
		String addToCartXPath = leastPricedElementXPath + "/following::td/a";
		Thread.sleep(1000);
		driver.findElement(By.xpath(addToCartXPath)).click();
		Thread.sleep(1000);

	}

	public CartPage goToCart() {
		driver.findElement(addtoCartLnk).click();
		return new CartPage(driver);
	}

}
