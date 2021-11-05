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

import java.lang.reflect.InvocationTargetException;

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

	@FindBy(xpath = "//a[contains(@aria-label, 'Choose a language')]")
	WebElement homePageCountrySelector;
	String homePageCountrySelectorXPath = "//a[contains(@aria-label, 'Choose a language')]";

	@FindBy(xpath = "//div[@id = 'nav-flyout-icp']//span[@class = 'nav-text' and contains(text(), 'ES')]")
	WebElement spanishLanguageSelector;
	String spanishLanguageSelectorXPath = "//div[@id = 'nav-flyout-icp']//span[@class = 'nav-text' and contains(text(), 'ES')]";

	@FindBy(xpath = "//div[@class='nav-search-submit nav-sprite']")
	WebElement amazonSearchButton;
	String amazonSearchButtonXPath = "//div[@class='nav-search-submit nav-sprite']";

//	@FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal' and contains(text(), '764442854668')]")
	@FindBy(xpath = "//h2//a[contains(@class, 'a-text-normal')]")
	WebElement firstSearchResult;
	String firstSearchResultXPath = "//h2//a[contains(@class, 'a-text-normal')]";
	
	@FindBy(xpath= "//span[@id='productTitle']")
	WebElement firstSearchResultTitle;
	String firstSearchResultTitleXPath = "//span[@id='productTitle']";




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
		//driver.navigate().refresh();
		Actions a = new Actions(driver);

		a
				.moveToElement(homePageSearchBar)
				.click(homePageSearchBar)
						.build()
								.perform();
		Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, homePageCountrySelectorXPath, 0));
		a

				.moveToElement(amazonHomePageLogo)
				.moveToElement(homePageCountrySelector)
				.build()
				.perform();
		Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, spanishLanguageSelectorXPath, 0));
		spanishLanguageSelector.click();
		actionExecutor.waitFiveSeconds();
	}
	public void searchForAndVerifyProduct(String searchQuery){
		Actions b = new Actions(driver);

		b
				.moveToElement(homePageSearchBar)
				.click(homePageSearchBar)
				.sendKeys(searchQuery)
				.sendKeys(Keys.ENTER)
				.build()
				.perform();

		Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, firstSearchResultXPath, 0));

		firstSearchResult.click();


		String returnedSearchTerm = firstSearchResultTitle.getText();
		System.out.println(returnedSearchTerm);

		if(returnedSearchTerm.toLowerCase().contains(searchQuery.toLowerCase())){
			System.out.println("Test passed");
		} else {
			System.out.println("You messed up");
		}




	}





}
