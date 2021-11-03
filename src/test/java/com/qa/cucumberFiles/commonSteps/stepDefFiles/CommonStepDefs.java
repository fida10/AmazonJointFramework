package com.qa.cucumberFiles.commonSteps.stepDefFiles;

import com.qa.initializeDriversPagesAndUtilsClasses.InitializeDriverPagesAndUtils;
import com.qa.utilFiles.coreCodeUtilFiles.GetPropertiesFromSysOrConfig;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.java.en.Given;

import static com.qa.testNG.Listeners.*;

public class CommonStepDefs {

    // PREFILLED WITH TESTRAIL INTEGRATION METHODS AND STEPS. DELETE IF THIS IS UNDESIRABLE.
    private String testRailsTestCaseUniqueID;
    private boolean isTestCaseIDValid;
    InitializeDriverPagesAndUtils initDrPgsAndUtils;
    public CommonStepDefs(InitializeDriverPagesAndUtils initDrPgsAndUtils){
        this.initDrPgsAndUtils = initDrPgsAndUtils;
    }

    @Given("Current test scenario is supported by application {string} {string}") //if "~~unsupported~~" string exists in this column, this test case will be skipped
    //testRails portion is only being done at this point because testrail test ID needs to be obtained from excel, so initializing and closing testrail here rather than initDrPgsAndUtils
    public void currentTestScenarioIsSupportedByApplication(String testCaseTitle_TestRails, String testCaseID_TestRails){
    }
    //test rails integration 'after' hook
    @After
    public void setTestRailsCaseStatus(Scenario passFail){

    }
}
