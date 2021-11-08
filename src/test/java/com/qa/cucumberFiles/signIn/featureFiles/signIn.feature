Feature: FeatureToExecute

  Scenario: userGoesToTheSignInPage
    Given Execution solution is started and driver is initialized for the test case "someString"
    Given User is on amazon homepage
    When User wants to navigate to the sign in page

  Scenario Outline: userGoesToTheSignInPageAndUsesBogusEmailToLogIn
    Given Execution solution is started and driver is initialized for the test case "someString"
    Given User wants to navigate to the sign in page
    When User uses a bogus email "<bogusEmail>" to sign into amazon

    Examples:
      |bogusEmail|
      |.com|
      |.com|
      |.com|
      |.net|
      |.com|
