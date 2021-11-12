Feature: FeatureToExecute

  Scenario: userChangesLanguageToSpanish
        Given Execution solution is started and driver is initialized for the test case "someString"
        When User wants to change language to Spanish


    Scenario: UserClicksOnThirteenHeaderLinks
        Given Execution solution is started and driver is initialized for the test case "SomeString"
        When User clicks on first 13 links in header

    Scenario Outline: userChangesAndVerifiesZipCodeOnAmazonHomePage
        Given Execution solution is started and driver is initialized for the test case "someString"
        Given User is on amazon homepage
        When User adds zip code "<zipCode>" and verifies its appearance on the home page

    Examples:
        |zipCode|
        |76225               |
        |11432               |
        |89119               |
        |14214               |

    Scenario Outline: userSearchesForAndVerifiesProductOnSearchBar
        Given Execution solution is started and driver is initialized for the test case "someString"
        When User wants to search for and verify a product "<searchedProduct>"

    Examples:
        |searchedProduct|
        |bleach         |
        |washing machine|
        |cookie       |
        |bicycle          |



    Scenario Outline: userSearchesForSomethingInTheSearchBar
        Given Execution solution is started and driver is initialized for the test case "someString"
        Given User is on amazon homepage
        When User searches for something in the search bar on homepage "<whatToSearchFor>"

    Examples:
        |whatToSearchFor|
        |clothes               |
        |washing machine               |
        |oil               |
        |donuts               |

    Scenario: userSearchesForClothesOnAmazonSearchBar
        Given Execution solution is started and driver is initialized for the test case "someString"
        Given User is on amazon homepage
        When User searches for something in the search bar on homepage "clothes"

