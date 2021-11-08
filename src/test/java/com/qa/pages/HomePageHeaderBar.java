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

	@FindBy(xpath = "//a[contains(@aria-label, 'Choose a language')]")
	WebElement homePageCountrySelector;
	String homePageCountrySelectorXPath = "//a[contains(@aria-label, 'Choose a language')]";

	@FindBy(xpath = "//div[@id = 'nav-flyout-icp']//span[@class = 'nav-text' and contains(text(), 'ES')]")
	WebElement spanishLanguageSelector;
	String spanishLanguageSelectorXPath = "//div[@id = 'nav-flyout-icp']//span[@class = 'nav-text' and contains(text(), 'ES')]";

	@FindBy(xpath = "//div[@class='nav-search-submit nav-sprite']")
	WebElement amazonSearchButton;
	String amazonSearchButtonXPath = "//div[@class='nav-search-submit nav-sprite']";

	@FindBy(xpath = "//h2//a[contains(@class, 'a-text-normal')]")
	WebElement firstSearchResult;
	String firstSearchResultXPath = "//h2//a[contains(@class, 'a-text-normal')]";

	@FindBy(xpath= "//span[@id='productTitle']")
	WebElement firstSearchResultTitle;
	String firstSearchResultTitleXPath = "//span[@id='productTitle']";

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

	@FindBy(xpath = "//span[@class='nav-line-2 ']")
	WebElement signInHoverMenu;
	String signInHoverMenuXPath = "//span[@class='nav-line-2 ']";

	@FindBy(xpath = "//div[@id='nav-al-container']//span[text() = 'Sign in']")
	WebElement signInButton;
	String signInButtonXPath = "//div[@id='nav-al-container']//span[text() = 'Sign in']";

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

	public String getFirstSearchResultTitleXPath() {
		return firstSearchResultTitleXPath;
	}

	public String getCommonPathToAllHeaderCategoriesXPath() {
		return commonPathToAllHeaderCategoriesXPath;
	}

	public WebElement getSelectYouAddressLink() {
		return selectYouAddressLink;
	}

	public String getSelectYouAddressLinkXPath() {
		return selectYouAddressLinkXPath;
	}

	public WebElement getChooseYouLocationHeader() {
		return chooseYouLocationHeader;
	}

	public String getChooseYouLocationHeaderXPath() {
		return chooseYouLocationHeaderXPath;
	}

	public WebElement getZipCodeEnterField() {
		return zipCodeEnterField;
	}

	public String getZipCodeEnterFieldXPath() {
		return zipCodeEnterFieldXPath;
	}

	public WebElement getZipCodeApplyButton() {
		return zipCodeApplyButton;
	}

	public String getZipCodeApplyButtonXPath() {
		return zipCodeApplyButtonXPath;
	}

	public WebElement getDoneButtonChangeAddress() {
		return doneButtonChangeAddress;
	}

	public String getDoneButtonChangeAddressXPath() {
		return doneButtonChangeAddressXPath;
	}

	public WebElement getAddressSelected() {
		return addressSelected;
	}

	public String getAddressSelectedXPath() {
		return addressSelectedXPath;
	}

	public WebElement getSignInHoverMenu() {
		return signInHoverMenu;
	}

	public String getSignInHoverMenuXPath() {
		return signInHoverMenuXPath;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}

	public String getSignInButtonXPath() {
		return signInButtonXPath;
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

	public void clickOnFirstThirteenHeaderCategories(){
		List<WebElement> headerCategories = driver.findElements(By.xpath(commonPathToAllHeaderCategoriesXPath));
		for(int i = 0; i < 13; i++){
			headerCategories.get(i).click();
			driver.navigate().back();
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
