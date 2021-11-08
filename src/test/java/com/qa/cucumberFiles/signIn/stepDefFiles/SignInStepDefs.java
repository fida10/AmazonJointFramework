package com.qa.cucumberFiles.signIn.stepDefFiles;

import com.qa.initializeDriversPagesAndUtilsClasses.InitializeDriverPagesAndUtils;
import com.qa.pages.AmazonSignInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class SignInStepDefs {
    InitializeDriverPagesAndUtils initDrPgsAndUtils;

    public SignInStepDefs(InitializeDriverPagesAndUtils initDrPgsAndUtils) {
        this.initDrPgsAndUtils = initDrPgsAndUtils;
    }

    @When("User wants to navigate to the sign in page")
    public void userNavigatesToTheSignInPage() {
        initDrPgsAndUtils.getAmazonSignInPage().navigateToSignInPage();
    }
    @When("User uses a bogus email {string} to sign into amazon")
    public void userUsesBogusEmailToSignIntoAmazon(String randomEmail) {
        initDrPgsAndUtils.getAmazonSignInPage().signInWithIncorrectEmail(randomEmail);

    }
}