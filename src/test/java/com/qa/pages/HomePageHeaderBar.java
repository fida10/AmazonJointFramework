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

	@FindBy(xpath = "//a[@id = 'nav-global-location-popover-link']")
	WebElement selectYouAddressLink;
	String selectYouAddressLinkXPath = "//a[@id = 'nav-global-location-popover-link']";

	@FindBy(xpath = "//h4[text() = 'Choose your location']")
	WebElement chooseYouLocationHeader;
	String chooseYouLocationHeaderXPath = "//h4[text() = 'Choose your location']";

	@FindBy(xpath = "//input[@type = 'text' and contains(@aria-label, 'zip code')]")
	WebElement zipCodeEnterField;
	String zipCodeEnterFieldXPath = "//input[@type = 'text' and contains(@aria-label, 'zip code')]";

	@FindBy(xpath = "//span[@class = 'a-button-text' and contains(text(), 'Apply')]")
	WebElement zipCodeApplyButton;
	String zipCodeApplyButtonXPath = "//span[@class = 'a-button-text' and contains(text(), 'Apply')]";

	@FindBy(xpath = "//button[@name = 'glowDoneButton']")
	WebElement doneButtonChangeAddress;
	String doneButtonChangeAddressXPath = "//button[@name = 'glowDoneButton']";

	@FindBy(xpath = "//a[@id = 'nav-global-location-popover-link']//span[contains(@class, 'nav-line-2')]")
	WebElement addressSelected;
	String addressSelectedXPath = "//a[@id = 'nav-global-location-popover-link']//span[contains(@class, 'nav-line-2')]";

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

	public void clickOnFirstThirteenHeaderCategories(){
//		Actions actions = new Actions(driver);
		List<WebElement> headerCategories = driver.findElements(By.xpath(commonPathToAllHeaderCategoriesXPath));
		for(int i = 0; i < 13; i++){
			headerCategories.get(i).click();
			driver.navigate().back();
//			actionExecutor.waitOnePointFiveSeconds();
			Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, commonPathToAllHeaderCategoriesXPath,0));
			headerCategories = driver.findElements(By.xpath(commonPathToAllHeaderCategoriesXPath));
			homePageSearchBar.click();
		}
	}

	public void changeAndValidateAddressViaHeader(String zipCodeToUseFiveDigits){
		Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, selectYouAddressLinkXPath,0));
		selectYouAddressLink.click();

		Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, chooseYouLocationHeaderXPath, 0));

		new Actions(driver)
				.moveToElement(zipCodeEnterField)
				.click(zipCodeEnterField)
				.sendKeys(zipCodeToUseFiveDigits)
				.moveToElement(zipCodeApplyButton)
				.click(zipCodeApplyButton)
				.build()
				.perform();

		Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, doneButtonChangeAddressXPath, 0));
		doneButtonChangeAddress.click();

		validatePageIsOpen();
		driver.navigate().refresh();

		Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, selectYouAddressLinkXPath,0));
		Assert.assertTrue(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, addressSelectedXPath,0).getText().contains(zipCodeToUseFiveDigits));

		System.out.println(addressSelected.getText());
	}
}
