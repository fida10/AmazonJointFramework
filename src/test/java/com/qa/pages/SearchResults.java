package com.qa.pages;

import com.aventstack.extentreports.ExtentTest;
import com.qa.utilFiles.coreCodeUtilFiles.ExtentReportGenerator;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SearchResults extends somePageTemplate {

	@FindBy(xpath = "//div/span[@dir = 'auto' and contains(text(), 'results for')]")
	WebElement searchPageHeader;
	String searchPageHeaderXPath = "//div/span[@dir = 'auto' and contains(text(), 'results for')]";

	String searchPageHeaderDynamicXPath = "//div/span[@dir = 'auto' and contains(text(), '%s')]";

	@FindBy(xpath = "//h2//a[contains(@class, 'a-text-normal')]")
	WebElement firstSearchResult;
	String firstSearchResultXPath = "//h2//a[contains(@class, 'a-text-normal')]";

	String firstSearchResultDynamicXPath = "//span[contains(text(), '%s')]/parent::a";

	@FindBy(xpath= "//span[@id='productTitle']")
	WebElement firstSearchResultTitle;
	String firstSearchResultTitleXPath = "//span[@id='productTitle']";

	public SearchResults(WebDriver driver, ExtentTest currentTestFromInitDrPgsAndUtilsClass, ExtentReportGenerator extentReportGeneratorFromInitDrPgsAndUtilsClass, Scenario scenario) {
		super(driver, currentTestFromInitDrPgsAndUtilsClass, extentReportGeneratorFromInitDrPgsAndUtilsClass, scenario);
	}

	public WebElement getSearchPageHeader() {
		return searchPageHeader;
	}

	public String getSearchPageHeaderXPath() {
		return searchPageHeaderXPath;
	}

	//validation methods begin
	public void validatePageIsOpen(){
		Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, searchPageHeaderXPath, 0));
	}

	public void validateProperSearchPageIsOpen(String whatWasSearchedFor){
		Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, String.format(searchPageHeaderDynamicXPath, whatWasSearchedFor), 0));
	}
	//validation methods end

	//flows related to this page begin
	public void verifySearchedProduct(String searchQueryFirstLetterCapital){ //assumes that webdriver is already on search page
		Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, searchPageHeaderXPath, 0));

		String xpathToFirstResultMatch = String.format(firstSearchResultDynamicXPath, searchQueryFirstLetterCapital);
		Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, xpathToFirstResultMatch, 0));

		driver.findElement(By.xpath(xpathToFirstResultMatch)).click();

		String returnedSearchTerm = firstSearchResultTitle.getText(); //will eventually be moved to the product page object class, when it is created
		System.out.println(returnedSearchTerm);

		if(returnedSearchTerm.contains(searchQueryFirstLetterCapital)){
			System.out.println("Test passed");
		} else {
			Assert.fail("You messed up");
		}
	}
}
