//for use only in step defs. Do not reference this or its objects on page classes

package com.qa.initializeDriversPagesAndUtilsClasses;

import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.*;
import com.qa.utilFiles.coreCodeUtilFiles.ExcelReader;
import com.qa.utilFiles.coreCodeUtilFiles.ExtentReportGenerator;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class InitializeDriverPagesAndUtils {
    private WebDriver webDriver;

    private HomePageHeaderBar homePageHeaderBar;
    private Cart cart;
    private SearchResults searchResults;

    private ExcelReader excelReader;
    //ActionExecutor and ExceptionHandling utilities objects are created and used within classes themselves
    public Scenario scenario;

    //extent report objects
    private ExtentTest currentTestInitDrPgsAndUtils;
    private ExtentReportGenerator extentReportGeneratorInitDrPgsAndUtils;

    //will be using field approach for reporting (reporting objects will be fields and defined in constructors in all below classes)
    public void initializeDriverObject(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void initializeAllPagesAndUtils(ExtentTest currentTest, ExtentReportGenerator extentReportGenerator, Scenario scenario){

        //initializes the excelReader
        excelReader = new ExcelReader(currentTest, extentReportGenerator);

        //utils
        this.scenario = scenario;

        //extent reporting objects
        currentTestInitDrPgsAndUtils = currentTest;
        extentReportGeneratorInitDrPgsAndUtils = extentReportGenerator;

        //pages
        homePageHeaderBar = new HomePageHeaderBar(webDriver, currentTest, extentReportGenerator, scenario);
        cart = new Cart(webDriver, currentTest, extentReportGenerator, scenario);
        searchResults = new SearchResults(webDriver, currentTest, extentReportGenerator, scenario);
    }
    //getDrivers
    public WebDriver getWebDriver(){
        return webDriver;
    }
    //getPages
    public HomePageHeaderBar getHomePageHeaderBar() {
        return homePageHeaderBar;
    }
    public Cart getCart(){
        return cart;
    }
    public SearchResults getSearchResults() {
        return searchResults;
    }

    //getUtilities
    public ExcelReader getExcelReader() {
        return excelReader;
    }
    public Scenario getScenario(){return scenario;}
    //getExtentReportObjects
    public ExtentTest getCurrentTestInitDrPgsAndUtils() {
        return currentTestInitDrPgsAndUtils;
    }
    public ExtentReportGenerator getExtentReportGeneratorInitDrPgsAndUtils() {
        return extentReportGeneratorInitDrPgsAndUtils;
    }
}
