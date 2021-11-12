package com.qa.pages;

import com.aventstack.extentreports.ExtentTest;
import com.qa.utilFiles.coreCodeUtilFiles.ExtentReportGenerator;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Cart extends somePageTemplate {

	@FindBy(xpath = "//div[@class]/*[contains(text(), 'Your Amazon Cart') or contains(text(), 'Shopping Cart')]")
	WebElement shoppingCartPageHeader;
	String shoppingCartPageHeaderXPath = "//div[@class]/*[contains(text(), 'Your Amazon Cart') or contains(text(), 'Shopping Cart')]";

	@FindBy(xpath = "//div[@class]/*[contains(text(), 'Your Amazon Cart is empty')]")
	WebElement shoppingCartPageHeaderEmptyCart;
	String shoppingCartPageHeaderEmptyCartXPath = "//div[@class]/*[contains(text(), 'Your Amazon Cart is empty')]";

	@FindBy(xpath = "//div[@class]/*[contains(text(), 'Shopping Cart')]")
	WebElement shoppingCartPageHeaderFilledCart;
	String shoppingCartPageHeaderFilledCartXPath = "//div[@class]/*[contains(text(), 'Shopping Cart')]";

	@FindBy(xpath = "//span[@class = 'a-list-item']/a")
	WebElement productInCart;
	String productInCartXPath = "//span[@class = 'a-list-item']/a";
	//can also be used to get ALL the products in cart

	String productInCartDynamicXPath = "//span[@class = 'a-list-item']/a//*[contains(text(), '%s')]";
	//substitute product name to test

	public Cart(WebDriver driver, ExtentTest currentTestFromInitDrPgsAndUtilsClass, ExtentReportGenerator extentReportGeneratorFromInitDrPgsAndUtilsClass, Scenario scenario) {
		super(driver, currentTestFromInitDrPgsAndUtilsClass, extentReportGeneratorFromInitDrPgsAndUtilsClass, scenario);
	}

	public WebElement getShoppingCartPageHeader() {
		return shoppingCartPageHeader;
	}

	public String getShoppingCartPageHeaderXPath() {
		return shoppingCartPageHeaderXPath;
	}

	public WebElement getShoppingCartPageHeaderEmptyCart() {
		return shoppingCartPageHeaderEmptyCart;
	}

	public String getShoppingCartPageHeaderEmptyCartXPath() {
		return shoppingCartPageHeaderEmptyCartXPath;
	}

	public WebElement getShoppingCartPageHeaderFilledCart() {
		return shoppingCartPageHeaderFilledCart;
	}

	public String getShoppingCartPageHeaderFilledCartXPath() {
		return shoppingCartPageHeaderFilledCartXPath;
	}

	public WebElement getProductInCart() {
		return productInCart;
	}

	public String getProductInCartXPath() {
		return productInCartXPath;
	}

	public String getProductInCartDynamicXPath() {
		return productInCartDynamicXPath;
	}

	//validation methods begin
	public void validatePageIsOpen(){
		Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, shoppingCartPageHeaderXPath, 0));
	}
	//validation methods end

	//flows related to this page begin
	public void verifyItemAddedToCart(String itemName){
		//validates that item was added to cart by actually checking the cart page. Assumes already on cart page, designed to work in tandem with corresponding addToCart method in SearchResults page
		validatePageIsOpen();
		Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, String.format(productInCartDynamicXPath, itemName), 0));

	}
}
