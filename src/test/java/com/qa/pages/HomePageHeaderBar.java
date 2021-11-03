package com.qa.pages;

import com.aventstack.extentreports.ExtentTest;
import com.qa.appUtilFiles.ActionExecutor;
import com.qa.appUtilFiles.ExceptionHandling;
import com.qa.utilFiles.coreCodeUtilFiles.ExtentReportGenerator;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePageHeaderBar extends somePageTemplate {

	@FindBy(xpath = "//img[@alt = 'Walmart' and @loading = 'lazy']")
	WebElement walmartHomePageLogo;
	String walmartHomePageLogoXPath = "//img[@alt = 'Walmart' and @loading = 'lazy']";

	@FindBy(xpath = "//input[@type = 'search' and @aria-label = 'Search']")
	WebElement homePageSearchBar;
	String homePageSearchBarXPath = "//input[@type = 'search' and @aria-label = 'Search']";

	@FindBy(xpath = "//a[@link-identifier = 'walmartLogo']/following-sibling::div[@class = 'ml3']/button")
	WebElement homePageCart;
	String homePageCartXPath = "//a[@link-identifier = 'walmartLogo']/following-sibling::div[@class = 'ml3']/button";

	@FindBy(xpath = "//div[contains(@aria-label, 'Human Challenge requires verification')]")
	WebElement pressAndHoldRobotButton;
	String pressAndHoldRobotButtonXPath = "//div[contains(@aria-label, 'Human Challenge requires verification')]";

	public HomePageHeaderBar(WebDriver driver, ExtentTest currentTestFromInitDrPgsAndUtilsClass, ExtentReportGenerator extentReportGeneratorFromInitDrPgsAndUtilsClass, Scenario scenario) {
		super(driver, currentTestFromInitDrPgsAndUtilsClass, extentReportGeneratorFromInitDrPgsAndUtilsClass, scenario);
	}

	public WebElement getWalmartHomePageLogo() {
		return walmartHomePageLogo;
	}

	public String getWalmartHomePageLogoXPath() {
		return walmartHomePageLogoXPath;
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
		Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, walmartHomePageLogoXPath, 0));
	}
	//validation methods end

	//flows related to this page begin
	public void searchForSomething(String whatToSearchFor){

		Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, homePageSearchBarXPath, 0));

		homePageSearchBar.click();
		homePageSearchBar.sendKeys(whatToSearchFor);
		actionExecutor.waitFiveSeconds();
	}
}
