Feature: FeatureToExecute

    Scenario: UserClicksOnThirteenHeaderLinks
        Given Execution solution is started and driver is initialized for the test case "SomeString"
        When User clicks on first 13 links in header

    Scenario Outline: NameOfScenario_MustBeExactMatchOnExcelForAppend
        Given Execution solution is started and driver is initialized for the test case "someString"
        Given User is on amazon homepage
        When User adds zip code "<zipCode>" and verifies its appearance on the home page

    Examples:
        |zipCode|
        |76225               |
        |11432               |
        |89119               |
        |14214               |

    Scenario Outline: NameOfScenario_MustBeExactMatchOnExcelForAppend
        Given Execution solution is started and driver is initialized for the test case "someString"
        Given User is on amazon homepage
        When User searches for something in the search bar on homepage "<whatToSearchFor>"

    Examples:
        |whatToSearchFor|
        |clothes               |
        |washing machine               |
        |oil               |
        |donuts               |

    Scenario: NameOfScenario_MustBeExactMatchOnExcelForAppend
        Given Execution solution is started and driver is initialized for the test case "someString"
        Given User is on amazon homepage
        When User searches for something in the search bar on homepage "clothes"

