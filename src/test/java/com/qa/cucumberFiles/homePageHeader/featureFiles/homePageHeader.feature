Feature: FeatureToExecute

    Scenario Outline: NameOfScenario_MustBeExactMatchOnExcelForAppend
        Given Execution solution is started and driver is initialized for the test case "someString"
        Given User is on walmart homepage
        When User searches for something in the search bar on homepage "<whatToSearchFor>"

    Examples:
        |whatToSearchFor|
        |clothes               |
        |washing machine               |
        |oil               |
        |donuts               |

    Scenario: NameOfScenario_MustBeExactMatchOnExcelForAppend
        Given Execution solution is started and driver is initialized for the test case "someString"
        Given User is on walmart homepage
        When User searches for something in the search bar on homepage "clothes"
