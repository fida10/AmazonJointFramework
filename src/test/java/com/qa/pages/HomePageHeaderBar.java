package com.qa.pages;

import com.aventstack.extentreports.ExtentTest;
import com.qa.utilFiles.coreCodeUtilFiles.ExtentReportGenerator;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

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

	String commonPathToAllHeaderCategoriesXPath = "//div[@id = 'nav-xshop']/a";

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

	public void hoverOverFirstThirteenHeaderCategories(){
		Actions actions = new Actions(driver);

		List<WebElement> headerCategories = driver.findElements(By.xpath(commonPathToAllHeaderCategoriesXPath));
		for(int i = 0; i < 13; i++){
			actions
					.moveToElement(headerCategories.get(i))
					.build()
					.perform();
			actionExecutor.waitOnePointFiveSeconds();
		}

	}


}
