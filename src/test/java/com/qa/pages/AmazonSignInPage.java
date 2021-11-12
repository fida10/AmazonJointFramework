package com.qa.pages;

import com.aventstack.extentreports.ExtentTest;
import com.qa.utilFiles.coreCodeUtilFiles.ExtentReportGenerator;
import io.cucumber.java.Scenario;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class AmazonSignInPage extends somePageTemplate   {

    @FindBy(xpath = "//div[@class='a-section']//h1[contains(text(),'Sign-In')]")
    WebElement signInHeader;
    String signInHeaderXPath = "//div[@class='a-section']//h1[contains(text(),'Sign-In')]";

    @FindBy(xpath = "//input[@id='ap_email']")
    WebElement emailEntryBox;
    String emailEntryBoxXPath = "//input[@id='ap_email']";

    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;
    String continueButtonXPath = "//input[@id='continue']";

    @FindBy(xpath = "//div[@id='auth-error-message-box']")
    WebElement incorrectEmailEnteredDialogue;
    String incorrectEmailEnteredDialogueXPath = "//div[@id='auth-error-message-box']";

    public WebElement getSignInHeader() {
        return signInHeader;
    }

    public String getSignInHeaderXPath() {
        return signInHeaderXPath;
    }

    public WebElement getEmailEntryBox() {
        return emailEntryBox;
    }

    public String getEmailEntryBoxXPath() {
        return emailEntryBoxXPath;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public String getContinueButtonXPath() {
        return continueButtonXPath;
    }

    public WebElement getIncorrectEmailEnteredDialogue() {
        return incorrectEmailEnteredDialogue;
    }

    public String getIncorrectEmailEnteredDialogueXPath() {
        return incorrectEmailEnteredDialogueXPath;
    }


    public AmazonSignInPage(WebDriver driver, ExtentTest currentTestFromInitDrPgsAndUtilsClass, ExtentReportGenerator extentReportGeneratorFromInitDrPgsAndUtilsClass, Scenario scenario) {
        super(driver, currentTestFromInitDrPgsAndUtilsClass, extentReportGeneratorFromInitDrPgsAndUtilsClass, scenario);

    }

    //Validation methods begin
    public void validatePageIsOpen(){

        Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, signInHeaderXPath, 0));
    }
    // Validation methods end

    //flows on this page begin

    public void navigateToSignInPage(){
        Actions a = new Actions(driver);
        HomePageHeaderBar homePageHeaderBar = new HomePageHeaderBar(driver, currentTest, extentReportGenerator, scenario);

        a
                .moveToElement(homePageHeaderBar.getSignInHoverMenu())
                .build()
                .perform();
        Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, homePageHeaderBar.getSignInButtonXPath(),0));
        homePageHeaderBar.getSignInButton().click();

        actionExecutor.waitFiveSeconds();
        Assert.assertTrue(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver,signInHeaderXPath,0).getText().contains("Sign-In"));
        System.out.println(signInHeader.getText());


    }

    private String randomisedString() {
        String stringRandom = RandomStringUtils.randomAlphanumeric(10);
        return stringRandom.toString();
    }

    public void signInWithIncorrectEmail(String randomEmail){
        HomePageHeaderBar homePageHeaderBar = new HomePageHeaderBar(driver, currentTest, extentReportGenerator, scenario);

        Actions b = new Actions(driver);
        Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver, emailEntryBoxXPath,0));

        b
                .sendKeys(randomisedString().concat("@").concat(randomisedString()).concat(randomEmail))
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        Assert.assertNotNull(exceptionHandling.combinedStaleAndIsElementDisplayedHandling(driver,incorrectEmailEnteredDialogueXPath,0));
        System.out.println(incorrectEmailEnteredDialogue.getText());




    }





}
