package com.qa.pages;

import com.aventstack.extentreports.ExtentTest;
import com.qa.utilFiles.coreCodeUtilFiles.ExtentReportGenerator;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePageHeaderBar extends somePageTemplate {

	@FindBy(xpath = "//a[@id='nav-logo-sprites']")
	WebElement amazonHomePageLogo;
	String amazonHomePageLogoXPath = "//a[@id='nav-logo-sprites']";

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement homePageSearchBar;
	String homePageSearchBarXPath = "//input[@id='twotabsearchtextbox']";

	@FindBy(xpath = "//div[@id = 'nav-tools']//a[@id = 'nav-cart']")
	WebElement homePageCart;
	String homePageCartXPath = "//div[@id = 'nav-tools']//a[@id = 'nav-cart']";

	@FindBy(xpath = "//span[@class='icp-nav-flag icp-nav-flag-us']")
	WebElement homePageCountrySelector;
	String homePageCountrySelectorXPath = "//span[@class='icp-nav-flag icp-nav-flag-us']";

	@FindBy(xpath = "//*[@id=\"nav-flyout-icp\"]/div[2]/a[1]")
	WebElement spanishLanguageSelector;
	String spanishLanguageSelectorXPath = "//*[@id='nav-flyout-icp']/div[2]/a[1]";



	public HomePageHeaderBar(WebDriver driver, ExtentTest currentTestFromInitDrPgsAndUtilsClass, ExtentReportGenerator extentReportGeneratorFromInitDrPgsAndUtilsClass, Scenario scenario) {
		super(driver, currentTestFromInitDrPgsAndUtilsClass, extentReportGeneratorFromInitDrPgsAndUtilsClass, scenario);
	}

	public WebElement getAmazonHomePageLogo() {
		return amazonHomePageLogo;
	}

	public String getAmazonHomePageLogoXPath() {
		return amazonHomePageLogoXPath;
	}

	public WebElement getHomePageSearchBar() {
		return homePageSearchBar;
	}

	public String getHomePageSearchBarXPath() {
		return homePageSearchBarXPath;
	}

	public WebElement getHomePageCart() {
		return homePageCart;
	}

	public String getHomePageCartXPath() {
		return homePageCartXPath;
	}

	//validation methods begin
	public void validatePageIsOpen(){
		Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, amazonHomePageLogoXPath, 0));
	}
	//validation methods end

	//flows related to this page begin
	public void searchForSomething(String whatToSearchFor){
		Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, homePageSearchBarXPath, 0));

		homePageSearchBar.click();
		homePageSearchBar.sendKeys(whatToSearchFor);
		homePageSearchBar.sendKeys(Keys.ENTER);
		actionExecutor.waitFiveSeconds();






	}
	public void changeLanguageToSpanish(){
		Actions a = new Actions(driver);

		a
				.moveToElement(homePageCountrySelector)
				.moveToElement(spanishLanguageSelector)
				.click(spanishLanguageSelector)
				.build()
				.perform();
		actionExecutor.waitFiveSeconds();
	}
}
