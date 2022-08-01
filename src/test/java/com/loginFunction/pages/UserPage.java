package com.loginFunction.pages;

import com.loginFunction.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage extends BasePage{

    public UserPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement pageHeading;

    @FindBy(id = "breadcrumb")
    public WebElement breadcrumb;

    @FindBy (xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement logout;

    @FindBy (xpath = "//a[@class='no-hash']")
    public WebElement logoutButton;

    @FindBy(xpath = "//input[@placeholder='Username or Email']")
    public WebElement usernamePlaceHolder;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordPlaceHolder;

}
