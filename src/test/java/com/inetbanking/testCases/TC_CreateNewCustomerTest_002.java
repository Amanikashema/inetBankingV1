package com.inetbanking.testCases;

import com.inetbanking.pageObjects.CreateNewCustomerPage;
import org.testng.annotations.Test;

public class TC_CreateNewCustomerTest_002 extends BaseClass {
    @Test
    public void createNewCustomer (){
        CreateNewCustomerPage cncp = new CreateNewCustomerPage(driver);
        // click the new customer link
        cncp.clickNewCustomerBtn();
    }

}
