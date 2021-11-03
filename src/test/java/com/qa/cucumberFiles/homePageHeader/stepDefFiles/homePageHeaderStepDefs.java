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

	@Given("User is on walmart homepage")
	public void userOnWalmartHomePage(){
		initDrPgsAndUtils.getHomePageHeaderBar().validatePageIsOpen();
	}
	@When("User searches for something in the search bar on homepage {string}")
	public void userSearchesOnHomePage(String whatToSearchFor){
		initDrPgsAndUtils.getHomePageHeaderBar().searchForSomething(whatToSearchFor);
	}
}