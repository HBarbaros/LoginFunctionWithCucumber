package com.loginFunction.pages;

import com.loginFunction.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-error']//div")
    public WebElement invalidUsernameOrPasswordError;

    @FindBy(xpath = "//input[@id='prependedInput']")
    public WebElement placeholderUsername;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement placeholderPassword;

    @FindBy (xpath = "//span[@class='custom-checkbox__text']")
    public WebElement rememberMeLink;


}
