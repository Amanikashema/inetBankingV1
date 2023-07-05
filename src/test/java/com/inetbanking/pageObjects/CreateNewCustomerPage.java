package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCustomerPage {
    WebDriver local_driver;

    public CreateNewCustomerPage(WebDriver remote_driver){
        local_driver = remote_driver;
        PageFactory.initElements(remote_driver, this);
    }

    // Finding Create New customer web elements
    @FindBy(linkText = "New Customer")
    WebElement newCustomerLink;


    // Methods to perform action
    public void clickNewCustomerBtn(){
        newCustomerLink.click();
    }


}
