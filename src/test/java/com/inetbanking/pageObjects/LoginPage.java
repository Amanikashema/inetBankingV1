package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver local_driver;

   public LoginPage(WebDriver remote_driver){
        local_driver = remote_driver;
        PageFactory.initElements(remote_driver, this);

    }

    /* Finding Login Page Web Elements */
    @FindBy(name="uid")
    @CacheLookup
    WebElement txtUserName;

    @FindBy(name="password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(name="btnLogin")
    @CacheLookup
    WebElement loginButton;

    /* Action Method on the Web Elements */
    public void setUserName(String uname){
        txtUserName.sendKeys(uname);
    }

    public void setPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void clickSubmit(){
        loginButton.click();
    }

}
