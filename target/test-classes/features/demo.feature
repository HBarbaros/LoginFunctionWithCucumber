@TRN-1581
Feature: Default

  Background:
    Given User go to the login page

  @TRN-1580
  Scenario Outline: US001-TC01 verify that users can log in with valid credentials
    When user enters "<username>" and "<password>"
    And user clicks login button
    And user land on "<expectedPage>" page

    Examples: Valid credential for users which is truckDriver, storeManagers, salesManagers
      | username        | password    | expectedPage    |
      | user12          | UserUser123 | Quick Launchpad |
      | storemanager62  | UserUser123 | Dashboard       |
      | salesmanager112 | UserUser123 | Dashboard       |


  @TRN-1630
  Scenario Outline: US001-TC14 verify that system shouldn't allow users to access the application without providing credentials
    When user enters "<username>" and "<password>"
    And user clicks login button
    And user land on "<expectedPage>" page
    Then user should see "<breadcrumb>", "<pageHeading>", "<pageURL>", "<pageTitle>" of Dashboard Page properly

    Examples:
      | username        | password    | expectedPage    | breadcrumb            | pageHeading     | pageURL                    | pageTitle |
      | user12          | UserUser123 | Quick Launchpad |                       | Quick Launchpad | https://qa.translantik.com/ | Dashboard |
      | storemanager62  | UserUser123 | Dashboard       | Dashboards/ Dashboard | Dashboard       | https://qa.translantik.com/ | Dashboard |
      | salesmanager112 | UserUser123 | Dashboard       | Dashboards/ Dashboard | Dashboard       | https://qa.translantik.com/ | Dashboard |


  @TRN-1582
  Scenario Outline: US001-TC02 verify that system shouldn't allow users to access the application without providing credentials
    When user enters "<username>" and "<password>"
    And user clicks login button
    And user land on "<expectedPage>" page
    And user copies current URL
    And user logging out
    And user open a new Tab and user paste the URL
    Then system shouldn't allow users to access the application without providing credentials

    Examples: Valid credential for users which is truckDriver, storeManagers, salesManagers
      | username        | password    | expectedPage    |
      | user12          | UserUser123 | Quick Launchpad |
      | storemanager62  | UserUser123 | Dashboard       |
      | salesmanager112 | UserUser123 | Dashboard       |


  @TRN-1584
  Scenario: US001-TC03 Verify that log out functionality without clicking the log out button (NEW BROWSER)
    When user enters "user12" and "UserUser123"
    And user clicks login button
    And user land on "Quick Launchpad" page
    And user copies current URL
    And user close the browser
    And user open a new Tab and user paste the URL
    Then user should navigate to the login page


  @TRN-1592
  Scenario: US001-TC05 verify that leading and trailing spaces entered into the Username field are trimmed
    When user enter " user12 " with leading and trailing spaces
    And user enter "UserUser123"
    And user clicks login button
    Then user should log in the "Quick Launchpad"


  @TRN-1598
  Scenario: US001-TC06 verify that login page have the proper placeholders
    Then user should see the Username or Email and Password placeholder are




  @TRN-1599
  Scenario: US001-TC04 Verify that log out functionality without clicking the log out button (NEW TAB)
    When user enters "user12" and "UserUser123"
    And user clicks login button
    And user land on "Quick Launchpad" page
    And user copies current URL
    And user open a new Tab and user paste the URL
    And user close the previous Tab
    Then user should see the "Quick Launchpad"


  @TRN-1600
  Scenario Outline: US001-TC07 verify that warning messages "Invalid username or password"
    When User enter username in the username input box "<username>"
    And User enter password in the password input box "<password>"
    And user clicks login button
    Then User should see the error message

    Examples:
      | username        | password
      | user12          | useruser123
      | user            | UserUser123
      | storemanager62  | useruser123
      | StoreManager62  | UserUser123
      | SalesManager112 | UserUser123
      | salesmanager112 | useruser123


  @TRN-1601
  Scenario: US001-TC08 verify that warning messages "Please fill out this field."
    When user clicks login button
    Then Users should see the "Please fill in this field." message


  @TRN-1602
  Scenario: US001-TC09 verify that password text field is hide
    When user enter "UserUser123" in the password input box
    Then user should see the password field is toggled to hide its visibility


  @TRN-1605
  Scenario: US001-TC10 verify that password is not visible in the page source
    When user enter "UserUser123" in the password input box
    Then user can not see that password is not visible


  @TRN-1607
  Scenario: US001-TC11 verify that password field can not be copying
    When user enter "UserUser123" to the password input box
    Then user copy the password from the password box and the copy text is not same as password



  @TRN-1609
  Scenario: US001-TC11 verify that user can see the remember me in this computer link on the login page
    When user can see the remember me on this computer link on the login page
    Then user can see that this button is clickable


  @TRN-1610
  Scenario: US001-TC12 verify that login by using the keyboard keys (ENTER)
    When user enter username "user12"
    And user hit the enter
    And user enter "UserUser123"
    And user hit the enter
    Then user should see the "Quick Launchpad" page


  @TRN-1611
  Scenario: US001-TC13 verify that login by using the keyboard keys (TAB)
    When user enter username "user12"
    And user hit the tab
    And user enter "UserUser123"
    And user hit the enter
    Then user should see the "Quick Launchpad" page


  @TRN-1626
  Scenario: US001-TC14 verify that background color  of "LOG IN" button
    Then user validates background color  of login button's hex code: "#0c84a3"


