package com.qa.cucumberFiles.homePageHeader.stepDefFiles;

import com.qa.initializeDriversPagesAndUtilsClasses.InitializeDriverPagesAndUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class homePageHeaderStepDefs {

	InitializeDriverPagesAndUtils initDrPgsAndUtils;

	public homePageHeaderStepDefs(InitializeDriverPagesAndUtils initDrPgsAndUtils) {
		this.initDrPgsAndUtils = initDrPgsAndUtils;
	}

	@Given("User is on amazon homepage")
	public void userOnWalmartHomePage(){
		initDrPgsAndUtils.getHomePageHeaderBar().validatePageIsOpen();
	}
	@When("User searches for something in the search bar on homepage {string}")
	public void userSearchesOnHomePage(String whatToSearchFor){
		initDrPgsAndUtils.getHomePageHeaderBar().searchForSomething(whatToSearchFor);
	}
	@When ("User wants to change language to Spanish")
	public void userChangesLanguageToSpanish() {
		initDrPgsAndUtils.getHomePageHeaderBar().changeLanguageToSpanish();
	}
	@When ("User wants to search for and verify a product {string}")
	public void userSearchesForAndVerifiesAProduct(String searchQuery) {
		initDrPgsAndUtils.getHomePageHeaderBar().searchForAndVerifyProduct(searchQuery);
	}
	@When("User clicks on first 13 links in header")
	public void userClicksOnFirstThirteenHeaderLinks(){
		initDrPgsAndUtils.getHomePageHeaderBar().clickOnFirstThirteenHeaderCategories();
	}
	@When("User adds zip code {string} and verifies its appearance on the home page")
	public void addAndVerifyZipCode(String zipCode){
		initDrPgsAndUtils.getHomePageHeaderBar().changeAndValidateAddressViaHeader(zipCode);
	}
}