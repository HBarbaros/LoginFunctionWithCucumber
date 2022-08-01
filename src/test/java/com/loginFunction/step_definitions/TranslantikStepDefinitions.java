package com.loginFunction.step_definitions;

import com.loginFunction.pages.LoginPage;
import com.loginFunction.pages.UserPage;
import com.loginFunction.utilities.BrowserUtils;
import com.loginFunction.utilities.ConfigurationReader;
import com.loginFunction.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TranslantikStepDefinitions {



    LoginPage loginPage = new LoginPage();
    UserPage userPage = new UserPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);


    @Given("User go to the login page")
    public void userGoToTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("translantikURL"));
    }

    @When("user enters {string} and {string}")
    public void userEntersAnd(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        loginPage.loginButton.click();
    }

    @And("user land on {string} page")
    public void userLandOnPage(String expectedPageHeading) {
        wait.until(ExpectedConditions.visibilityOf(userPage.pageHeading));
        String actualPageHeading = userPage.pageHeading.getText();
        Assert.assertEquals(expectedPageHeading.toLowerCase(), actualPageHeading.toLowerCase());
    }
    @Then("user should see {string}, {string}, {string}, {string} of Dashboard Page properly")
    public void user_should_see_of_dashboard_page_properly(String breadcrumb, String pageHeading, String pageURL, String title) {
        BrowserUtils.waitFor(3);
        Assert.assertEquals(breadcrumb, userPage.breadcrumb.getText());
        Assert.assertEquals(pageHeading, userPage.pageHeading.getText());
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(pageURL));
        Assert.assertTrue(Driver.getDriver().getTitle().equals(title));
        //System.out.println("Driver.getDriver().getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());
        //System.out.println("pageURL = " + pageURL);
    }


    String copyURL = "";

    @And("user copies current URL")
    public void userCopiesCurrentURL() throws InterruptedException {
        copyURL = Driver.getDriver().getCurrentUrl();
        Thread.sleep(5000);
    }

    @And("user logging out")
    public void userLoggingOut() throws InterruptedException {
        userPage.logout.click();
        Thread.sleep(5000);
        userPage.logoutButton.click();
    }

    @And("user open a new Tab and user paste the URL")
    public void userOpenANewBrowser() {
        //Open new tab
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.open();");
        Driver.getDriver().get(copyURL);
    }



    @Then("system shouldn't allow users to access the application without providing credentials")
    public void systemShouldnTAllowUsersToAccessTheApplicationWithoutProvidingCredentials() {
        String expectedURL = ConfigurationReader.getProperty("translantikURL");
        BrowserUtils.sleep(2);
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
    }

    @And("user close the browser")
    public void userCloseTheBrowser() {
        Driver.closeDriver();
    }

    @Then("user should navigate to the login page")
    public void userShouldNavigateToTheLoginPage() {
        String expectedURL = "https://qa.translantik.com/user/login";
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL );
    }

    @When("user enter {string} with leading and trailing spaces")
    public void userEnterWithLeadingAndTrailingSpaces(String username) {
        loginPage.usernameInput.sendKeys(username);
    }

    @When("user enter username {string}")
    public void userEnterUsername(String username) {
        loginPage.usernameInput.sendKeys(username);
    }

    @And("user enter {string}")
    public void userEnter(String password) {
        loginPage.passwordInput.sendKeys(password);
    }


    @Then("user should log in the {string}")
    public void userShouldLogInThe(String quickLaunchpad) {
        wait.until(ExpectedConditions.visibilityOf(userPage.pageHeading));
        String actualPageHeading = userPage.pageHeading.getText();
        Assert.assertEquals(quickLaunchpad.toLowerCase(), actualPageHeading.toLowerCase());
    }

    @Then("user should see the Username or Email and Password placeholder are")
    public void userShouldSeeTheAndPlaceholderAre() {
        String expectedPlaceholderForUsernameInputBox = "Username or Email";
        String actualPlaceholderForUsernameInputBox = userPage.usernamePlaceHolder.getAttribute("placeholder");
        Assert.assertEquals(expectedPlaceholderForUsernameInputBox, actualPlaceholderForUsernameInputBox);
        Assert.assertTrue(userPage.usernamePlaceHolder.isDisplayed());

        String expectedPlaceholderForPasswordInputBox = "Password";
        String actualPlaceholderForPasswordInputBox = userPage.passwordPlaceHolder.getAttribute("placeholder");
        Assert.assertEquals(expectedPlaceholderForPasswordInputBox, actualPlaceholderForPasswordInputBox);
        Assert.assertTrue(userPage.passwordPlaceHolder.isDisplayed());
    }

    @And("user open a new Tab")
    public void userOpenANewTab() {
        //Open new tab
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.open();");

    }

    @And("user close the previous Tab")
    public void userCloseThePreviousTab() {
        //handling multiple tabs with an ArrayList
        ArrayList<String> windowHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowHandles.get(0));
        Driver.getDriver().close();
        Driver.getDriver().switchTo().window(windowHandles.get(0));
        Driver.getDriver().get(copyURL);
    }

    @Then("user should see the {string}")
    public void userShouldSeeThe(String quickLaunchpad) {
        wait.until(ExpectedConditions.visibilityOf(userPage.pageHeading));
        String actualPageHeading = userPage.pageHeading.getText();
        Assert.assertEquals(quickLaunchpad.toLowerCase(), actualPageHeading.toLowerCase());
    }

    @When("User enter username in the username input box {string}")
    public void userEnterUsernameInTheUsernameInputBox(String username) {
        loginPage.usernameInput.sendKeys(username);
    }

    @And("User enter password in the password input box {string}")
    public void userEnterPasswordInThePasswordInputBox(String password) {
        loginPage.passwordInput.sendKeys(password);
    }

    @Then("User should see the error message")
    public void userShouldSeeTheErrorMessage() {
        loginPage.invalidUsernameOrPasswordError.isDisplayed();
    }

    @Then("Users should see the {string} message")
    public void usersShouldSeeTheMessage(String errorMessage) {
       String validationMessageForUs =  loginPage.usernameInput.getAttribute("validationMessage");
       String validationMessageForPas =  loginPage.passwordInput.getAttribute("validationMessage");

       if (errorMessage.equals(validationMessageForUs)){
           Assert.assertEquals(validationMessageForUs, errorMessage);
       }else {
           Assert.assertEquals(validationMessageForPas, errorMessage);
       }

    }

    @When("user enter {string} in the password input box")
    public void userEnterInThePasswordInputBox(String password) {
        loginPage.passwordInput.sendKeys(password);
    }

    @Then("user should see the password field is toggled to hide its visibility")
    public void userShouldSeeThePasswordFieldIsToggledToHideItsVisibility() {
        String actualTypeAttributeText = loginPage.placeholderPassword.getAttribute("type");
        String expectedTypeAttributeText = "password";
        Assert.assertEquals(expectedTypeAttributeText, actualTypeAttributeText);
    }

    @Then("user can not see that password is not visible")
    public void userCanNotSeeThatPasswordIsNotVisible() {
        String typeAttribute = loginPage.passwordInput.getAttribute("type");
        Assert.assertEquals(typeAttribute, "password");

    }

    @When("user enter {string} to the password input box")
    public void userEnterToThePasswordInputBox(String password) {
        loginPage.passwordInput.sendKeys(password);
    }


    @Then("user copy the password from the password box and the copy text is not same as password")
    public void theCopyTextIsNotSameAsPassword() throws IOException, UnsupportedFlavorException {
        //loginPage.passwordInput.getAttribute("value");
        BrowserUtils.waitFor(3);
        loginPage.passwordInput.sendKeys(Keys.chord(Keys.CONTROL, "A"));
        loginPage.passwordInput.sendKeys(Keys.chord(Keys.CONTROL, "C"));
        String localClipboardData = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        Assert.assertNotEquals(ConfigurationReader.getProperty("valid.password"), localClipboardData);
        System.out.println(localClipboardData);
    }

    @When("user can see the remember me on this computer link on the login page")
    public void userCanSeeTheRememberMeOnThisComputerLinkOnTheLoginPage() {
        loginPage.rememberMeLink.isDisplayed();
    }

    @Then("user can see that this button is clickable")
    public void userCanSeeThatThisButtonIsClickable() {
        BrowserUtils.clickWithJS(loginPage.rememberMeLink);
        //loginPage.rememberMeLink.click();
        Assert.assertTrue(loginPage.rememberMeLink.isDisplayed());
    }

    @And("user hit the enter")
    public void userHitTheEnter() {
        loginPage.usernameInput.sendKeys(Keys.ENTER);
    }

    @Then("user should see the {string} page")
    public void userShouldSeeThePage(String quickLaunchpad) {
        wait.until(ExpectedConditions.visibilityOf(userPage.pageHeading));
        String actualPageHeading = userPage.pageHeading.getText();
        Assert.assertEquals(quickLaunchpad.toLowerCase(), actualPageHeading.toLowerCase());
    }

    @And("user hit the tab")
    public void userHitTheTab() {
        loginPage.usernameInput.sendKeys(Keys.TAB);
    }

    @Then("user validates background color  of login button's hex code: {string}")
    public void userValidatesBackgroundColorOfLoginButtonSHexCode(String expectedHexCode) {
        String s = loginPage.loginButton.getCssValue("background-color");
        String c = Color.fromString(s).asHex();
        System.out.println("Color is :" + s);
        System.out.println("Hex code for color:" + c);
        Assert.assertEquals(expectedHexCode, c);
    }


}
